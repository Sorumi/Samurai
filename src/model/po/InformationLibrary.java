package model.po;

import java.io.Serializable;
import java.util.ArrayList;

public class InformationLibrary implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Information> informationLibraries;


	public InformationLibrary() {
		informationLibraries = new ArrayList<Information>();
	}

	// 初始化所有的描述 在创建对象的时候调用一次即可
	public void initialize() {
		informationLibraries.add(new Information(11, "训练用木矛", "木质的训练用武器，常被小孩子拿来用作战争游戏的道具"));
		informationLibraries.add(new Information(12, "狩猎石矛", "丛林地区人们用来狩猎的石矛，可以刺穿动物的心脏"));
		informationLibraries.add(new Information(13, "寒铁战戟", "用铸铁打造的战戟，在战争中被广泛使用"));
		informationLibraries.add(new Information(23, "勇士长矛", "正规军所用的反骑兵武器，拿着它作战的士兵被称为勇士"));
		informationLibraries.add(new Information(33, "敏捷短矛", "短小精悍的武器，常常被用于偷袭作战之中，其灵活性完全可以弥补其长度上的劣势"));
		informationLibraries.add(new Information(14, "花缨枪", "头部有花做装饰的长枪，往往被将领们使用，象征为了换取和平之花的正义圣战"));
		informationLibraries.add(new Information(34, "穿心之矛", "特种部队最喜爱的武器，凭借其锋利的枪尖刺穿敌人的心脏，是暗杀任务的首选武器"));
		informationLibraries.add(new Information(15, "颤栗", "这把戟由极寒冰铁打造而成，它的气息使靠近他的人颤栗不已，据说在月光下连恶鬼都不敢靠近"));
		informationLibraries.add(new Information(25, "龙啸", "一点寒芒先到，随后枪出如龙，枪出之声，似龙啸也"));
		informationLibraries.add(new Information(35, "狂热", "战争中它的影子，就像狂乱的热浪，无形却致命"));
		informationLibraries.add(new Information(16, "浩劫", "“感觉像到了世界末日，海啸，地震，太阳都看不见了……”---一位幸存者如是说"));
		informationLibraries.add(new Information(26, "26", "26"));
		informationLibraries.add(new Information(36, "36", "36"));
		informationLibraries.add(new Information(111, "111", "111"));
		informationLibraries.add(new Information(112, "112", "112"));
		informationLibraries.add(new Information(132, "132", "132"));
		informationLibraries.add(new Information(113, "113", "113"));
		informationLibraries.add(new Information(124, "124", "124"));
		informationLibraries.add(new Information(114, "114", "114"));
		informationLibraries.add(new Information(134, "134", "134"));
		informationLibraries.add(new Information(125, "125", "125"));
		informationLibraries.add(new Information(115, "115", "115"));
		informationLibraries.add(new Information(135, "135", "135"));
		informationLibraries.add(new Information(126, "126", "126"));
		informationLibraries.add(new Information(116, "116", "116"));
		informationLibraries.add(new Information(136, "136", "136"));
		informationLibraries.add(new Information(211, "211", "211"));
		informationLibraries.add(new Information(212, "212", "212"));
		informationLibraries.add(new Information(213, "213", "213"));
		informationLibraries.add(new Information(233, "233", "233"));
		informationLibraries.add(new Information(214, "214", "214"));
		informationLibraries.add(new Information(234, "234", "234"));
		informationLibraries.add(new Information(215, "215", "215"));
		informationLibraries.add(new Information(225, "225", "225"));
		informationLibraries.add(new Information(235, "235", "235"));
		informationLibraries.add(new Information(216, "216", "216"));
		informationLibraries.add(new Information(226, "226", "226"));
		informationLibraries.add(new Information(236, "236", "236"));
		informationLibraries.add(new Information(311, "311", "311"));
		informationLibraries.add(new Information(312, "312", "312"));
		informationLibraries.add(new Information(313, "313", "313"));
		informationLibraries.add(new Information(323, "323", "323"));
		informationLibraries.add(new Information(314, "314", "314"));
		informationLibraries.add(new Information(324, "324", "324"));
		informationLibraries.add(new Information(315, "315", "315"));
		informationLibraries.add(new Information(325, "325", "325"));
		informationLibraries.add(new Information(316, "316", "316"));
		informationLibraries.add(new Information(326, "326", "326"));
		informationLibraries.add(new Information(411, "411", "411"));
		informationLibraries.add(new Information(412, "412", "412"));
		informationLibraries.add(new Information(422, "422", "422"));
		informationLibraries.add(new Information(413, "413", "413"));
		informationLibraries.add(new Information(423, "423", "423"));
		informationLibraries.add(new Information(414, "414", "414"));
		informationLibraries.add(new Information(424, "424", "424"));
		informationLibraries.add(new Information(415, "415", "415"));
		informationLibraries.add(new Information(425, "425", "425"));
		informationLibraries.add(new Information(416, "416", "416"));
		informationLibraries.add(new Information(426, "426", "426"));
		informationLibraries.add(new Information(800, "800", "800"));
		informationLibraries.add(new Information(801, "801", "801"));
		informationLibraries.add(new Information(802, "802", "802"));
		informationLibraries.add(new Information(803, "803", "803"));
		informationLibraries.add(new Information(810, "810", "810"));
		informationLibraries.add(new Information(811, "811", "811"));
		informationLibraries.add(new Information(812, "812", "812"));
		informationLibraries.add(new Information(813, "813", "813"));
		informationLibraries.add(new Information(820, "820", "820"));
		informationLibraries.add(new Information(821, "821", "821"));
		informationLibraries.add(new Information(822, "822", "822"));
		informationLibraries.add(new Information(823, "823", "823"));
		informationLibraries.add(new Information(830, "830", "830"));
		informationLibraries.add(new Information(831, "831", "831"));
		informationLibraries.add(new Information(832, "832", "832"));
		informationLibraries.add(new Information(833, "833", "833"));
		informationLibraries.add(new Information(840, "840", "840"));
		informationLibraries.add(new Information(841, "841", "841"));
		informationLibraries.add(new Information(842, "842", "842"));
		informationLibraries.add(new Information(843, "843", "843"));
		informationLibraries.add(new Information(911, "911", "911"));
		informationLibraries.add(new Information(912, "912", "912"));
		informationLibraries.add(new Information(913, "913", "913"));
		informationLibraries.add(new Information(933, "933", "933"));
		informationLibraries.add(new Information(914, "914", "914"));
		informationLibraries.add(new Information(924, "924", "924"));
		informationLibraries.add(new Information(934, "934", "934"));
		informationLibraries.add(new Information(915, "915", "915"));
		informationLibraries.add(new Information(925, "925", "925"));
		informationLibraries.add(new Information(935, "935", "935"));
		informationLibraries.add(new Information(916, "916", "916"));
		informationLibraries.add(new Information(926, "926", "926"));
		informationLibraries.add(new Information(936, "936", "936"));

	}

	public String getNameInformation(int tag) {
		for (Information item : informationLibraries) {
			if (item.getTag() == tag) {
				return item.getName();
			}
		}
		return null;
	}

	public String getDescriptionInformation(int tag) {
		for (Information item : informationLibraries) {
			if (item.getTag() == tag) {
				return item.getDescription();
			}
		}
		return null;
	}

	public Information getInformationOfTag(int tag) {
		System.out.println(tag);
		for (Information item : informationLibraries) {
			if (item.getTag() == tag) {
				System.out.println(tag);
				return item;
			}
		}
		System.out.println("Your tag is Wrong!");
		return null;
	}
}
