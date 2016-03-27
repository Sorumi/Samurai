package model.po;

import java.io.Serializable;
import model.ChessBoardModel;

/**
 * 所有武士类的父类，必须实现序列化接口
 * 
 * @author SilverNarcissus
 *
 */

public class SamuraiPO implements Serializable {
	private int length;
	private int number;
	private int player;
	// 0:Spear
	// 1:Sword
	// 2:Battle ax
	private int weapon;
	private Position pos;
	private boolean hide = false;

	public SamuraiPO(int number, int player, int weapon, int length, ChessBoardModel cbm) {
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.length = length;
		if (number == 1 && player == 0) {
			pos = new Position(0, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 4 && player == 0) {
			pos = new Position(length / 2, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 5 && player == 0) {
			pos = new Position(length, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 2 && player == 1) {
			pos = new Position(0, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else if (number == 3 && player == 1) {
			pos = new Position(length / 2, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		} else {
			pos = new Position(length, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		}
	}

	// 0:up 1:right 2:left 3:down
	public boolean move(int direction, ChessBoardModel cbm) {
		int state;
		switch (direction) {
		case 0:
			state = cbm.getActualBlockState(pos.getX() - 1, pos.getY());
			if (pos.getX() - 1 >= 0) {
				if (cbm.getActualBlockOccupied(pos.getX() - 1, pos.getY()) || hide) {
					if (hide || player == 0) {
						if (state == 1 || state == 4 || state == 5) {
							pos.setX(pos.getX() - 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 2 || state == 3 || state == 6) {
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
			state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
			if (pos.getY() - 1 >= 0) {
				if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() - 1) || hide) {
					if (hide || player == 0) {
						if (state == 1 || state == 4 || state == 5) {
							pos.setY(pos.getY() - 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 2 || state == 3 || state == 6) {
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
			state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
			if (pos.getY() + 1 <= length) {
				if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() + 1) || hide) {
					if (hide || player == 0) {
						if (state == 1 || state == 4 || state == 5) {
							pos.setY(pos.getY() + 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 2 || state == 3 || state == 6) {
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
			state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
			if (pos.getX() + 1 <= length) {
				if (cbm.getActualBlockOccupied(pos.getX() + 1, pos.getY()) || hide) {
					if (hide || player == 0) {
						if (state == 1 || state == 4 || state == 5) {
							pos.setX(pos.getX() + 1);
						} else {
							return false;
						}

					} else if (hide) {
						if (state == 2 || state == 3 || state == 6) {
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
	public boolean occupied(int direction, ChessBoardModel cbm) {
		boolean effective = false;
		switch (weapon) {
		// weapon 0
		case 0:
			switch (direction) {
			case 0:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
				}
				break;
			case 1:
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;
			case 2:
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 4; i++, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;
			default:
				for (int i = pos.getX() + 1, x = 0; i >= 0 && x < 4; i++, x++) {
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
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
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					effective = true;
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;
			case 1:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
				}
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					effective = true;
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;
			case 2:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					effective = true;
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;

			default:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(i, pos.getY(), number);
				}
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					effective = true;
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i--, x++) {
					effective = true;
					cbm.changeActualBlock(pos.getX(), i, number);
				}
				break;
			}
			break;
		//
		// weapon 2
		default:
			effective = true;
			switch (direction) {
			case 0:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
				}
				//
				if (pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
				}
				//
				if (pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
				}
				break;
			case 1:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
				}
				//
				if (pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
				}
				//
				if (pos.getX() + 1 <= length) {
					cbm.changeActualBlock(pos.getX()+1, pos.getY(), number);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
				}
				break;
			case 2:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
				}
				//
				if (pos.getY() +1 <=length) {
					cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
				}
				//
				if (pos.getX() + 1 <= length) {
					cbm.changeActualBlock(pos.getX()+1, pos.getY(), number);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
				}
				break;

			default:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
				}
				//
				if (pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
				}
				//
				if (pos.getX() + 1 <=length ) {
					cbm.changeActualBlock(pos.getX() +1, pos.getY(), number);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
				}
				//
				if (pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
				}
				break;
			}
			break;
		}
		if(effective){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hide(ChessBoardModel cbm) {
		int state = cbm.getActualBlockState(pos.getX(), pos.getY());
		if (player == 0) {
			if (state == 1 || state == 4 || state == 5) {
				hide = true;
				cbm.changeActualBlock(pos.getX(), pos.getY(), false);
				return true;
			} else {
				return false;
			}
		} else {
			if (state == 2 || state == 3 || state == 6) {
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
}
