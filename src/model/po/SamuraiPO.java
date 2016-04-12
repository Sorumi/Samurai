package model.po;

import java.io.Serializable;
import java.util.ArrayList;
import model.ChessBoardModel;

/**
 * 所有武士类的父类，必须实现序列化接口
 *
 * @author SilverNarcissus
 *
 */

public class SamuraiPO implements Serializable, Cloneable {
	private int experience;
	private int level;
	private int length;
	private int number;
	private int player;
	// 0:Spear
	// 1:Sword
	// 2:Battle ax
	private int weapon;
	private Position pos;
	private boolean hide = false;
    private Position home;
	public static void main(String[] args) {
		ChessBoardModel cbm = new ChessBoardModel(14);
		SamuraiPO No1 = new SamuraiPO(1, 0, 0, 14, cbm);
		SamuraiPO No2 = new SamuraiPO(2, 1, 0, 14, cbm);
		SamuraiPO No3 = new SamuraiPO(3, 1, 1, 14, cbm);
		SamuraiPO No4 = new SamuraiPO(4, 0, 1, 14, cbm);
		SamuraiPO No5 = new SamuraiPO(5, 0, 2, 14, cbm);
		SamuraiPO No6 = new SamuraiPO(6, 1, 2, 14, cbm);
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockOccupied(i, x) + " ");
			}
			System.out.println();
		}
		System.out.println("p");
		No1.move(4, cbm);
		No1.occupied(1, cbm, true);
		No1.move(4, cbm);
		No1.occupied(1, cbm, true);
		No1.move(4, cbm);
		No1.occupied(1, cbm, true);
		No1.move(4, cbm);
		No1.occupied(1, cbm, true);
		System.out.println("p2");
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockState(i, x) + " ");
			}
			System.out.println();
		}
	}

	public SamuraiPO(int number, int player, int weapon, int length, ChessBoardModel cbm) {
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.length = length;
		if (number == 1 && player == 0) {
			pos = new Position(0, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		} else if (number == 2 && player == 0) {
			pos = new Position(length / 2, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		} else if (number == 3 && player == 0) {
			pos = new Position(length, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		} else if (number == 4 && player == 1) {
			pos = new Position(0, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		} else if (number == 5 && player == 1) {
			pos = new Position(length / 2, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		} else if (number == 6 && player == 1) {
			pos = new Position(length, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
			home=pos.clone();
		}
	}

	public SamuraiPO(int number, int player, int weapon, int length, Position position,Position home) {
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.length = length;
		this.pos = position;
		this.home = home;
	}

	public int getNumber(){
		return this.number;
	}

	public Position getHome() {
		switch (number) {
		case 1:
			return new Position(0, 0);
		case 2:
			return new Position(length / 2, 0);
		case 3:
			return new Position(length, 0);
		case 4:
			return new Position(0, length);
		case 5:
			return new Position(length / 2, length);
		default:
			return new Position(length, length);
		}
	}

	public void beKilled(int length, ChessBoardModel cbm) {
		if (!hide) {
//			cbm.changeActualBlock(pos.getX(), pos.getY(), false);
		}
		System.out.println(player + "'s "+ number +  " is killed");
		if (number == 1 && player == 0) {
			pos = new Position(0, 0);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 2 && player == 0) {
			pos = new Position(length / 2, 0);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 3 && player == 0) {
			pos = new Position(length, 0);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 4 && player == 1) {
			pos = new Position(0, length);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 5 && player == 1) {
			pos = new Position(length / 2, length);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 6 && player == 1) {
			pos = new Position(length, length);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
//			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
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
						if (hide || player == 0) {
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
						if (hide || player == 0) {
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
						if (hide || player == 0) {
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
						if (hide || player == 0) {
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
					if (hide || player == 0) {
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
					if (hide || player == 0) {
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
					if (hide || player == 0) {
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
					if (hide || player == 0) {
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
		switch (weapon) {
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
				for (int i = pos.getX() + 1, x = 0; i >= 0 && x < 4; i++, x++) {
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
		default:
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

	public int getPlayer() {
		return player;
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

	public boolean isUpLevel() {
		double cache = Math.pow(level, 1.5);
		int upLevelExp = (int) (cache * 50);
		if (experience >= upLevelExp) {
			upLevel();
			return true;
		}
		return false;
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
		level++;
	}

	public SamuraiPO clone() {
		try {
			SamuraiPO samuraiPO = new SamuraiPO(number, player, weapon, length, pos.clone(),home.clone());
			return samuraiPO;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
