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
		No5.move(0, cbm);
		No5.move(2, cbm);
		ArrayList<Position> positions = No5.occupied(3, cbm,true);
		No5.move(0, cbm);
		No5.hide(cbm);
		No3.move(1, cbm);
		No3.occupied(1, cbm,true);
		for (Position po : positions) {
			System.out.println(po.getX() + "  " + po.getY());
		}
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockState(i, x) + " ");
			}
			System.out.println();
		}
		for (int i = 0; i <= 14; i++) {
			System.out.print(i + ":");
			for (int x = 0; x <= 14; x++) {
				System.out.print(cbm.getActualBlockOccupied(i, x) + " ");
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
		} else if (number == 4 && player == 0) {
			pos = new Position(length / 2, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
		} else if (number == 5 && player == 0) {
			pos = new Position(length, 0);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
		} else if (number == 2 && player == 1) {
			pos = new Position(0, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
		} else if (number == 3 && player == 1) {
			pos = new Position(length / 2, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
		} else if (number == 6 && player == 1) {
			pos = new Position(length, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
			cbm.changeActualBlock(pos.getX(), pos.getY(), number);
		}
	}

	public void beKilled(int length, ChessBoardModel cbm) {
		if (!hide) {
			cbm.changeActualBlock(pos.getX(), pos.getY(), false);
		}
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
		} else if (number == 6 && player == 1) {
			pos = new Position(length, length);
			cbm.changeActualBlock(pos.getX(), pos.getY(), true);
		}
	}

	// 0:up 1:right 2:left 3:down
	public boolean[] tryMove(ChessBoardModel cbm) {
			int state;
			boolean[] result=new boolean[4];
			for(int direction=0;direction<4;direction++){
			switch (direction) {
			case 0:
				if (pos.getX() - 1 >= 0) {
					state = cbm.getActualBlockState(pos.getX() - 1, pos.getY());
					if (cbm.getActualBlockOccupied(pos.getX() - 1, pos.getY()) || hide) {
						if (hide || player == 0) {
							if (state == 1 || state == 4 || state == 5) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}

						} else if (hide) {
							if (state == 2 || state == 3 || state == 6) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}
						} else {
							 result[direction]=false;
						}
					} else {
						result[direction]=true;
					}
				} else {
					result[direction]=false;
				}
				break;
			case 1:
				if (pos.getY() - 1 >= 0) {
					state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
					if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() - 1) || hide) {
						if (hide || player == 0) {
							if (state == 1 || state == 4 || state == 5) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}

						} else if (hide) {
							if (state == 2 || state == 3 || state == 6) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}
						} else {
							result[direction]=false;
						}
					} else {
						result[direction]=true;
					}
				} else {
					result[direction]=false;
				}
				break;
			case 2:
				if (pos.getY() + 1 <= length) {
					state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
					if (cbm.getActualBlockOccupied(pos.getX(), pos.getY() + 1) || hide) {
						if (hide || player == 0) {
							if (state == 1 || state == 4 || state == 5) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}

						} else if (hide) {
							if (state == 2 || state == 3 || state == 6) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}
						} else {
							result[direction]=false;
						}
					} else {
						result[direction]=true;
					}
				} else {
					result[direction]=false;
				}
				break;
			default:
				if (pos.getX() + 1 <= length) {
					state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
					if (cbm.getActualBlockOccupied(pos.getX() + 1, pos.getY()) || hide) {
						if (hide || player == 0) {
							if (state == 1 || state == 4 || state == 5) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}

						} else if (hide) {
							if (state == 2 || state == 3 || state == 6) {
								result[direction]=true;
							} else {
								result[direction]=false;
							}
						} else {
							result[direction]=false;
						}
					} else {
						result[direction]=true;
					}

				} else {
					result[direction]=false;
				}
				break;
			}
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
			if (pos.getY() - 1 >= 0) {
				state = cbm.getActualBlockState(pos.getX(), pos.getY() - 1);
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
			if (pos.getY() + 1 <= length) {
				state = cbm.getActualBlockState(pos.getX(), pos.getY() + 1);
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
			if (pos.getX() + 1 <= length) {
				state = cbm.getActualBlockState(pos.getX() + 1, pos.getY());
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
	public ArrayList<Position> occupied(int direction, ChessBoardModel cbm,boolean real) {
		ArrayList<Position> positions = new ArrayList<Position>();
		switch (weapon) {
		// weapon 0
		case 0:
			switch (direction) {
			case 0:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					if(real){
					cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				break;
			case 1:
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 4; i--, x++) {
					if(real){
					cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 2:
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 4; i++, x++) {
					if(real){
					cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			default:
				for (int i = pos.getX() + 1, x = 0; i >= 0 && x < 4; i++, x++) {
					if(real){
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
					if(real){
					cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if(real){
					cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if(real){
					cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 1:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if(real){
					cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if(real){
					cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				for (int i = pos.getY() - 1, x = 0; i >= 0 && x < 2; i--, x++) {
					if(real){
					cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;
			case 2:
				for (int i = pos.getX() - 1, x = 0; i >= 0 && x < 2; i--, x++) {	
					if(real){
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if(real){
						cbm.changeActualBlock(pos.getX(), i, number);
					}
					Position position = new Position(pos.getX(), i);
					positions.add(position);
				}
				break;

			default:
				for (int i = pos.getX() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if(real){
						cbm.changeActualBlock(i, pos.getY(), number);
					}
					Position position = new Position(i, pos.getY());
					positions.add(position);
				}
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				for (int i = pos.getY() + 1, x = 0; i <= length && x < 2; i++, x++) {
					if(real){
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
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;
			case 1:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;
			case 2:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() + 1);
					positions.add(position);
				}
				break;

			default:
				if (pos.getX() + 1 <= length && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() - 1 >= 0) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() - 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() - 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() + 1, pos.getY(), number);
					}
					Position position = new Position(pos.getX() + 1, pos.getY());
					positions.add(position);
				}
				//
				if (pos.getX() - 1 >= 0 && pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX() - 1, pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX() - 1, pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getY() + 1 <= length) {
					if(real){
						cbm.changeActualBlock(pos.getX(), pos.getY() + 1, number);
					}
					Position position = new Position(pos.getX(), pos.getY() + 1);
					positions.add(position);
				}
				//
				if (pos.getX() + 1 <= length && pos.getY() + 1 <= length) {
					if(real){
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
