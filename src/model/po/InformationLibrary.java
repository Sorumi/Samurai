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
		informationLibraries.add(new Information(12, "狩猎石矛", "丛林地区人们用来狩猎的石矛，锋利程度，一击刺穿动物心脏、鲜血四泵。"));
		informationLibraries.add(new Information(13, "寒铁战戟", "用雪山矿底深坑的铸铁打造的战戟，受冻土的士兵所追捧。\n“喔，它实在太好用了！你甚至可以把猎物挂在柄上背回去。”\n                               ——闲着狩猎雪豹的士兵。"));
		informationLibraries.add(new Information(23, "勇士长矛", "正规军所用的反骑兵长矛，只有骁勇善战被誉为“勇士”的士兵才能使用它。"));
		informationLibraries.add(new Information(33, "森中豹","短小精悍的武器，常常被用于偷袭作战之中，其灵活性犹如丛林中的花斑猎豹，爆发性和迅捷力完全可以弥补其长度上的劣势。"));
		informationLibraries.add(new Information(14, "花缨枪", "头部坠花的长枪，往往被将领们使用，红如赤血的花簇象征着胜利之花，无数志士挥舞生命、换取国家的胜利，将自己的生命烙印在枪锋之间。"));
		informationLibraries.add(new Information(34, "穿心之矛", "曾经一名士兵的长矛战时折断，而勇士握其前端浴血再战，神勇无敌，启发工匠研制出这种短矛。负责白刃战的特种部队所青睐的武器，凭其锋利枪尖一举刺穿敌人的心脏，是遭遇战的首选武器。"));
		informationLibraries.add(new Information(15, "颤栗", "战乱不休的古时留下了许多怨魂，夜夜徘徊在冰原之上，甚至对所遇到的生物进行残忍的咒杀，一时冰原住民民不聊生。一个本是月圆的乌云密布之日，古老种族的战士披着破旧的亚麻披风，堂皇出现在月下，成千上万的怨魂铺天盖地的涌去，战士一声怒吼，将颤栗向地上狂野一掷，无形的凌厉声波瞬间撕碎空中的黑影巨幕，徒留满月下神枪周身细微的空间破碎和渐渐远去的神秘背影。"));
		informationLibraries.add(new Information(25, "龙啸", "质朴的全村村民却被入侵者血腥的屠戮，仅剩少年一人幸存。愤恨狂怒一度吞噬着他的理智——复仇，他的余生只剩下复仇。他想要变强。偶遇仙风道骨的老者，他一眼就识出老者的强大。老者像父亲一样教导他战斗的方法，授予他年轻时所用的锋利长枪。与老者共度的日子让少年飞速成长。少年从内心深处尊敬着老人。十年一剑，少年下定决心将要踏上复仇之旅之时，老者却吩咐他：“抛弃内心的仇恨吧。”少年难以理解，师傅应该早已知晓他的苦衷才是，第一次涨红着脸大声辩驳，话音未落，老者腾云而起显露真身，一声龙啸震慑群山。恐惧、和内心中更深处的向往，少年的时间仿佛停滞了。待他缓过神来时神龙已然不见，明白师傅内心的他手拄长枪往远处重重地行了一礼。多年后的少年已是手持神枪的盖世强者，他投身于保护整片大陆的战斗。他明白，若不是那声龙啸将他从复仇的枷锁中解放出来，他永远无法和师傅一样强大。"));
		informationLibraries.add(new Information(35, "狂热", "“第一眼在战场上见到他的时候，我仿佛见到了战争机器。”“平时的他总是傻笑，憨厚的摸摸自己脑袋。而跨上战场的时候……”“我和他一起排队买包子的时候根本就不知道他是我们国家的大将军！”“他的眼中甚至发着红光，面容甚至有些狰狞。”“那……真是无与伦比的强大。”对战场传奇感兴趣的游学家慕名而来却听到这些奇异的评价。直到他直面那个魁梧的汉子时他才明白。“没什么！只是我和我的武器狂热得喜爱战场而已呀！”吓倒在地上的游学家仿佛在一瞬间透过笑脸相迎的将士看到了他身后透露强大气场的鬼神形象。  “他也许就是战神。”\n                               ——游学家最后只能在纸上留下这几个字。"));
		informationLibraries.add(new Information(16, "浩劫", "见证过古神之间的战争的幸存者已经不复存在，而古书文记录着那可怕场景——“随着最后一名泰坦巨人倒下，黑暗古神骇人的三叉长戟，划破长空，贯穿巨洋，震慑大地。下一个瞬间，什么都看不见了，什么都听不见了，千年的黑暗浩劫来临了。”"));
		informationLibraries.add(new Information(26, "破晓", "黑暗浩劫之中，生灵失去了光与火，唯有心灵之力的微弱光芒支撑着每个族群活下去。无数的勇者挑战黑暗，却被侵蚀最后湮灭于腐蚀性的黑中。失去了力量的翼神龙——拉、将最后的光芒寄存于一柄温热常亮的长枪之中后逝去。为了躲避黑暗的侵蚀，勇者将含着最后胜利曙光的长枪费尽心思送往当时唯一能够拯救世界的幸存神明手中——天空之神乌拉诺斯，也就是我。在战争中失去了父亲失去了双眼的我曾在黑暗的世界中得过且过，‘反正世界也是一片黑暗，复仇又有何用？’直到世界最后的勇者将神枪交到手中之后，我才清醒，耗尽生命的勇者说道：‘世界不应该是这样的’。逝去的灵魂受神枪的召唤，附上天空的纯净力量，刺穿黑暗，一枪破晓。接下来的战斗，便是化身巨鹰的我的复仇了。”\n                            ——万神之主乌拉诺斯碑刻"));
		informationLibraries.add(new Information(36, "月耀", "这把武器原本是月亮女神的发簪。黑暗古神无法企及月亮，也无法表达对女神的爱恋，独自郁郁寡欢，他的手下混沌魔为了夺权夺势，一直危言耸听，常驻黑暗的古神本不会轻易的受到蛊惑，然而对月光的期盼却让他乱了心智。他的急切最终让他酿成了惨剧，他以为听信混沌魔，暂时的停滞光明削弱太阳神翼神龙就能够与月神见上一面，而他的武器被混沌魔偷偷动了手脚，无法逆转地重创了太阳神，失去了太阳神力量的月神，在仅仅数分钟后就烟消云散。痛苦，愤恨，黑暗古神愤怒的一击强大到毁灭了世界的光明。杀死了癫笑着的混沌后，暴走的黑暗古神永远的失去了神格，化为被腐蚀的魔神，一边疯狂地试图毁灭这个世界，一边痛苦地用混乱的身躯包裹着月亮女神的发簪，即使发簪的光芒无时不刻对他的本体造成巨大的伤害。他在痛苦中，寻求月光下的一丝静谧，可悲。"));
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
		informationLibraries.add(new Information(701, "低级治疗药剂", "使用民间草药调配出的药剂，可以恢复30点生命值。"));
		informationLibraries.add(new Information(702, "标准治疗药剂", "在战争中批量生产的药水，可以恢复80点生命值。"));
		informationLibraries.add(new Information(703, "高级治疗药剂", "屠龙部队使用的高效恢复药剂，可以恢复150点生命值。"));
		informationLibraries.add(new Information(711, "低级体力药水", "运动员使用的增能药水，可以恢复4点行动点。"));
		informationLibraries.add(new Information(712, "标准体力药水", "勇士们冲锋前使用的药水，可以恢复8点行动点。"));
		informationLibraries.add(new Information(713, "高级体力药水", "特种部队使用的兴奋性药物，可以恢复15点行动点。"));
		informationLibraries.add(new Information(721, "淬刃印记", "可以磨砺武器的印记，在该回合内攻击力增加30点。"));
		informationLibraries.add(new Information(722, "充能印记", "可以给武器充能的印记，在该回合内攻击力增加70点。"));
		informationLibraries.add(new Information(723, "龙火印记", "可以将巨龙火焰的力量暂时传递给武器，在该回合内攻击力增加120点。"));
		informationLibraries.add(new Information(731, "幸运符号", "民间流传的幸运符号，在该回合内暴击率提高10%。"));
		informationLibraries.add(new Information(732, "光之符号", "蕴藏着光辉的符号，在该回合内暴击率提高25%。"));
		informationLibraries.add(new Information(733, "圣歌符号", "仔细聆听可以听到神灵的音乐的符号，在该回合内暴击率提高40%。"));
		informationLibraries.add(new Information(741, "小起小落", "“听过六合彩么？没错，就是它，测试你运气的时候到了哦~”\n                           ——街边小贩"));
		informationLibraries.add(new Information(751, "大起大落", "“人生不如意之事，十有八九，要么一夜暴富，要么就祭出灵魂！”\n                           ——空灵之音"));
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
		informationLibraries.add(new Information(843, "虚无幻灭", "这颗水晶里似乎什么都没有，不，他就是什么都没有，存在的极端也许就是虚无吧。(这个材料不能用于合成任何武器，仅用于收集)"));
		informationLibraries.add(new Information(911, "平民服","冬暖夏凉，老少皆宜，深受广大平民喜爱的服装。不过除了挡风好像没有什么防御力的样子。"));
		informationLibraries.add(new Information(912, "武夫简装","武士中流行的服装，轻便、坚韧、最重要的是有型。"));
		informationLibraries.add(new Information(923, "猎人皮衣","猎人狩猎时穿着的皮衣，不仅能够抵抗森林中的湿气，也能抵御雪山上的寒冷。"));
		informationLibraries.add(new Information(913, "精灵披风","擅长使用弓箭射击的精灵族所穿的布甲披风，隐蔽性强，便于与大自然融为一体"));
		informationLibraries.add(new Information(914, "仙隐道袍","浅蓝色的道袍，附有古代仙灵的祝语，浩瀚山巅之灵融于一体，增强装备者的速度与敏捷。"));
		informationLibraries.add(new Information(924, "巨犀韧甲","击杀荒漠巨犀后用极度锋利的利刃剥取最坚硬且最具有韧性部分的皮革所制作的皮甲，装备者将获得与巨犀相似的压迫力和耐力。"));
		informationLibraries.add(new Information(934, "骑士胸甲","装备精良的骑士所配备的制式盔甲，抛弃敏捷而专注于防御力，普通的武器根本无法轻易穿透。"));
		informationLibraries.add(new Information(915, "炎魔披肩","远古火山炎魔王所穿戴的披肩，对友善阵营的人仅仅只是柔和的温暖，却能对敌方产生极度危险的致命高温，其高温甚至能够扭曲空间致使敌方难以捕获装备者的方位，从而轻松闪避化解攻击"));
		informationLibraries.add(new Information(925, "噬骨反甲","从魔窟中讨伐魔兽后的骨、皮、血等素材铸成的坚固甲胄，能够赐予使用者巨大的力量，同时也会被巨大的愤怒和怨恨所影响。倘若心智不坚，终将自取灭亡，被普通武士所忌惮的受诅咒的护甲。"));
		informationLibraries.add(new Information(935, "龙鳞护心","龙骑士教团在经历三个月的鏖战中终于砍下了赤炎龙的头颅，高挂于王都城墙之上。损失惨重的骑士团，将从龙蛋开始就培养的战死的坐骑埋于龙骨墓地。下葬之前剥下龙心前保护生命之源的鳞片，将这些鳞片收集并且与赤炎龙鳞共同炼制了这件重甲。龙鳞蕴含的生命力量能够减免任何伤害。"));
		informationLibraries.add(new Information(916, "虚空星纱","采虚空之星辰，凝银河之魂魄而织成的薄纱。看似轻薄实则蕴含巨大能量。能够扭曲时间，致使原本可以命中的攻击被化解仿佛不曾命中。"));
		informationLibraries.add(new Information(926, "沉沙折戟","从本源中散发出古朴厚重气息的甲胄，仿佛叹息着战场厮杀无奈，每一寸都散发着无法侵犯的古老气息。折戟沉沙铁未销，自将磨洗认前朝。战争的物是人非，常人终将湮灭在铁蹄剑鸣之中，唯有此甲，代表着战争其本身，将永远存留下去，无法破坏。"));
		informationLibraries.add(new Information(936, "泰坦之魂","远古泰坦族守护世界亿年之后逝去将会残留一份精魄，其守护之力足以匹配世界级的能量，龙人族的第一匠人，用尽毕生心血锻造高达千米的巨盔和甲胄，再由精灵族的数十位长老施加将其浓缩至常人能够穿戴的尺寸，最后在所有种族领袖的见证下将其封印在世界山巅的最高处。倘若世界遇到巨大的危机，将由有判断力的万族族长选出最适合这件神装的拯救者，颁布于他泰坦一族的使命——守护世界。"));

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
