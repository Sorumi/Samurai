package model.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import model.ChessBoardModel;

/**
 * 所有武士类的父类，必须实现序列化接口
 *
 * @author SilverNarcissus
 *
 */
// cheers!
// 4.18 code lines reached 1000 lines!

public class SamuraiPO implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int experience;
	private int level;
	private int length;
	private int number;
	private int player;
	// 0:Spear
	// 1:Sword
	// 2:Battle ax
	private Position pos;
	private boolean hide = false;
	private Position home;
	private int dodgeChance;
	private int criticalHitChance;
	private int armorValue;
	private int attackValue;
	private int coldRound;
	private Weapon weapon;
	private Armor armor;
	private int healthPoint;
	private int actionPoint;
	private int totalActionPoint;
	private int totalHealthPoint;
	private int killNum;

	private int prop;

	public static void main(String[] args) {
		ChessBoardModel cbm = new ChessBoardModel(14);
		SamuraiPO samuraiPO = new SamuraiPO(1, 0, new Weapon(2), 14, cbm, new Armor());
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockOccupied(i, x) + " ");
			}
			System.out.println();
		}
		samuraiPO.move(2, cbm);
		samuraiPO.occupied(3, cbm, true);
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockState(i, x) + " ");
			}
			System.out.println();
		}
	}

	// 经典模式构造方法
	public SamuraiPO(int number, int player, Weapon weapon, int length, ChessBoardModel cbm, Armor armor) {
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.armor = armor;
		this.length = length;
		this.criticalHitChance = 1;
		this.level = 1;
		this.dodgeChance = 1;
		this.attackValue = 5;
		this.armorValue = 10;
		this.coldRound = 0;
		this.healthPoint = 60;
		this.criticalHitChance = 1;
		// 这里改一下经典模式玩家的点数
		this.totalActionPoint = 30;
		this.actionPoint = this.totalActionPoint;
		this.killNum = 0;
		if (number == 1 && player == 0) {
			pos = new Position(0, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		} else if (number == 2 && player == 0) {
			pos = new Position(length / 2, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		} else if (number == 3 && player == 0) {
			pos = new Position(length, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		} else if (number == 4 && player == 1) {
			pos = new Position(0, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		} else if (number == 5 && player == 1) {
			pos = new Position(length / 2, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		} else if (number == 6 && player == 1) {
			pos = new Position(length, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home = pos.clone();
		}
	}

	// 故事模式构造方法
	public SamuraiPO(int number, int player, Weapon weapon, int length, ChessBoardModel cbm, Armor armor, Position home,
			int actionPoint, int level) {
		this.level = level;
		this.totalHealthPoint = 60 + (level - 1) * 30;
		this.healthPoint = totalHealthPoint;
		this.totalActionPoint = actionPoint;
		this.actionPoint = actionPoint;
		//
		this.criticalHitChance = level << 1;
		this.dodgeChance = level << 1;
		this.armorValue = level * 5;
		this.attackValue = level * 3;
		//
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.armor = armor;
		this.length = length;
		this.criticalHitChance = 1;
		this.level = 1;
		this.dodgeChance = 1;
		this.attackValue = 5;
		this.armorValue = 10;
		this.coldRound = 0;
		this.criticalHitChance = 1;
		this.home = home;

		this.prop = 0;

		this.pos = home.clone();
		cbm.changeActualBlock(home.getX(), home.getY(), true);

		this.killNum = 0;
	}

	public void changeAttackPoint(int temp) {
		this.attackValue = this.attackValue + temp;
	}

	public void changeCriticalHitRate(int temp) {
		this.criticalHitChance = this.criticalHitChance + temp;
	}

	public SamuraiPO(int number, int player, Weapon weapon, int length, Position position, Position home, Armor armor,
			int level, int armorValue, int attackValue, int dodgeChance, int healthPonit, int criticalHitRate,
			int actionPoint) {
		this.number = number;
		this.armor = armor;
		this.player = player;
		this.weapon = weapon;
		this.length = length;
		this.pos = position;
		this.home = home;
		this.level = level;
		this.dodgeChance = dodgeChance;
		this.armorValue = armorValue;
		this.attackValue = attackValue;
		this.criticalHitChance = criticalHitRate;
		this.healthPoint = healthPonit;
		this.actionPoint = actionPoint;
		this.killNum = 0;
		this.prop = 0;
	}

	public void setHome(Position home) {
		this.home.setX(home.getX());
		this.home.setY(home.getY());
	}

	public int getProp() {
		return prop;
	}

	public void setProp(int prop) {
		this.prop = prop;
	}

	public int getKillNum() {
		return killNum;
	}

	public void updateKillNum(int delta) {
		this.killNum += delta;
	}

	public int getTotalHealthPoint() {
		return totalHealthPoint;
	}

	public int getTotalActionPoint() {
		return totalActionPoint;
	}

	public int getActionPoint() {
		return actionPoint;
	}

	public void changeActionPoint(int i) {
		actionPoint = actionPoint - i;
	}

	public void setActionPoint(int actionPoint) {
		this.actionPoint = actionPoint;
	}

	public int getColdRound() {
		return coldRound;
	}

	public void setColdRound(int coldRound) {
		this.coldRound = coldRound;
	}

	public int getNumber() {
		return this.number;
	}

	public Position getHome() {
		return this.home;
	}

	public void beKilled(ChessBoardModel cbm) {
		cbm.changeActualBlock(this.pos.getX(), this.pos.getY(), false);
		this.pos.setX(this.home.getX());
		this.pos.setY(this.home.getY());
		cbm.changeActualBlock(this.home.getX(), this.home.getY(), true);
		if (!hide) {
			cbm.changeActualBlock(this.home.getX(), this.home.getY(), false);
		}
	}

	public void beKilledWithPos(ChessBoardModel cbm, Position position){
		cbm.changeActualBlock(this.pos.getX(), this.pos.getY(), false);
		this.pos.setX(position.getX());
		this.pos.setY(position.getY());
		cbm.changeActualBlock(position.getX(), this.home.getY(), true);
		if (!hide) {
			cbm.changeActualBlock(this.home.getX(), this.home.getY(), false);
		}
	}

	// 0:up 1:right 2:left 3:down
	public Position tryMove(int direction) {
		Position position;
		switch (direction) {
		case 0:
			position = new Position(pos.getX() - 1, pos.getY());
			break;
		case 1:
			position = new Position(pos.getX(), pos.getY() - 1);
			break;
		case 2:
			position = new Position(pos.getX(), pos.getY() + 1);
			break;
		default:
			position = new Position(pos.getX() + 1, pos.getY());
			break;
		}
		return position;
	}

	public boolean[] checkMove(ChessBoardModel cbm) {
		int state;
		boolean[] result = new boolean[4];
		for (int direction = 0; direction < 4; direction++) {
			switch (direction) {
			case 0:
				if (pos.getX() - 1 >= 0) {
					state = cbm.getActualBlockState(pos.getX() - 1, pos.getY());
					if (cbm.getActualBlockOccupied(pos.getX() - 1, pos.getY()) || hide) {
						if (hide && player == 0) {
							if (state == 1 || state == 2 || state == 3) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}

						} else if (hide) {
							if (state == 4 || state == 5 || state == 6) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}
						} else {
							result[direction] = false;
						}
					} else {
						result[direction] = true;
					}
				} else {
					result[direction] = false;
				}
				break;
			case 1:
				if (pos.getY() - 1 >= 0) {
					state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
					if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() - 1) || hide) {
						if (hide && player == 0) {
							if (state == 1 || state == 2 || state == 3) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}

						} else if (hide) {
							if (state == 4 || state == 5 || state == 6) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}
						} else {
							result[direction] = false;
						}
					} else {
						result[direction] = true;
					}
				} else {
					result[direction] = false;
				}
				break;
			case 2:
				if (pos.getY() + 1 <= length) {
					state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
					if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() + 1) || hide) {
						if (hide && player == 0) {
							if (state == 1 || state == 2 || state == 3) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}

						} else if (hide) {
							if (state == 4 || state == 5 || state == 6) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}
						} else {
							result[direction] = false;
						}
					} else {
						result[direction] = true;
					}
				} else {
					result[direction] = false;
				}
				break;
			default:
				if (pos.getX() + 1 <= length) {
					state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
					if (cbm.getActualBlockOccupied(pos.getX() + 1, pos.getY()) || hide) {
						if (hide && player == 0) {
							if (state == 1 || state == 2 || state == 3) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}

						} else if (hide) {
							if (state == 4 || state == 5 || state == 6) {
								result[direction] = true;
							} else {
								result[direction] = false;
							}
						} else {
							result[direction] = false;
						}
					} else {
						result[direction] = true;
					}

				} else {
					result[direction] = false;
				}
				break;
			}
		}
		return result;
	}

	public boolean[] checkOccupy() {
		boolean[] result = new boolean[4];
		if (pos.getX() - 1 >= 0) {
			result[0] = true;
		} else if (pos.getY() - 1 >= 0) {
			result[1] = true;
		} else if (pos.getY() + 1 >= 0) {
			result[2] = true;
		} else if (pos.getX() + 1 >= 0) {
			result[3] = true;
		}
		return result;
	}

	public boolean move(int direction, ChessBoardModel cbm) {
		int state;
		switch (direction) {
		case 0:
			if (pos.getX() - 1 >= 0) {
				state = cbm.getActualBlockState(pos.getX() - 1, pos.getY());
				if (cbm.getActualBlockOccupied(pos.getX() - 1, pos.getY()) || hide) {
					if (hide && player == 0) {
						if (state == 1 || state == 2 || state == 3) {
							pos.setX(pos.getX() - 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 4 || state == 5 || state == 6) {
							pos.setX(pos.getX() - 1);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					cbm.changeActualBlock(pos.getX(), pos.getY(), false);
					pos.setX(pos.getX() - 1);
					cbm.changeActualBlock(pos.getX(), pos.getY(), true);
				}
			} else {
				return false;
			}
			break;
		case 1:
			if (pos.getY() - 1 >= 0) {
				state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
				if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() - 1) || hide) {
					if (hide && player == 0) {
						if (state == 1 || state == 2 || state == 3) {
							pos.setY(pos.getY() - 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 4 || state == 5 || state == 6) {
							pos.setY(pos.getY() - 1);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					cbm.changeActualBlock(pos.getX(), pos.getY(), false);
					pos.setY(pos.getY() - 1);
					cbm.changeActualBlock(pos.getX(), pos.getY(), true);
				}
			} else {
				return false;
			}
			break;
		case 2:
			if (pos.getY() + 1 <= length) {
				state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
				if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() + 1) || hide) {
					if (hide && player == 0) {
						if (state == 1 || state == 2 || state == 3) {
							pos.setY(pos.getY() + 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 4 || state == 5 || state == 6) {
							pos.setY(pos.getY() + 1);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					cbm.changeActualBlock(pos.getX(), pos.getY(), false);
					pos.setY(pos.getY() + 1);
					cbm.changeActualBlock(pos.getX(), pos.getY(), true);
				}
			} else {
				return false;
			}
			break;
		default:
			if (pos.getX() + 1 <= length) {
				state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
				if (cbm.getActualBlockOccupied(pos.getX() + 1, pos.getY()) || hide) {
					if (hide && player == 0) {
						if (state == 1 || state == 2 || state == 3) {
							pos.setX(pos.getX() + 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 4 || state == 5 || state == 6) {
							pos.setX(pos.getX() + 1);
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					cbm.changeActualBlock(pos.getX(), pos.getY(), false);
					pos.setX(pos.getX() + 1);
					cbm.changeActualBlock(pos.getX(), pos.getY(), true);
				}

			} else {
				return false;
			}
			break;
		}
		return true;
	}

	// 0:up 1:right 2:left 3:down
	public void tryOccupied(int direction, ChessBoardModel cbm) {
		occupied(direction, cbm, false);
	}

	public ArrayList<Position> occupied(int direction, ChessBoardModel cbm, boolean real) {
		ArrayList<Position> positions = new ArrayList<Position>();
		switch (weapon.getGenre()) {
		// weapon 0
		case 0:
			switch (direction) {
			case 0:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				break;
			case 1:
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 2:
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 4; i++, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			default:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 4; i++, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				break;
			}
			break;
		//
		// weapon 1
		// 模型分析：
		// 0=1===1=110===2=1===3=011
		// =11======11=====11====11
		// 110=======1=====011===1
		case 1:
			switch (direction) {
			case 0:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 1:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 2:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;

			default:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			}
			break;
		//
		// weapon 2
		case 2:
			switch (direction) {
			case 0:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;
			case 1:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;
			case 2:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;

			default:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;
			}
			break;
		case 3:
			switch (direction) {
			case 0:
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				if (pos.getX() - 2 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 2, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 2, pos.getY());
					positions.add(position);
				}
				break;
			case 1:
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				if (pos.getY() - 2 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() - 2, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 2);
					positions.add(position);
				}
				break;
			case 2:
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				if (pos.getY() + 2 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), pos.getY() + 2, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 2);
					positions.add(position);
				}

				break;
			default:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				if (pos.getX() + 2 <= length) {
					if (real) {
						cbm.changeActualBlock(pos.getX() + 2, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 2, pos.getY());
					positions.add(position);
				}
				break;
			}
			break;
		case 4:
			switch (direction) {
			case 0:
				for (int i = pos.getX() - 3, x = 0; i >= 0 && x < 3; i--, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				break;
			case 1:
				for (int i = pos.getY() - 3, x = 0; i >= 0 && x < 3; i--, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 2:
				for (int i = pos.getY() + 3, x = 0; i <= length && x < 3; i++, x++) {
					if (real) {
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			default:
				for (int i = pos.getX() + 3, x = 0; i <= length && x < 3; i++, x++) {
					if (real) {
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				break;
			}
			break;
		}
		return positions;
	}

	public boolean hide(ChessBoardModel cbm) {
		int state = cbm.getActualBlockState(pos.getX(), pos.getY());
		if (player == 0) {
			if (state == 1 || state == 2 || state == 3) {
				hide = true;
				cbm.changeActualBlock(pos.getX(), pos.getY(), false);
				return true;
			} else {
				return false;
			}
		} else {
			if (state == 4 || state == 5 || state == 6) {
				hide = true;
				cbm.changeActualBlock(pos.getX(), pos.getY(), false);
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean show(ChessBoardModel cbm) {
		if (hide && !cbm.getActualBlockOccupied(pos.getX(), pos.getY())) {
			hide = false;
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			return true;
		} else {
			return false;
		}
	}

	public Position getPos() {
		return this.pos;
	}

	public ArrayList<Position> see() {
		ArrayList<Position> positions = new ArrayList<Position>();
		int x = 5;
		for (int i = x; i >= 0; i--) {
			if (pos.getY() - i >= 0) {
				for (int a = i - x; a <= x - i; a++) {
					if ((pos.getX() + a >= 0) && (pos.getX() + a <= length)) {
						Position position = new Position(pos.getX() + a, pos.getY() - i);
						positions.add(position);
					}
				}
			}
		}
		// 修复bug!!!!!!
		for (int i = x; i > 0; i--) {
			if (pos.getY() + i <= length) {
				for (int a = i - x; a <= x - i; a++) {
					if ((pos.getX() + a >= 0) && (pos.getX() + a <= length)) {
						Position position = new Position(pos.getX() + a, pos.getY() + i);
						positions.add(position);
					}
				}
			}
		}
		return positions;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public int[] getAttackValue() {
		int[] result = new int[2];
		result[0] = attackValue + weapon.getLowAttackPoint();
		result[1] = attackValue + weapon.getHighAttackPoint();
		return result;
	}

	public int getArmorValue() {
		return armorValue + this.armor.getArmorValue();
	}

	public int getDodgeRate() {
		return dodgeChance + this.armor.getDodgeRate();
	}

	public int getCriticalHitRate() {
		return criticalHitChance + this.weapon.getCriticalRate();
	}

	public int getArmorPenetration() {
		return this.weapon.getArmorPenetration();
	}

	public int getPlayer() {
		return player;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public int getLength() {
		return length;
	}

	public void addExperience(int experience) {
		this.experience = this.experience + experience;
	}

	public boolean isUpLevel() {
		double cache = Math.pow(level, 1.5);
		int upLevelExp = (int) (cache * 50);
//		if (experience >= upLevelExp) {
//			upLevel();
//			return true;
//		}
		upLevel();
		System.out.println("LEVEL UP!!!!!!!");
		return true;
	}

	public int getNextLevelExperience() {
		double cache = Math.pow(level, 1.5);
		int upLevelExp = (int) (cache * 50);
		return upLevelExp;
	}

	public boolean getHide() {
		return hide;
	}

	private void upLevel() {
		this.criticalHitChance += 2;
		this.dodgeChance += 2;
		this.armorValue += 5;
		this.attackValue += 3;
		this.totalHealthPoint += 30;
		this.totalActionPoint += 1;
		level++;
	}

	public void changeWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public void changeArmor(Armor armor) {
		this.armor = armor;
	}

	// 返回人物的总护甲值
	public int getArmorRate() {
		return (armorValue + armor.getArmorValue());
	}

	// 返回是否MISS
	public boolean checkMiss() {
		int missRate = dodgeChance + armor.getDodgeRate();
		Random random = new Random();
		if ((random.nextInt(100) + 1) <= missRate) {
			return true;
		} else {
			return false;
		}
	}

	// 返回一个数组
	// 第一位是暴击率考虑进去的伤害值
	// 第二位是武器的护甲穿透
	public int[] getAttackPoint() {
		int criticalHitRate = criticalHitChance + weapon.getCriticalRate();
		int armorPenetration = weapon.getArmorPenetration();
		int[] result = new int[3];
		Random random = new Random();
		if (random.nextInt(100) + 1 <= criticalHitRate) {
			result[0] = (weapon.getAttackPoint() + attackValue) * 2;
			result[2] = 1;
		} else {
			result[0] = weapon.getAttackPoint() + attackValue;
		}
		result[1] = armorPenetration;
		return result;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	// 复活
	public void revive() {
		healthPoint = 60 + (level - 1) * 20;
	}

	// 造成伤害 传入造成的伤害点数
	public void injure(int injurePonit) {
		healthPoint = healthPoint - injurePonit;
	}

	public SamuraiPO clone() {
		try {
			SamuraiPO samuraiPO1 = new SamuraiPO(number, player, this.weapon.clone(), length, pos.clone(), home.clone(),
					armor, level, armorValue, attackValue, dodgeChance, healthPoint, criticalHitChance, actionPoint);
			return samuraiPO1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
