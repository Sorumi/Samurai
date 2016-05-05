package model.po;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import controller.msgqueue.ActionOperation;
import model.ChessBoardModel;

public class SamuraiAI {
	// test

	public static void main(String[] args) {
		ChessBoardModel cbm = new ChessBoardModel(14);
		int[] materialTag = new int[] {};
		int[] materialItem = new int[] {};
		int[] materialNumber = new int[] {};
		int[] nextArmor = { 912 };
		SamuraiPO No1 = new SamuraiPO(1, 0, new Weapon(0), 14, cbm,
				new Armor(911, 5, 2, materialTag, materialItem, materialNumber, true, nextArmor, 3));
		SamuraiPO No2 = new SamuraiPO(2, 0, new Weapon(1), 14, cbm, new Armor());
		SamuraiPO No3 = new SamuraiPO(3, 0, new Weapon(2), 14, cbm, new Armor());
		SamuraiPO No4 = new SamuraiPO(4, 1, new Weapon(0), 14, cbm,
				new Armor(911, 5, 2, materialTag, materialItem, materialNumber, true, nextArmor, 3));
		SamuraiPO No5 = new SamuraiPO(5, 1, new Weapon(1), 14, cbm, new Armor());
		SamuraiPO No6 = new SamuraiPO(6, 1, new Weapon(2), 14, cbm, new Armor());
		SamuraiAI mine1 = new SamuraiAI(No1, 2, cbm, 0);
		SamuraiAI mine2 = new SamuraiAI(No2, 1, cbm, 0);
		SamuraiAI mine3 = new SamuraiAI(No3, 1, cbm, 0);
		SamuraiAI mine4 = new SamuraiAI(No4, 1, cbm, 1);
		SamuraiAI mine5 = new SamuraiAI(No5, 1, cbm, 1);
		SamuraiAI mine6 = new SamuraiAI(No6, 1, cbm, 1);
		for (int i = 0; i < 5; i++) {
			mine1.storyCalculate(No4, null);
			print(cbm);
			/*
			 * mine4.storyCalculate(null, null); print(cbm);
			 * mine5.storyCalculate(null, null); print(cbm);
			 * mine2.storyCalculate(null, null); print(cbm);
			 * mine3.storyCalculate(null, null); print(cbm);
			 * mine6.storyCalculate(null, null); print(cbm);
			 */
		}

		//

	}

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

