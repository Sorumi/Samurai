package model.po;

import java.util.Random;

public class ScoreBoard {
	private int[] materialTag = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	private int[] materialItem = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	private String Rating;
	private Random random = new Random();

	public boolean caculateMaterial(int checkPoint, int level, int block, int ourKill, int enemyKill) {
		// 判断评级
		if (block >= 60 && ourKill >= 3 && enemyKill == 0) {
			Rating = "SSS";
		} else if (block >= 40 && ourKill >= 1 && enemyKill == 0) {
			Rating = "SS";
		} else if (block >= 30 && enemyKill == 0) {
			Rating = "S";
		} else if (block >= 20 && enemyKill <= 2) {
			Rating = "A";
		} else if (block >= 10 && enemyKill <= 3) {
			Rating = "B";
		} else if (block >= 0) {
			Rating = "C";
		} else if (block >= -20 && enemyKill <= 5) {
			Rating = "D";
		} else {
			Rating = "F";
		}
		//
		switch (level) {
		case 0:
			switch (Rating) {
			case "SSS":
				lowGain(10, checkPoint);
				break;
			case "SS":
				lowGain(8, checkPoint);
				break;
			case "S":
				lowGain(6, checkPoint);
				break;
			case "A":
				lowGain(4, checkPoint);
				break;
			case "B":
				lowGain(2, checkPoint);
				break;
			default:
				// 传送得不到材料的消息
				System.out.println("Rating is so low that you can't get anything");
				break;
			}
			break;
		case 1:
			switch (Rating) {
			case "SSS":
				mediumGain(10, checkPoint);
				break;
			case "SS":
				mediumGain(8, checkPoint);
				break;
			case "S":
				mediumGain(6, checkPoint);
				break;
			case "A":
				mediumGain(4, checkPoint);
				break;
			case "B":
				mediumGain(2, checkPoint);
				break;
			default:
				// 传送得不到材料的消息
				System.out.println("Rating is so low that you can't get anything");
				break;
			}
			break;
		case 2:
			switch (Rating) {
			case "SSS":
				highGain(10, checkPoint);
				break;
			case "SS":
				highGain(8, checkPoint);
				break;
			case "S":
				highGain(6, checkPoint);
				break;
			case "A":
				highGain(4, checkPoint);
				break;
			case "B":
				highGain(2, checkPoint);
				break;
			default:
				// 传送得不到材料的消息
				System.out.println("Rating is so low that you can't get anything");
				break;
			}
			break;
		default:
			System.out.println("Illegal arguments!");
			return false;
		}
		return true;
	}

	private void lowGain(int count, int checkPoint) {
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 30) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 60) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 80) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 0;
			} else {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 1;
			}
		}
	}

	private void mediumGain(int count, int checkPoint) {
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 25) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 50) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 65) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 0;
			} else if (cache <= 80) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 1;
			} else if (cache <= 95) {
				materialTag[i] = checkPoint;
				materialItem[i] = 2;
			} else {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 2;
			}
		}
	}

	private void highGain(int count, int checkPoint) {
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 20) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 40) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 50) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 0;
			} else if (cache <= 60) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 1;
			} else if (cache <= 80) {
				materialTag[i] = checkPoint;
				materialItem[i] = 2;
			} else if (cache <= 90) {
				materialTag[i] = checkPoint + 1;
				materialItem[i] = 2;
			} else {
				materialTag[i] = checkPoint;
				materialItem[i] = 3;
			}
		}
	}
}
