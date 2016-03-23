package controller.msgqueue;

import java.io.Serializable;

/**
 * 所有操作的父类
 * @author 
 *
 */

public abstract class Operation implements Serializable {
	public abstract void execute();
}
