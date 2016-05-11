package controller.msgqueue;

import model.GameModel;
import model.UpdateMessage;
import network.client.ClientService;
import network.client.ClientServiceImpl;
import network.server.HostService;
import network.server.HostServiceImpl;

import java.io.Serializable;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 操作队列，所有的操作需要加入队列，该队列自行按操作到达的先后顺序处理操作。
 * @author Kray
 *
 */

public class OperationQueue implements Runnable, Serializable {

	private static BlockingQueue<Operation> queue;
	private static GameModel gameModel;
	public static boolean isRunning;

	ClientService clientService = new ClientServiceImpl();
	HostService hostService = new HostServiceImpl();

	public OperationQueue(GameModel model){
		queue = new ArrayBlockingQueue<>(1000);
		isRunning = true;
		gameModel = model;
	}

	public void run() {
		while(isRunning && !Thread.currentThread().isInterrupted()){
			Operation operation = getNewOperation();

			if (operation instanceof EndOperation){
				operation.execute();
				Thread.interrupted();
			}else {

				System.out.println("execute Operation : " + operation.getClass());
				UpdateMessage updateMessage = new UpdateMessage("execute", operation);

				if (GameModel.isClient() && !Operation.isServer()) {
					clientService.submitOperation(operation);
				} else if (GameModel.isServer() && Operation.isServer()) {
					hostService.update(gameModel, updateMessage);
				}

				//迫不得已才加在这里..
				if (gameModel.getLevel() != 0 && gameModel.getCurrentSamurai() >= 4) {
					if (operation instanceof ActionOperation
							|| operation instanceof NextOperation) {
						try {
							Thread.sleep(2400);
						} catch (Exception E) {
							E.printStackTrace();
						}
					}
				}

				operation.execute();

			}
		}
	}

	public static boolean addOperation (Operation operation){
		try {
			queue.put(operation);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private static Operation getNewOperation (){
		Operation operation = null;
		try {
			operation = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return operation;
	}

	public static GameModel getGameModel(){
		return gameModel;
	}

}
