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
		informationLibraries.add(new Information(16, "浩劫", "“感觉像到了世界末日，海啸，地震，太阳都看不见了……”\n                              ——一位幸存者如是说"));
		informationLibraries.add(new Information(26, "破晓", "26"));
		informationLibraries.add(new Information(36, "月耀", "36"));
		informationLibraries.add(new Information(111, "训练用木剑", "道场内初级剑士的训练用剑，前年过世的剑道馆长坚持亲手用上质桃木制成，现已绝版。"));
		informationLibraries.add(new Information(112, "燧石长剑", "“哎！为了把这些石头从洞窟里拉回来，我可没少被蝙蝠咬！赚钱真不容易……”\n                                                  ——矮人矿工"));
		informationLibraries.add(new Information(132, "石制短刀", "打猎时追求极致速度而发明的石制短刀，在对抗野猪时发挥高效的作用。\n                                            “嗷恩啊啊啊啊！！”\n                                                  ——野猪"));
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
		informationLibraries.add(new Information(211, "训练用木斧", "“嘿！菜鸟！拿着的时候当心点！不知道有多少新兵蛋子没拿稳把自己脚砸肿啦！”\n                                                  ——铁匠铺老板 "));
		informationLibraries.add(new Information(212, "伐木石斧","樵夫广泛用于砍木材的石制斧子，斧刃锋利，熊孩子们从小就被妈妈教育不要随便乱碰。"));
		informationLibraries.add(new Information(213, "制式战斧" ,"“俺觉得打仗有这三点就赢啦！喊得响、冲得猛、有一把不会脱手的好斧子！”\n                                          ——有手汗的大胡子正规军人"));
		informationLibraries.add(new Information(233, "利刃手斧","锋利的战斧，短柄武器中的翘楚，以高机动性击中敌人要害。流血，轻而易举。"));
		informationLibraries.add(new Information(214, "试炼巨斧", "防守军务要地的禁军所持的重型巨斧，没有胆量的人甚至看到巨大的斧身便会腿软跪下"));
		informationLibraries.add(new Information(234, "炽炎战斧", "浸润过高温火山岩浆洗礼的手斧，杀伐之时，斧身赤红如血，散发出的高热让被斩于马下的敌人仿佛坠入地狱。"));
		informationLibraries.add(new Information(215, "审判" ,"传说中击溃来敌的迷之巨人曾经使用过的巨斧，斧身一分为二。\n “我们要审判的不只是面前的敌人，还有我们自己的灵魂。” \n                                        ——巨人的石灵碑言"));
		informationLibraries.add(new Information(225, "雷神之锤", "掌管雷电的天神所使用的巨锤，狂暴的雷电之力使得锤身常伴令人心生惧意的金色电弧。据说只要雷神一伸手，雷神之锤就能飞回他的手中。\n“只有雷神才能举得起来，不信你试试？”\n                                                ——某个雷神"));
		informationLibraries.add(new Information(235, "鬼影","曾经有一名顶尖盗贼头目从阴暗的地穴中冒死从活死人的手中抢来这把颜色诡异却令人着迷的暗紫色短斧。自此，盗贼头目无往不利，无数次帮派间的争斗都取下敌将首级。直到一天夜里，盗贼麾下的谋士进入他休息的房间内，才终于发现，斧子静静的躺在头目的床上，而眼神涣散的头目早已被抽干灵魂随意地丢在床边。后来再也没有人见过这个谋士，灵魂干涸的“头目”还是继续“带”着他的鬼兵出没于荒山野岭……"));
		informationLibraries.add(new Information(216, "起源","那一斧，分开天与地，绿色的幽光照亮了天与地之间所有的事物，此后，便有了生命与轮回。"));
		informationLibraries.add(new Information(226, "矢志不渝","传说中举起这把武器的人必须信念坚定，摈弃私心，一切行动都必须化身为秩序与正义的代言人，一旦有恶行，这把武器就会抛弃使用者。"));
		informationLibraries.add(new Information(236, "梦魇","据说见过这把武器的人无一生还——哦不，还有一个人活着回来。只是他眼神涣散，心智不宁，他因精神失常被关在地牢的最深处。宫廷的夜晚，仿佛还能听见地底下的最深处传来的刺耳的低语。“那是梦魇、梦魇……”"));
		informationLibraries.add(new Information(311, "训练用木镖"	,"为了增加任务隐蔽性和成功率而衍生的投掷型武器，由坚松木制成。"));
		informationLibraries.add(new Information(312, "石质星镖","镖身呈星状的石质镖，极度具有穿透力。"));
		informationLibraries.add(new Information(313, "寒铁刃","用从冻土矿层运来的上质铁铸成的手里剑。"));
		informationLibraries.add(new Information(323, "回旋镖","采用风车型镖身的手里剑，螺旋的线条加快了飞行速度并且在贯穿目标后能够悄无声息地飞回使用者手里，徒留目标身首异处不留一丝踪迹。"));
		informationLibraries.add(new Information(314, "忍者苦无","为忍者执行任务特化射速和破坏力的苦无。这支是樱花限量特别版的。"));
		informationLibraries.add(new Information(324, "风之信镖","风之谷深处的隐世忍者所使用的武器，穿透力极其强大以至于投掷出的瞬间能使气压改变，狂风大作。如果在风之谷突然感到狂风袭来，赶紧原路返回离开，第一发只是警告，第二发可就不会打偏了。"));
		informationLibraries.add(new Information(315, "因果","双刃手里剑，为了增加近战搏斗能力的武器，稍有不慎便会伤到自身，使用者将自己的因果与武器绑定在一起，每当进行一次杀戮就会增加一份因果之力，获得巨大力量的同时，一生都无法舍弃这把武器。刃折人亡，是为死士所用。"));
		informationLibraries.add(new Information(325, "霜降",	"北方雪国的凌晨，形迹可疑的风衣男子从临时租赁的屋子小心翼翼地护着衣内的包裹，“只要翻过前面那座矮山到另一边，我的任务就结束了。”--男子这样想着。空气很湿，这一天多云。男子跨过山巅，不禁呼出一口气——“为了这一天，我可伪装的太久了。”突然，毫无征兆的，雪花从空中慢慢飘落。男子刚刚放松下来的神情开始紧绷起来，甚至有些狰狞。他开始狂奔，因为他心里明白，那根本就不是什么雪花。他也明白，他或许是跑不了了。"));
		informationLibraries.add(new Information(316, "影","忍者在执行任务时为了避免自身暴露于目标视野内，常常使用一些技巧隐蔽自身的存在。有一个忍者从来不隐藏自身的存在，他会突然出现在目标面前，轻声的说一句“我是来刺杀你的。”然后再次消失。午夜之时，忍者在树上低头沉思，偶尔抬头看看满月。而任务目标在千里之外就会离奇死亡，没有伤痕，没有痛楚。没有人知道他是如何做到这样神奇的刺杀，只有他自己明白，他只是切断了目标的影子。"));
		informationLibraries.add(new Information(326, "时","时间裂缝中吸取无数平行宇宙历史中纯净的杀戮力量而形成的武器，因大战后杀戮力量过于强大，时间裂缝破碎，这把武器得以见世。蕴含的力量可以改变时间的流速，如果能量足够强大甚至可以短暂的停滞时间，将时间的力量转换为破坏力，届时无人能够逃脱。"));
		informationLibraries.add(new Information(411, "训练用木弓"	,"用桑木制成的木弓，在数百米内发挥都很稳定.\n“请不要没事把苹果放在别人头上射着玩。”\n                                                ——训练场木牌"));
		informationLibraries.add(new Information(412, "松木短弓",	"当你站如松时用这把松木短弓就能轻松地射下松鼠住的那颗松树上的小松果。"));
		informationLibraries.add(new Information(422, "石质连发器","灰色原石制成的弩型连发器，追求更强的爆发伤害。"));
		informationLibraries.add(new Information(413, "兽角弓","猎人坐在火炉旁，轻轻抚摸自己左眼的伤疤，想起那夜与那只猛兽拼上性命的搏斗，伤口依然隐隐作痛，壁炉上的弓虽是死物，却依然魄力十足。"));
		informationLibraries.add(new Information(423, "弩·原型重组","复古风格的弩，按照第一把原型弩改良并强化的高射速弩，破坏力惊人，满弦可一箭射穿厚钢板。"));
		informationLibraries.add(new Information(414, "苍漠孤狼",	"在苍漠之中，沙尘飞扬可视度极低，这对一个弓手来说是致命的。而苍漠之上有一名射手，箭无虚发，他为自己的弓取名“孤狼”，他说“孤狼”会自己寻找猎物。"));
		informationLibraries.add(new Information(424, "强弩·银星雀","轻便的弩。武器职人上山采取素材时发现山间银星雀凭借星座方向加速冲刺而受到启发制成的弩，对应星座的设计使得每一箭都具有极高射速的特点，甚至能够凭借不同星象获取不同的额外效果。"));
		informationLibraries.add(new Information(415, "深渊","炼狱中曾有一只臭名昭著的赤翼恶魔，来到文明世界大肆屠戮，所到之处皆为火海废墟。一名独眼神射手与山巅上意图讨伐这灾祸之源，神射手凭借自己的敏捷身法和高超射术与其周旋良久，射出的每一发箭都命中恶魔的弱点。射光最后一支箭后，斜倚着枯树的神射手掏出自己的匕首，迎面扑向恶魔与其进行最后的搏斗，混乱中砍下恶魔的赤翼，同时也被恶魔的尖爪贯穿了另一只眼睛，最后与遍体鳞伤的恶魔双双坠下悬崖。后世的人为了铭记英雄，用恶魔的断翅为弓，爪尖为箭，制成“深渊”。"));
		informationLibraries.add(new Information(425, "苍弩·鹰眼","用山巅黑苍魔鹰的脊骨制成弩身，每一发弩箭都必须附上魔鹰羽，否则弩身拒绝装填。适用于夜色笼罩的狭窄地带，每一发箭都将附带骇人心魄的鹰啸，极少数人能够逃脱这种耳膜与心灵的双重折磨。"));
		informationLibraries.add(new Information(416, "重生","据说到达一定境界的射手无论种族无论善恶都会在过世后，灵魂会被领到一片虚无缥缈之境内，双眼蒙上无法卸下的白纱，思忖着现世射的每一发箭，每一次射中或没射中的感觉都被无限的放大，每一次杀戮或每一次拯救的感受都被剔去了个人的情感，只剩下那纯净的射手的执念。绝境之主，手持一把白翼巨弓，每当有人完成了现世的回想，他就负责将其灵魂用箭失带出绝境，进行来世的轮回。它感悟着所有射手的灵魂，等待比自身更强的灵魂取代它的工作，这次“重生”，它已等待千年。"));
		informationLibraries.add(new Information(426, "神弩·菲尼克斯","传说凤凰涅槃时用神火烧尽自己的羽翼，焚化自己的肉身，湮灭自己的双眸，在完全的逆境中殊死一搏，转世重生。赤红色的神弩甚至不需要使用者准备弓箭，因为使用她的代价，是付出自己的灵魂能量；灵魂能量越强，箭羽的能量就越可怕。每一次战斗之后，使用者都将和凤凰一样经受浴火的考验，信念坚定如一者不仅能获得涅槃，更能使自己更强；而有所动摇者都将化为历史中毫不起眼的灰烬尘埃。"));
		informationLibraries.add(new Information(800, "纱布", "战场上用于包扎伤口的粗布，也常常用来给衣物打补丁。"));
		informationLibraries.add(new Information(801, "纺布", "民间织女纺出来的素布，质地柔韧，由于随处可见并不稀有。"));
		informationLibraries.add(new Information(802, "丝绸", "从古老的东方国度运来的绸缎，经历了大漠的沧桑，北风的呼啸，海洋的狂澜，高山的巍峨，见证了一个又一个国度的兴起和衰落，是珍贵的皇室用品。"));
		informationLibraries.add(new Information(803, "云锦", "用这种布料制成的衣服如云彩一般轻盈，据说是仙女下凡时遗忘的，仅被少数人珍藏，早已不进入市场流通。"));
		informationLibraries.add(new Information(810, "松木", "砍伐松树的来的木质，有一定的韧性"));
		informationLibraries.add(new Information(811, "槐木", "有着紫色纹理的木质，似乎还有着槐花的香气"));
		informationLibraries.add(new Information(812, "雪山云杉", "生长在雪山之巅的古树，常常要冒着生命危险才能接近，伐木工人谁也不愿意接这种活，只有专注于武器质量的工匠才会去砍伐。"));
		informationLibraries.add(new Information(813, "不朽神木", "见过它的生物不断死亡，与它共存的物质不断消逝，只有它还存在于这里，熠熠生辉。"));
		informationLibraries.add(new Information(820, "鹅卵石", "采石船打捞上来的石头，没有什么价值。"));
		informationLibraries.add(new Information(821, "圆石", "普通的石头而已，没有什么可说的。"));
		informationLibraries.add(new Information(822, "乌金石", "质地坚硬的乌黑的矿石，有经验的矿工都知道里面包含着大量的黄金。"));
		informationLibraries.add(new Information(823, "黑曜石", "传说中来自地狱的矿石，在多年的岩浆炙烤和高压下发出耀眼的光芒。"));
		informationLibraries.add(new Information(830, "铸铁", "铁匠铺里常用的铁质材料，虽然坚硬但质地脆，不能用于高精尖武器的制造。"));
		informationLibraries.add(new Information(831, "青铜", "火炉里练出的铜块，包裹一层青色的漆料防止锈蚀，谓之青铜。"));
		informationLibraries.add(new Information(832, "月之银", "由月神之力凝聚成的秘银，映照着月亮的光辉。"));
		informationLibraries.add(new Information(833, "日之金", "这种金属的光泽超过了太阳的光辉，有它存在的地方，就有光明与希望。"));
		informationLibraries.add(new Information(840, "火焰水晶", "火焰的种子被封存在这个水晶中，拿着它有种温暖的感觉。"));
		informationLibraries.add(new Information(841, "寒冰水晶", "寒冰的气息被封存在这个水晶中，它散发出的气势可以扑灭接近它的火焰。"));
		informationLibraries.add(new Information(842, "通灵之晶", "古灵的灵魂被封存在这个水晶中，夜晚会发出幽幽的光，聚集在一起似乎还能听到灵魂的律动。"));
		informationLibraries.add(new Information(843, "虚无幻灭", "这颗水晶里似乎什么都没有，存在的极端也许就是虚无吧。"));
		informationLibraries.add(new Information(911, "911", "911"));
		informationLibraries.add(new Information(912, "912", "912"));
		informationLibraries.add(new Information(913, "913", "913"));
		informationLibraries.add(new Information(933, "933", "933"));
		informationLibraries.add(new Information(914, "914", "914"));
		informationLibraries.add(new Information(923, "923", "923"));
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
