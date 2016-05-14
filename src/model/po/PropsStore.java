package model.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

//若大起大落是KILL  不要调用他的replace
public class PropsStore implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<Props> props = new ArrayList<Props>();
	private int money;
	Random random = new Random();

	public PropsStore(){
		this.money = 0;
	}

	public void updateMoney(int delta){
		this.money += delta;
	}

	public String use(int type, SamuraiPO samuraiPO) {
		int check = (type - 700) / 10;
		switch (check) {
		case 0:
			useHPJar(check % 10, samuraiPO);
			break;
		case 1:
			useAPJar(check % 10, samuraiPO);
			break;
		case 2:
			useAttackPointJar(check % 10, samuraiPO);
			break;
		case 3:
			useCriticalHitRateJar(check % 10, samuraiPO);
			break;
		case 4:
			if (random.nextBoolean()) {
				return "kill";
			} else {
				useBigSurprise(samuraiPO);
			}
			break;
		case 5:
			if (random.nextBoolean()) {
				samuraiPO.setHealthPoint(10);
			} else {
				useSmallSurprise(samuraiPO);
			}
			break;
		default:
			System.out.println("Props wrong");
			break;
		}
		return null;
	}

	public String replace(int type, SamuraiPO samuraiPO) {
		int check = (type - 700) / 10;
		switch (check) {
		case 2:
			replaceAttackPointJar(check % 10, samuraiPO);
			break;
		case 3:
			replaceCriticalHitRateJar(check % 10, samuraiPO);
			break;
		case 4:
			replaceBigSurprise(samuraiPO);
			break;
		case 5:
			replaceSmallSurprise(samuraiPO);
			break;
		default:
			break;
		}
		return null;
	}

	private void useHPJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			if (samuraiPO.getHealthPoint() + 30 <= samuraiPO.getTotalHealthPoint()) {
				samuraiPO.setHealthPoint(samuraiPO.getHealthPoint() + 30);
			} else {
				samuraiPO.setHealthPoint(samuraiPO.getTotalHealthPoint());
			}
			break;
		case 2:
			if (samuraiPO.getHealthPoint() + 80 <= samuraiPO.getTotalHealthPoint()) {
				samuraiPO.setHealthPoint(samuraiPO.getHealthPoint() + 80);
			} else {
				samuraiPO.setHealthPoint(samuraiPO.getTotalHealthPoint());
			}
			break;
		case 3:
			if (samuraiPO.getHealthPoint() + 150 <= samuraiPO.getTotalHealthPoint()) {
				samuraiPO.setHealthPoint(samuraiPO.getHealthPoint() + 150);
			} else {
				samuraiPO.setHealthPoint(samuraiPO.getTotalHealthPoint());
			}

			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void useAPJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			if (samuraiPO.getActionPoint() + 4 <= samuraiPO.getTotalActionPoint()) {
				samuraiPO.setActionPoint(samuraiPO.getActionPoint() + 4);
			} else {
				samuraiPO.setActionPoint(samuraiPO.getTotalActionPoint());
			}
			break;
		case 2:
			if (samuraiPO.getActionPoint() + 8 <= samuraiPO.getTotalActionPoint()) {
				samuraiPO.setActionPoint(samuraiPO.getActionPoint() + 8);
			} else {
				samuraiPO.setActionPoint(samuraiPO.getTotalActionPoint());
			}
			break;
		case 3:
			if (samuraiPO.getActionPoint() + 15 <= samuraiPO.getTotalActionPoint()) {
				samuraiPO.setActionPoint(samuraiPO.getActionPoint() + 15);
			} else {
				samuraiPO.setActionPoint(samuraiPO.getTotalActionPoint());
			}
			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void useAttackPointJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			samuraiPO.changeAttackPoint(30);
			break;
		case 2:
			samuraiPO.changeAttackPoint(70);
			break;
		case 3:
			samuraiPO.changeAttackPoint(120);
			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void replaceAttackPointJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			samuraiPO.changeAttackPoint(-30);
			break;
		case 2:
			samuraiPO.changeAttackPoint(-70);
			break;
		case 3:
			samuraiPO.changeAttackPoint(-120);
			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void useCriticalHitRateJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			samuraiPO.changeCriticalHitRate(10);
			break;
		case 2:
			samuraiPO.changeCriticalHitRate(25);
			break;
		case 3:
			samuraiPO.changeCriticalHitRate(40);
			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void replaceCriticalHitRateJar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			samuraiPO.changeCriticalHitRate(-10);
			break;
		case 2:
			samuraiPO.changeCriticalHitRate(-25);
			break;
		case 3:
			samuraiPO.changeCriticalHitRate(-40);
			break;

		default:
			System.out.println("Props wrong!");
			break;
		}
	}

	private void useBigSurprise(SamuraiPO samuraiPO) {
		samuraiPO.changeAttackPoint(200);
		samuraiPO.changeCriticalHitRate(100);
	}

	private void replaceBigSurprise(SamuraiPO samuraiPO) {
		samuraiPO.changeAttackPoint(-200);
		samuraiPO.changeCriticalHitRate(-100);
	}

	private void useSmallSurprise(SamuraiPO samuraiPO) {
		samuraiPO.changeAttackPoint(200);
		samuraiPO.changeCriticalHitRate(50);
	}

	private void replaceSmallSurprise(SamuraiPO samuraiPO) {
		samuraiPO.changeAttackPoint(-200);
		samuraiPO.changeCriticalHitRate(-50);
	}
}
