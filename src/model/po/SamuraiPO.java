package model.po;

import java.io.Serializable;

import model.ChessBoardModel;

/**
 * 所有武士类的父类，必须实现序列化接口
 * 
 * @author Sorumi
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

	public SamuraiPO(int number, int player, int weapon, int length) {
		this.number = number;
		this.player = player;
		this.weapon = weapon;
		this.length = length;
		if (number == 0 && player == 0) {
			pos = new Position(0, 0);
		} else if (number == 1 && player == 0) {
			pos = new Position(length / 2, 0);
		} else if (number == 2 && player == 0) {
			pos = new Position(length, 0);
		} else if (number == 0 && player == 1) {
			pos = new Position(0, length);
		} else if (number == 1 && player == 1) {
			pos = new Position(length / 2, length);
		} else {
			pos = new Position(length, length);
		}
	}

	// 0:up 1:right 2:left 3:down
	public boolean move(int direction, ChessBoardModel cbm) {
		int state;
		switch (direction) {
		case 0:
			state = cbm.getActualBlockState(pos.getX() - 1, pos.getY());
			if (pos.getX() - 1 >= 0) {
				if (!cbm.getActualBlockOccupied(pos.getX() - 1, pos.getY())) {
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
						pos.setX(pos.getX() - 1);
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
			break;
		case 1:
			state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
			if (pos.getY() - 1 >= 0) {
				if (!cbm.getActualBlockOccupied(pos.getX(), pos.getY() - 1)) {
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
						pos.setY(pos.getY() - 1);
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
			break;
		case 2:
			state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
			if (pos.getY() + 1 <= length) {
				if (!cbm.getActualBlockOccupied(pos.getX(), pos.getY() + 1)) {
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
						pos.setY(pos.getY() + 1);
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
			break;
		default:
			state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
			if (pos.getX() + 1 <= length) {
				if (!cbm.getActualBlockOccupied(pos.getX() + 1, pos.getY())) {
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
						pos.setX(pos.getX() + 1);
					}
				} else {
					return false;
				}

			} else {
				return false;
			}
			break;
		}
		return true;
	}

	// 0:up 1:right 2:left 3:down
	public boolean occupied(int direction) {
		return true;
	}

	public boolean hide(ChessBoardModel cbm) {
		int state = cbm.getActualBlockState(pos.getX(), pos.getY());
		if (player == 0) {
			if (state == 1 || state == 4 || state == 5) {
				hide = true;
				return true;
			} else {
				return false;
			}
		} else {
			if (state == 2 || state == 3 || state == 6) {
				hide = true;
				return true;
			} else {
				return false;
			}
		}
	}
}
