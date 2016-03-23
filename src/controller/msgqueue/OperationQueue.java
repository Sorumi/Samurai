package controller.msgqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 操作队列，所有的操作需要加入队列，该队列自行按操作到达的先后顺序处理操作。
 * @author 
 *
 */

public class OperationQueue implements Runnable{
	
	private static BlockingQueue<Operation> queue;
	public static boolean isRunning;
	public static boolean singleUpdateSwitch = true;
	
	//构造方法
	public OperationQueue(){
		queue = new ArrayBlockingQueue<Operation>(1000);
		isRunning = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			Operation operation = getNewOperation();
			operation.execute();
		}
	}
	
	public static boolean addOperation (Operation operation){
		try {
			queue.put(operation);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return operation;
	}

	
}
