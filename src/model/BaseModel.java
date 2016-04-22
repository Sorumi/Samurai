package model;

import java.util.Observable;

import javafx.application.Platform;

/**
 * 基础Model类，继承Observable方法，所有Model的父类。使Observer可以向其注册，监听数据变化.
 * @author Sorumi
 *
 */
public class BaseModel extends Observable {
	
	/**
	 * 通知更新方法，请在子类中需要通知Observer的地方调用此方法
	 * @param data
	 */
	protected void updateChange(UpdateMessage message){
		Platform.runLater(new Runnable(){
  			@Override
  			public void run() {
  				BaseModel.super.setChanged();
  				BaseModel.super.notifyObservers(message);
  			}
  		});

	}
}