	public ArrayList<ActionOperation> storyCalculate(SamuraiPO enemySamuraiPO, Position aidPosition) {
		ArrayList<ActionOperation> actionOperations = new ArrayList<ActionOperation>();
		Random random = new Random();
		int armorRate = samuraiPO.getArmorRate();
		SamuraiPO samuraiPOClone = samuraiPO.clone();
		ChessBoardModel cbm = chessBoardModel.clone();
		switch (type) {
		case 0:
			int moveDirection;
			int occupyDirection;
			while (samuraiPOClone.getActionPoint() >= 2) {
				if (samuraiPOClone.getActionPoint() >= 4) {
					do {
						occupyDirection = random.nextInt(4);
					} while (!samuraiPOClone.checkOccupy()[occupyDirection]);
					samuraiPOClone.changeActionPoint(4);
					actionOperations.add(new ActionOperation(0, occupyDirection));
				}
				if (samuraiPOClone.getActionPoint() >= 2) {
					do {
						moveDirection = random.nextInt(4);
					} while (!samuraiPOClone.move(moveDirection, cbm));
					samuraiPOClone.changeActionPoint(2);
					actionOperations.add(new ActionOperation(0, moveDirection));
				}
			}
			return actionOperations;
		//
		case 1:
			return greedy(samuraiPOClone, cbm);
		//
		case 2:
			if (enemySamuraiPO == null) {
				int temp = samuraiPOClone.getActionPoint();
				samuraiPOClone.setActionPoint(6);
				actionOperations = greedy(samuraiPOClone, cbm);
				samuraiPOClone.setActionPoint(temp - 6);
			} else {
				if (compareAbility(samuraiPOClone, enemySamuraiPO, armorRate)) {
					int distance = getDistance(samuraiPOClone, enemySamuraiPO.getPos());
					if (distance > 1) {
						System.out.println(distance);
						approach(samuraiPOClone, enemySamuraiPO.getPos(), cbm, actionOperations);
					}
				} else {
					leave(samuraiPOClone, enemySamuraiPO.getPos(), cbm, actionOperations);
				}
			}
			break;

		default:
			break;
		}
		return null;
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
			// System.out.println(occupyDirection);
			// samuraiPO.move(moveDirection, chessBoardModel);
			// samuraiPO.occupied(occupyDirection, chessBoardModel, true);
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
			// samuraiPO.move(saveCaches.get(0).getLocation() / 4,
			// chessBoardModel);
			// samuraiPO.occupied(saveCaches.get(0).getLocation() % 4,
			// chessBoardModel, true);
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

	private ArrayList<ActionOperation> greedy(SamuraiPO samuraiPO1, ChessBoardModel chessBoardModel1) {
		int moveDirection1;
		ArrayList<ActionOperation> actionOperations = new ArrayList<ActionOperation>();
		ArrayList<SaveCache> saveCaches = new ArrayList<SaveCache>();
		Random random = new Random();
		if (samuraiPO1.getWeapon().getGenre() != 2) {
			while (samuraiPO1.getActionPoint() >= 2) {
				if (samuraiPO1.getActionPoint() >= 4) {
					for (int x = 0; x < 4; x++) {
						ChessBoardModel cbm1 = chessBoardModel1.clone();
						samuraiPO1.occupied(x, cbm1, true);
						SaveCache saveCache = new SaveCache(sumArea(cbm1), x);
						saveCaches.add(saveCache);
					}
					Collections.sort(saveCaches);
					samuraiPO1.occupied(saveCaches.get(0).location, chessBoardModel1, true);
					//
					// samuraiPO.occupied(saveCaches.get(0).location,
					// chessBoardModel, true);
					//
					actionOperations.add(new ActionOperation(0, saveCaches.get(0).location));
					samuraiPO1.changeActionPoint(4);
				}
				if (samuraiPO1.getActionPoint() >= 2) {
					do {
						moveDirection1 = random.nextInt(4);
					} while (!samuraiPO1.checkMove(chessBoardModel1)[moveDirection1]);
					samuraiPO1.move(moveDirection1, chessBoardModel1);
					//
					// samuraiPO.move(moveDirection1, chessBoardModel);
					//
					actionOperations.add(new ActionOperation(1, moveDirection1));
					samuraiPO1.changeActionPoint(2);
				}
			}
		} else {
			while (samuraiPO1.getActionPoint() >= 2) {
				if (samuraiPO1.getActionPoint() >= 2) {
					do {
						moveDirection1 = random.nextInt(4);
					} while (!samuraiPO1.checkMove(chessBoardModel1)[moveDirection1]);
					samuraiPO1.move(moveDirection1, chessBoardModel1);
					//
					// samuraiPO.move(moveDirection1, chessBoardModel);
					//
					actionOperations.add(new ActionOperation(1, moveDirection1));
					samuraiPO1.changeActionPoint(2);
					// System.out.println(samuraiPO1.getActionPoint());
				}
				if (samuraiPO1.getActionPoint() >= 4) {
					for (int x = 0; x < 4; x++) {
						ChessBoardModel cbm1 = chessBoardModel1.clone();
						samuraiPO1.occupied(x, cbm1, true);
						SaveCache saveCache = new SaveCache(sumArea(cbm1), x);
						saveCaches.add(saveCache);
					}
					Collections.sort(saveCaches);
					samuraiPO1.occupied(saveCaches.get(0).location, chessBoardModel1, true);
					//
					// samuraiPO.occupied(saveCaches.get(0).location,
					// chessBoardModel, true);
					//
					actionOperations.add(new ActionOperation(0, saveCaches.get(0).location));
					samuraiPO1.changeActionPoint(4);
					// System.out.println(samuraiPO1.getActionPoint());
				}
			}
		}
		return actionOperations;

	}

	private void approach(SamuraiPO samuraiPO1, Position position1, ChessBoardModel cbm1,
			ArrayList<ActionOperation> actionOperations) {
		int compare;
		// 0 改变X
		// 1 改变Y
		if ((Math.abs(samuraiPO1.getPos().getX() - position1.getX()) < Math
				.abs(samuraiPO1.getPos().getY() - position1.getY())
				&& ((samuraiPO1.getPos().getX() - position1.getX()) != 0))
				|| ((samuraiPO1.getPos().getY() - position1.getY()) == 0)) {
			compare = 0;
		} else {
			compare = 1;
		}
		//
		if (compare == 0) {
			if ((samuraiPO1.getPos().getX() - position1.getX()) > 0) {
				samuraiPO1.move(0, cbm1);
				actionOperations.add(new ActionOperation(1, 0));
				//
				samuraiPO.move(0, chessBoardModel);
				//
			} else {
				samuraiPO1.move(3, cbm1);
				actionOperations.add(new ActionOperation(1, 3));
				//
				samuraiPO.move(3, chessBoardModel);
				//
			}
		} else {
			if ((samuraiPO1.getPos().getY() - position1.getY()) > 0) {
				samuraiPO1.move(1, cbm1);
				actionOperations.add(new ActionOperation(1, 1));
				//
				samuraiPO.move(1, chessBoardModel);
				//
			} else {
				samuraiPO1.move(2, cbm1);
				actionOperations.add(new ActionOperation(1, 2));
				//
				samuraiPO.move(2, chessBoardModel);
				//
			}
		}

	}

	private void leave(SamuraiPO samuraiPO1, Position position1, ChessBoardModel cbm1,
			ArrayList<ActionOperation> actionOperations) {
		int compare;
		// 0 改变X
		// 1 改变Y
		if ((Math.abs(samuraiPO1.getPos().getX() - position1.getX()) < Math
				.abs(samuraiPO1.getPos().getY() - position1.getY())
				&& ((samuraiPO1.getPos().getX() - position1.getX()) != 0))
				|| ((samuraiPO1.getPos().getY() - position1.getY()) == 0)) {
			compare = 0;
		} else {
			compare = 1;
		}
		//
		if (compare == 0) {
			if ((samuraiPO1.getPos().getX() - position1.getX()) > 0) {
				samuraiPO1.move(3, cbm1);
				actionOperations.add(new ActionOperation(1, 3));
				//
				samuraiPO.move(3, chessBoardModel);
				//
			} else {
				samuraiPO1.move(0, cbm1);
				actionOperations.add(new ActionOperation(0, 3));
				//
				samuraiPO.move(0, chessBoardModel);
				//
			}
		} else {
			if ((samuraiPO1.getPos().getY() - position1.getY()) > 0) {
				samuraiPO1.move(2, cbm1);
				actionOperations.add(new ActionOperation(2, 1));
				//
				samuraiPO.move(2, chessBoardModel);
				//
			} else {
				samuraiPO1.move(1, cbm1);
				actionOperations.add(new ActionOperation(1, 1));
				//
				samuraiPO.move(1, chessBoardModel);
				//
			}
		}

	}

	private int getDistance(SamuraiPO samuraiPO1, Position position) {
		return Math.abs(samuraiPO1.getPos().getX() - position.getX())
				+ Math.abs(samuraiPO1.getPos().getY() - position.getY());
	}

	private boolean compareAbility(SamuraiPO samuraiPO, SamuraiPO enemySamuraiPO, int armorRate) {
		int count = 0;
		if (samuraiPO.getLevel() >= enemySamuraiPO.getLevel()) {
			count++;
		}
		if (((samuraiPO.getWeapon().getType() % 100) / 10) >= ((enemySamuraiPO.getWeapon().getType() % 100) / 10)) {
			count++;
		}
		if (armorRate >= enemySamuraiPO.getArmorRate()) {
			count++;
		}
		if (samuraiPO.getHealthPoint() >= enemySamuraiPO.getHealthPoint()) {
			count++;
		}
		if (count >= 2) {
			return true;
		} else {
			return false;
		}
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
