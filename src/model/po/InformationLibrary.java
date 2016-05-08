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
		informationLibraries.add(new Information(11, "训练用木矛", "木质的训练用武器，常被小孩子拿来用作战争游戏的道具。"));
		informationLibraries.add(new Information(12, "狩猎石矛", "丛林地区人们用来狩猎的石矛，可以刺穿动物的心脏。"));
		informationLibraries.add(new Information(13, "寒铁战戟", "用铸铁打造的战戟，在战争中被广泛使用。"));
		informationLibraries.add(new Information(23, "勇士长矛", "正规军所用的反骑兵武器，拿着它作战的士兵被称为勇士。"));
		informationLibraries.add(new Information(33, "敏捷短矛", "短小精悍的武器，常常被用于偷袭作战之中，其灵活性完全可以弥补其长度上的劣势。"));
		informationLibraries.add(new Information(14, "花缨枪", "头部有花做装饰的长枪，往往被将领们使用，象征为了换取和平之花的正义圣战。"));
		informationLibraries.add(new Information(34, "穿心之矛", "特种部队最喜爱的武器，凭借其锋利的枪尖刺穿敌人的心脏，是暗杀任务的首选武器。"));
		informationLibraries.add(new Information(15, "颤栗", "这把戟由极寒冰铁打造而成，它的气息使靠近他的人颤栗不已，据说在月光下连恶鬼都不敢靠近。"));
		informationLibraries.add(new Information(25, "龙啸", "一点寒芒先到，随后枪出如龙，枪出之声，似龙啸也。"));
		informationLibraries.add(new Information(35, "狂热", "战争中它的影子，就像狂乱的热浪，无形却致命。"));
		informationLibraries.add(new Information(16, "浩劫", "“感觉像到了世界末日，海啸，地震，太阳都看不见了……”/n——一位幸存者如是说"));
		informationLibraries.add(new Information(26, "26", "26"));
		informationLibraries.add(new Information(36, "36", "36"));
		informationLibraries.add(new Information(111, "训练用木剑", "道场内初级剑士的训练用剑，前年过世的剑道馆长坚持亲手用上质桃木制成，现已绝版。"));
		informationLibraries.add(new Information(112, "燧石长剑", "“哎！为了把这些石头从洞窟里拉回来，我可没少被蝙蝠咬！赚钱真不容易……”/n——矮人矿工"));
		informationLibraries.add(new Information(132, "石制短刀", "打猎时追求极致速度而发明的石制短刀，在对抗野猪时发挥高效的作用。/n“嗷恩啊啊啊啊！！”/n——野猪"));
		informationLibraries.add(new Information(113, "武士长剑", "无鞘之刃，剑气凌人。据传曾有一名使用者仅挥出一剑，满树叶落，犹如入冬。"));
		informationLibraries.add(new Information(133, "刺杀袖剑", "受刺客、杀手青睐的袖剑，纤小的体型方便藏于长袖之中，出袖之时，血溅当场。"));
		informationLibraries.add(new Information(124, "断头台", "追求力量而锻造的巨剑，取敌首级如探囊取物，光是骇人的巨型剑身便让心邪之人闻风丧胆。"));
		informationLibraries.add(new Information(114, "骑士佩剑", "骑士团的标准佩剑，用精钢炼制，剑刃锋利至极，卸甲穿心轻而易举。"));
		informationLibraries.add(new Information(134, "淬毒匕首", "扭曲的匕刃便于刺入目标体内后毒素的蔓延。若是今晚的夜色中无意发现一丝绿芒，奉劝一句走为上策。"));
		informationLibraries.add(new Information(125, "诸神黄昏", "传说中的阔剑，血红的剑柄承托着残阳色的剑身。坍塌的虹桥下，毁灭的英灵殿外，众神、巨人和魔物的尸体被炼狱的火柱所缠绕。幸存的寥寥无几的神在残破的世界内搜集坍塌的星辰和化为破镜的夕阳碎片为素材，用曾经支撑宇宙的世界之树的残枝为燃料，制成了这把诸神黄昏，以此祭奠那场惨烈战争。"));
		informationLibraries.add(new Information(115, "青釭剑", "曹氏曾用的佩剑，削铁如泥，剑身至青如玉，任何防阵与坚盾在此剑面前都是徒劳，拿起剑的瞬间仿佛还能听见千百年前的杀伐之声。"));
		informationLibraries.add(new Information(135, "嚎哭", "相较于其余稀奇古怪的刺杀武器，黑暗世界的统治者似乎更加青睐这一把略显朴实的青蓝短刀。每当有刺客背叛组织被抓回到他的面前，他就会一脸笑意的掏出这把短刀，轻轻往叛逃者眉心一点。奇怪的是，仅仅只是轻轻一点，叛徒面色便会瞬间变得古怪，仿佛看到什么极致恐怖的东西一样，开始猛烈地哀嚎，冷血杀人不眨眼的刺客竟会哭出泪水，其他刺客看到这场面都会禁不住咽口水。随着时间慢慢过去，哀嚎声逐渐消失，受刑者流下的血泪染红一大片地，随后身体像被风化的尘埃一样被吹散，仿佛从来没有存在过一样。"));
		informationLibraries.add(new Information(126, "终结", "宇宙中心的黑洞，在其背后有着另一个世界。一片原暗之中，屹立着一把巨剑，周身缠绕着黑紫色的旋涡状星辰，据说每当世界距离毁灭近一天时，这把巨剑的能量就更甚一分。无需恐惧终结，我们需要的仅是接受终结。"));
		informationLibraries.add(new Information(116, "苍穹", "圣山之巅，苍瀑之上，梅花树下，古神庙里。静谧、剑吟破空；沉寂、剑锋渗光；蒙尘、剑身上的宝石却似有心跳，将周身的空间震得仿佛即将破碎。自从前代剑圣将其遗留在此不知所踪后，无人能将其再次带入凡世。谁，将会再次带出这把古剑，让其重见苍穹。"));
		informationLibraries.add(new Information(136, "命", "他是一个面相普通和蔼的青年，有时他是门口卖包子的小二，有时他是旅店的老板，有时他是骑士团方阵中的一员。只要他想成为什么，他就能伪装成任何人。他有一把霞紫色的匕首，这是人们辨认他身份——死神 的唯一方法。被这把紫色匕首刺中的人，往往毫无感觉，仿佛什么都未曾发生一样，只是内心往往会有一点点奇怪的不安。然而几小时、几天、几月甚至几年之后就一定会死于各种非命，被落石砸死，被失手的弓箭手射穿脑袋，失足掉进河里被漩涡碾成碎片……人们传说是那个死神一样的男人干的。今天的青年也像往常一样，寂静的像不存在一样站在黑暗世界的统治者旁边。奇怪的是，仿佛没有人看得见他。只见他饶有兴趣的看着统治者的脖子上的刀痕。“你已经活了十年了，让我来看看你到底还能活多久吧。"));
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
		for (Information item : informationLibraries) {
			if (item.getTag() == tag) {
				return item;
			}
		}
		return null;
	}
}
