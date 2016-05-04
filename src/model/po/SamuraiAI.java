package model.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import controller.msgqueue.ActionOperation;
import model.ChessBoardModel;

public class SamuraiAI {
	// test
	/*public static void main(String[] args) {
		ChessBoardModel cbm = new ChessBoardModel(14);
		SamuraiPO No1 = new SamuraiPO(1, 0, new Weapon(0), 14, cbm, new Armor());
		SamuraiPO No2 = new SamuraiPO(2, 0, new Weapon(1), 14, cbm, new Armor());
		SamuraiPO No3 = new SamuraiPO(3, 0, new Weapon(2), 14, cbm, new Armor());
		SamuraiPO No4 = new SamuraiPO(4, 1, new Weapon(0), 14, cbm, new Armor());
		SamuraiPO No5 = new SamuraiPO(5, 1, new Weapon(1), 14, cbm, new Armor());
		SamuraiPO No6 = new SamuraiPO(6, 1, new Weapon(2), 14, cbm, new Armor());
		SamuraiAI mine1 = new SamuraiAI(No1, 0, cbm, 0);
		SamuraiAI mine2 = new SamuraiAI(No2, 0, cbm, 0);
		SamuraiAI mine3 = new SamuraiAI(No3, 0, cbm, 0);
		SamuraiAI mine4 = new SamuraiAI(No4, 1, cbm, 1);
		SamuraiAI mine5 = new SamuraiAI(No5, 1, cbm, 1);
		SamuraiAI mine6 = new SamuraiAI(No6, 1, cbm, 1);
		for (int i = 0; i < 20; i++) {
			mine1.calculate();
			print(cbm);
			mine4.calculate();
			print(cbm);
			mine5.calculate();
			print(cbm);
			mine2.calculate();
			print(cbm);
			mine3.calculate();
			print(cbm);
			mine6.calculate();
			print(cbm);
		}

		//

	}*/

	public static void print(ChessBoardModel cbm) {
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockOccupied(i, x) + " ");
			}
			System.out.println();
		}

		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockState(i, x) + " ");
			}
			System.out.println();
		}
	}
	// by SilverNarcissus

	// 0:random
	// 1:greedy
	private int player;
	private int type;
	private SamuraiPO samuraiPO;
	private ChessBoardModel chessBoardModel;

	public SamuraiAI(SamuraiPO samuraiPO, int type, ChessBoardModel cbm, int player) {
		this.samuraiPO = samuraiPO;
		this.type = type;
		this.chessBoardModel = cbm;
		this.player = player;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void storyCalculate() {

	}

	public ActionOperation[] calculate() {
		Random random = new Random();
		ArrayList<SaveCache> saveCaches = new ArrayList<SaveCache>();
		ActionOperation[] actionOperations = new ActionOperation[2];
		boolean[] check = samuraiPO.checkMove(chessBoardModel);
		switch (type) {
		case 0:
			int moveDirection;
			int occupyDirection;
			SamuraiPO samuraiPOClone1 = samuraiPO.clone();
			ChessBoardModel cbm1 = chessBoardModel.clone();
			do {
				moveDirection = random.nextInt(4);
			} while (!samuraiPOClone1.move(moveDirection, cbm1));
			do {
				occupyDirection = random.nextInt(4);
			} while (!samuraiPOClone1.checkOccupy()[occupyDirection]);
			//
			//System.out.println(occupyDirection);
			//samuraiPO.move(moveDirection, chessBoardModel);
			//samuraiPO.occupied(occupyDirection, chessBoardModel, true);
			//
			actionOperations[0] = new ActionOperation(1, moveDirection);
			actionOperations[1] = new ActionOperation(0, occupyDirection);
			return null;
		case 1:
			//
			for (int i = 0; i < 4; i++) {
				SamuraiPO samuraiPOClone = samuraiPO.clone();
				ChessBoardModel cbm = chessBoardModel.clone();
				if (check[i]) {
					samuraiPOClone.move(i, cbm);
					for (int x = 0; x < 4; x++) {
						ChessBoardModel cbm2 = cbm.clone();
						samuraiPOClone.occupied(x, cbm2, true);
						SaveCache saveCache = new SaveCache(sumArea(cbm2), i * 4 + x);
						saveCaches.add(saveCache);
					}
				}
			}
			Collections.sort(saveCaches);
			//
		    //samuraiPO.move(saveCaches.get(0).getLocation() / 4,
			//chessBoardModel);
			//samuraiPO.occupied(saveCaches.get(0).getLocation() % 4,
			//chessBoardModel, true);
			//
			actionOperations[0] = new ActionOperation(1, saveCaches.get(0).getLocation() / 4);
			actionOperations[1] = new ActionOperation(0, saveCaches.get(0).getLocation() % 4);

			return actionOperations;
		//

		default:
			return null;
		}

	}

	private int sumArea(ChessBoardModel cbm) {
		int result = 0;
		if (player == 0) {
			for (int x = 0; x < samuraiPO.getLength(); x++) {
				for (int y = 0; y < samuraiPO.getLength(); y++) {
					if (cbm.getActualBlockState(x, y) == 1 || cbm.getActualBlockState(x, y) == 2
							|| cbm.getActualBlockState(x, y) == 3) {
						result++;
					}
				}
			}
		} else {
			for (int x = 0; x < samuraiPO.getLength(); x++) {
				for (int y = 0; y < samuraiPO.getLength(); y++) {
					if (cbm.getActualBlockState(x, y) == 4 || cbm.getActualBlockState(x, y) == 5
							|| cbm.getActualBlockState(x, y) == 6) {
						result++;
					}
				}
			}
		}
		return result;
	}

	class SaveCache implements Comparable<SaveCache> {
		private int value;
		private int location;

		public SaveCache(int value, int location) {
			this.value = value;
			this.location = location;
		}

		public int getLocation() {
			return location;
		}

		public int getValue() {
			return value;
		}

		public int compareTo(SaveCache o) {
			return o.value - value;
		}
	}
}
