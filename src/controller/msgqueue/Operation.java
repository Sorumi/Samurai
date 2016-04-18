package controller.msgqueue;

import model.GameModel;

import java.io.Serializable;

/**
 * 所有操作的父类
 * @author 
 *
 */

public abstract class Operation implements Serializable {

	private static boolean isServer = false;

	public abstract void execute();

	public Operation(){
		if(!GameModel.isServer()) {
			isServer = false;
		}
		if(GameModel.isServer()) {
			isServer = true;
		}
	}

	public static boolean isServer(){
		return isServer;
	}

	public static void setServer(boolean server){
		isServer = server;
	}
}
