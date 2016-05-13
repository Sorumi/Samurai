package model.po;

import java.util.ArrayList;

public class PropsStore {
	ArrayList<Props> props = new ArrayList<Props>();

	private void useHPjar(int level, SamuraiPO samuraiPO) {
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
	private void useAPjar(int level, SamuraiPO samuraiPO) {
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
}