package model.po;

import java.util.ArrayList;

public class PropsStore {
	ArrayList<Props> props = new ArrayList<Props>();

	private void useHPjar(int level, SamuraiPO samuraiPO) {
		switch (level) {
		case 1:
			if (samuraiPO.getHealthPoint() + 30 > samuraiPO.getTotalHealthPoint()) {
				samuraiPO.setHealthPoint(samuraiPO.getHealthPoint() + 30);
			} else {
				samuraiPO.setHealthPoint(samuraiPO.getTotalHealthPoint());
			}
			break;
		case 2:
			if (samuraiPO.getHealthPoint() + 80 > samuraiPO.getTotalHealthPoint()) {
				samuraiPO.setHealthPoint(samuraiPO.getHealthPoint() + 80);
			} else {
				samuraiPO.setHealthPoint(samuraiPO.getTotalHealthPoint());
			}
			break;
		case 3:
			if (samuraiPO.getHealthPoint() + 150 > samuraiPO.getTotalHealthPoint()) {
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
}
