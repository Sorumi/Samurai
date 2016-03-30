package controller.msgqueue;

import model.GameModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 操作队列，所有的操作需要加入队列，该队列自行按操作到达的先后顺序处理操作。
 * @author Kray
 *
 */

public class OperationQueue implements Runnable{
	
	private static BlockingQueue<Operation> queue;
	private static GameModel gameModel;
	public static boolean isRunning;
	public static boolean singleUpdateSwitch = true;

	public OperationQueue(GameModel model){
		queue = new ArrayBlockingQueue<Operation>(1000);
		isRunning = true;
		gameModel = model;
	}

	public void run() {
		while(isRunning){
			Operation operation = getNewOperation();
			operation.execute();
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
		Operation  operation = null;
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
