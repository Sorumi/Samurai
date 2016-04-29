package model.po;

import java.io.Serializable;

//Tag 指的是材料的种类 0布料 1木头。。。。。
//Item 指的是材料的等级 0 1 2 3
public class MaterialLibrary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] cloth = new int[4];
	private int[] wood = new int[4];
	private int[] stone = new int[4];
	private int[] metal = new int[4];
	private int[] crystal = new int[4];

	// 传入材料的种类、等级
	// 返回该材料的数量
	public int getNumber(int tag, int item) {
		switch (tag) {
		case 0:
			return cloth[item];
		case 1:
			return wood[item];
		case 2:
			return stone[item];
		case 3:
			return metal[item];
		case 4:
			return crystal[item];
		default:
			System.out.println("No such material!");
			return 0;
		}
	}

	// 这个方法是制造武器时候所要调用的方法
	// 传入的参数是一组材料的种类、等级、数量 查看是否够
	public boolean checkEnough(int[] tag, int[] item, int[] number) {
		for (int i = 0; i < tag.length; i++) {
			switch (tag[i]) {
			case 0:
				if (cloth[item[i]] + number[i] >= 0) {
					break;
				} else {
					return false;
				}

			case 1:

				if (wood[item[i]] + number[i] >= 0) {
					break;
				} else {
					return false;
				}
			case 2:

				if (stone[item[i]] + number[i] >= 0) {
					break;
				} else {
					return false;
				}
			case 3:

				if (metal[item[i]] + number[i] >= 0) {
					break;
				} else {
					return false;
				}
			case 4:

				if (crystal[item[i]] + number[i] >= 0) {
					break;
				} else {
					return false;
				}

			default:
				System.out.println("No such material!");
				return false;
			}
		}
		return true;
	}

	// 参数表征着材料的种类、等级 更改的数量
	// 如果减少 传入负数即可
	public boolean changeItem(int tag, int item, int number) {
		switch (tag) {
		case 0:
			if (cloth[item] + number >= 0) {
				cloth[item] += number;
				return true;
			} else {
				return false;
			}

		case 1:

			if (wood[item] + number >= 0) {
				wood[item] += number;
				return true;
			} else {
				return false;
			}
		case 2:

			if (stone[item] + number >= 0) {
				stone[item] += number;
				return true;
			} else {
				return false;
			}
		case 3:

			if (metal[item] + number >= 0) {
				metal[item] += number;
				return true;
			} else {
				return false;
			}
		case 4:

			if (crystal[item] + number >= 0) {
				crystal[item] += number;
				return true;
			} else {
				return false;
			}

		default:
			System.out.println("No such material!");
			return false;
		}
	}
}
