package model.po;

import java.util.ArrayList;

public class InfomationLibrary {
	
	private ArrayList<Infomation> infomationLibraries = new ArrayList<Infomation>();

	public InfomationLibrary() {
	
	}

	// 初始化所有的描述 在创建对象的时候调用一次即可
	public void initialize() {
		infomationLibraries.add(new Infomation(11, "训练用木矛", "木质的训练用武器，常被小孩子拿来用作战争游戏的道具"));
		infomationLibraries.add(new Infomation(12, "狩猎石矛", "丛林地区人们用来狩猎的石矛，可以刺穿动物的心脏"));
		infomationLibraries.add(new Infomation(13, "寒铁战戟", "用铸铁打造的战戟，在战争中被广泛使用"));
		infomationLibraries.add(new Infomation(23, "勇士长矛", "正规军所用的反骑兵武器，拿着它作战的士兵被称为勇士"));
		infomationLibraries.add(new Infomation(33, "敏捷短矛", "短小精悍的武器，常常被用于偷袭作战之中，其灵活性完全可以弥补其长度上的劣势"));
		infomationLibraries.add(new Infomation(14, "花缨枪", "头部有花做装饰的长枪，往往被将领们使用，象征为了换取和平之花的正义圣战"));
		infomationLibraries.add(new Infomation(34, "穿心之矛", "特种部队最喜爱的武器，凭借其锋利的枪尖刺穿敌人的心脏，是暗杀任务的首选武器"));
		infomationLibraries.add(new Infomation(15, "颤栗", "这把戟由极寒冰铁打造而成，它的气息使靠近他的人颤栗不已，据说在月光下连恶鬼都不敢靠近"));
		infomationLibraries.add(new Infomation(25, "龙啸", "一点寒芒先到，随后枪出如龙，枪出之声，似龙啸也"));
		infomationLibraries.add(new Infomation(35, "狂热", "战争中它的影子，就像狂乱的热浪，无形却致命"));
		infomationLibraries.add(new Infomation(16, "浩劫", "“感觉像到了世界末日，海啸，地震，太阳都看不见了……”---一位幸存者如是说"));
		infomationLibraries.add(new Infomation(26, "破晓", "战争的漫漫长夜，只等它的一次破晓"));
		infomationLibraries.add(new Infomation(36, "月耀", "月神之力隐于此，月圆之时，就是胜利之日"));
	}

	public String getNameInfomation(int tag) {
		for (Infomation item : infomationLibraries) {
			if (item.getTag() == tag) {
				return item.getName();
			}
		}
		return null;
	}

	public String getDescriptionInfomation(int tag) {
		for (Infomation item : infomationLibraries) {
			if (item.getTag() == tag) {
				return item.getDescription();
			}
		}
		return null;
	}

}
