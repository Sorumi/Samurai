package model.po;

import java.util.ArrayList;
import java.util.Random;

public class ScoreBoard {
	private int[] materialTag = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	private int[] materialItem = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	private String Rating;
	private Random random = new Random();

	public int[] getExperience(int checkPoint, int level, int land1, int land2, int land3, int kill1, int kill2,
			int kill3) {
		int[] result = new int[3];
		System.out.println("land"+land1);
		result[0] = (land1 + kill1 * 5) * ((checkPoint + level) / 5 + 1);
		result[1] = (land2 + kill2 * 5) * ((checkPoint + level) / 5 + 1);
		result[2] = (land3 + kill3 * 5) * ((checkPoint + level) / 5 + 1);
		return result;
	}

	public String getRating() {
		return Rating;
	}

	public ArrayList<Material> getMaterial() {
		System.out.println(Rating);
		int count = 0;
		ArrayList<Material> materials = new ArrayList<Material>();
		while (materialTag[count] >= 0) {
			boolean flag = false;
			int type = 800 + materialTag[count] * 10 + materialItem[count];
			for (Material material : materials) {
				if (material.getType() == type) {
					material.setNumber(material.getNumer() + 1);
					flag = true;
					break;
				}
			}
			if (!flag) {
				Material material = new Material(type, 1);
				materials.add(material);
			}
			count++;
		}
		System.out.println("不是我的锅！" + materials.size());
		return materials;
	}

	public boolean caculateMaterial(int checkPoint, int level, int block, int ourKill, int enemyKill) {
		// 判断评级
		System.out.println("CheckPoint"+checkPoint);
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
		case 1:
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
		case 2:
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
		case 3:
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
		int temp=0;
		if(checkPoint==4){
			temp=0;
		}
		else {
			temp=checkPoint+1;
		}
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 30) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 60) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 80) {
				materialTag[i] = temp;
				materialItem[i] = 0;
			} else {
				materialTag[i] = temp;
				materialItem[i] = 1;
			}
		}
	}

	private void mediumGain(int count, int checkPoint) {
		int temp=0;
		if(checkPoint==4){
			temp=0;
		}
		else {
			temp=checkPoint+1;
		}
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 25) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 50) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 65) {
				materialTag[i] = temp;
				materialItem[i] = 0;
			} else if (cache <= 80) {
				materialTag[i] = temp;
				materialItem[i] = 1;
			} else if (cache <= 95) {
				materialTag[i] = checkPoint;
				materialItem[i] = 2;
			} else {
				materialTag[i] = temp;
				materialItem[i] = 2;
			}
		}
	}

	private void highGain(int count, int checkPoint) {
		int temp=0;
		if(checkPoint==4){
			temp=0;
		}
		else {
			temp=checkPoint+1;
		}
		for (int i = 0; i < count; i++) {
			int cache = random.nextInt(100) + 1;
			if (cache <= 20) {
				materialTag[i] = checkPoint;
				materialItem[i] = 0;
			} else if (cache <= 40) {
				materialTag[i] = checkPoint;
				materialItem[i] = 1;
			} else if (cache <= 50) {
				materialTag[i] = temp;
				materialItem[i] = 0;
			} else if (cache <= 60) {
				materialTag[i] = temp;
				materialItem[i] = 1;
			} else if (cache <= 80) {
				materialTag[i] = checkPoint;
				materialItem[i] = 2;
			} else if (cache <= 90) {
				materialTag[i] = temp;
				materialItem[i] = 2;
			} else {
				materialTag[i] = checkPoint;
				materialItem[i] = 3;
			}
		}
	}
}
