/**
 * @(#)RandomUtils.java 2017年4月13日
 * Copyright(C) 2017年4月13日 ZHEXIN IT CO.,LTD. All rights reserved.
 */
package com.webmeng.simulator.client.util;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO 请加入本类的说明
 * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
 * @version 1.0.0
 */
public class RandomUtils {
	public static final Logger LOGGER = LoggerFactory.getLogger(RandomUtils.class);

	public static final int[] NUMBER=new int[]{0,1,2,3,4,5,6,7,8,9};
	
	public static final char[] CHAT=new char[]{'a','b','c','d','e','f','j','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static final String JIAN_TI="的,一,是,不,了,人,在,我,有,中,这,大,国,上,个,来,他,为,到,地,和,时,们,年,生,会,出,就,子,要,也,以,说,学,得,对,下,那,可,过,于,之,后,着,主,能,里,多,小,而,你,天,家,去,工,十,用,作,分,发,自,成,都,方,民,好,日,还,经,没,同,如,她,么,起,本,行,心,所,然,事,现,三,加,想,面,开,电,种,前,当,美,二,外,道,从,动,看,业,高,者,法,但,其,理,些,实,只,老,长,月,与,两,政,文,部,最,样,意,进,很,机,公,把,又,力,全,点,四,头,已,因,等,问,新,此,名,己,定,正,知,情,无,回,明,间,手,第,产,气,话,重,几,表,由,它,将,化,女,五,代,相,华,平,或,九,水,社,比,内,位,军,车,使,制,度,向,并,活,关,体,总,给,入,什,员,身,见,常,被,西,次,期,各,及,少,打,特,象,口,应,东,太,报,海,台,合,反,万,利,再,果,物,真,立,别,场,山,通,声,信,八,命,提,市,百,件,性,数,书,门,更,题,路,先,每,教,放,六,计,至,做,原,世,展,边,任,解,干,才,资,受,界,亲,许,处,队,义,系,北,请,安,结,论,光,指,今,走,目,流,元,量,便,七,共,接,记,金,难,风,色,何,变,直,区,眼,白,党,联,望,认,革,建,交,带,战,爱,运,收,听,张,治,觉,则,花,思,统,却,务,条,改,南,形,非,济,达,保,必,议,京,程,求,办,远,强,设,候,言,告,完,往,观,科,传,师,感,术,马,该,领,决,吃,写,导,即,品,红,近,基,住,千,广,取,清,且,讲,权,影,儿,节,管,空,叫,英,让,院,识,步,满,组,友,神,算,半,持,转,越,王,研,服,片,级,商,林,语,石,连,争,视,谈,单,深,历,钱,周,字,府,式,司,照,德,据,未,际,青,极,线,离,容,证,拿,史,热,团,早,快,包,音,装,孩,调,农,准,类,约,号,集,克,毛,士,夜,布,较,选,笑,乐,造,整,斯,晚,切,称,格,精,似,失,拉,息,死,怎,料,房,易,曾,始,需,轻,专,委,找,厂,响,夫,校,参,黑,母,火,志,备,育,局,派,示,根,技,亚,况,首,席,价,图,严,买,支,星,李,官,落,众,究,随,病,复,规,兴,黄,族,男,消,苦,费,呢,另,足,查,验,像,批,低,城,举,球,湾,艺,须,尔,欢,除,香,功,确,增,岁,注,客,食,供,具,江,油,群,乎,断,存,底,飞,吗,温,份,仅,仍,愿,般,虽,送,古,段,引,土,续,维,版,案,令,兵,帮,刚,势,律,吧,某,绝,医,紧,划,希,春,显,游,演,苏,击,居,态,倒,站,例,喜,左,否,围,饭,列,血,推,故,习,父,坐,留,河,念,船,久,属,排,护,致,初,跟,职,双,句,朋,妈,村,画,够,巴,助,待,乡,标,省,采,劳,投,右,阳,速,器,压,值,考,读,谁,层,票,纪,角,静,哪,洋,创,章,云,印,停,衣,树,修,港,责,织,简,质,脑,刊,按,尽,破,诉,害,枪,卖,室,斗,汉,波,独,宣,米,甚,刻,微,冲,闻,班,怕,超,项,伤,背,呼,细,止,哥,型,突,答,效,继,依,胜,评,爷,块,沉,终,充,富,竟,获,协,您,若,奇,占,陈,罗,负,阿,错,夏,策,差,歌,痛,板,州,皮,源,吸,汽,密,财,亮,企,笔,营,养,园,脸,换,景,烈,央,座,副,察,顾,境,阶,唱,纸,店,编,跑,余,括,惊,激,田,订,适,假,构,卫,武,雨,木,益,靠,限,判,试,防,坚,永,急,检,诗,味,普,优,货,升,射,叶,沙,福,冷,短,配,搞,杂,款,草,银,酒,旧,曲,素,朝,环,刘,陆,啊,积,录,散,街,铁,免,庭,楼,洲,脚,卡,预,善,均,封,剧,顿,著,堂,渐,雪,承,模,状,乱,担,课,减,威,忘,弟,杀,药,守,怀,互,既,旅,钟,弹,姐,露,贵,介,罪,宝,兰,置,翻,毕,妇,谢,帝,述,登,施,材,穿,寄,玩,略,讨,菜,烟,礼,娘,龙,异,户,抗,攻,犯,访,困,牌,追,松,睡,掉,午,移,招,降,概,慢,宁,祖,良,肉,遍,率,练,尼,幸,丰,付,挥,控,敢,灯,舞,忙,私,顺,坏,险,伯,架,警,县,扬,牛,肯,遇,映,趣,谓,输,执,馆,签,退,熟,缺,爸,绿,股,败,盘,逐,鱼,鲜,临,哭,湖,套,戏,救,屋,婚,灵,础,嘴,顶,浪,零,亿,怪,泪,申,透,恶,阵,胡,拍,误,额,赶,绍,载,丽,征,伟,危,迎,毫,脱,皇,宗,托,杨,彩,弄,摇,疑,抓,轮,欧,篇,航,秋,厚,季,掌,雄,恐,税,窗,弱,睛,赛,归,秘,倍,播,暗,借,末,玉,纳,邓,旁,跳,途,休,唯,巨,审,端,迫,束,码,补,佛,探,岸,麻,鼓,伊,哈,奏,岛,泽,默,汇,亦,伙,虫,尚,荣,圆,范,童,呀,冰,姓,牙,折,鸡,莫,麦,野,懂,词,孙,毒,床,康,烧,筑,藏,茶,释,宽,醒,君,硬,销,狗,索,齐,奖,附,洗,摆,圣,墙,含,寻,召,庆,择,博,纷,耳,镇,丝,献,盖,序,丁,抱,迷,桥,混,楚,盛,喝,潮,圈,抽,督,冬,忍,妻,握,粮,偏,避,晨,忽,挂,训,钢,享,固,庄,稳,奋,遗,煤,替,禁,姑,虑,延,遭,购,欲,骨,暴,穷,纯,监,震,亡,横,刀,尤,敌,谋,测,炮,累,荷,予,逃,吴,悄,扩,桌,损,隐,鲁,赞,谷,健,沿,典,邦,豆,铜,卷,聚,吹,叹,唐,幕,隔,吉,努,诚,恩,淡,坦,悲,针,镜,凡,旗,赏,返,餐,宜,寒,雅,尖,甲,梦,软,孔,阴,愈,尺,闹,梁,巧,奶,妹,促,译,迅,壮,授,烦,偷,勇,惯,稿,缓,刑,纺,贸,触,伸,丈,仁,幅,缩,袖,俗,妙,繁,迹,网,辆,磨,培,徐,粉,夺,矿,乘,灭,喊,挑,售,川,秀,币,劲,欣,倾,赵,贴,讯,徒,杯,奔,刺,爆,盾,珠,闪,操,废,捕,闲,滚,塞,狂,蒙,籍,旋,弃,兄,辉,荡,朱,腿,颇,厅,奥,敬,跃,凭,泥,滑,婆,抵,蛋,闭,宇,矛,残,雷,竞,箱,戴,袋,析,铺,冒,侧,咱,啦,援,库,乃,俄,净,俩,殊,惜,灰,插,彻,仿,虚,舒,拜,舍,蓝,贫,汗,拥,哲,绩,伍,腐,罢,鬼,仪,恨,域,豪,颜,猪,伦,瓶,旦,拖,械,辛,涉,锋,启,呆,尊,智,碗,络,距,疗,碎,尾,租,堆,鞋,泛,凉,染,瑞,贯,琴,珍,胆,毁,胸,摄,违,龄,纽,扎,腰,阻,摸,缘,辩,邮,枝,炸,浓,昏,忆,锅,飘,剩,稍,肥,洞,皆,糊,糖,伴,裁,址,揭,艰,捐,询,丹,悉,津,宪,涌,恰,竹,核,挺,径,措,甘,薄,粒,宾,扫,粗,符,胞,斤,漫,拼,诸,辑,颗,乏,碰,裂,描,梅,湿,昨,匆,灾,焦,植,拒,犹,韩,峰,炼,绪,叔,黎,届,耐,虎,挤,璃,仰,液,暖,障,贝,荒,鼻,汤,阅,棉,酸,骂,壁,剂,塔,宫,侵,恢,萨,晓,坡,洁,纵,冠,估,允,融,祝,肚,蒋,丢,贡,振,详,宿,兼,彼,杰,栏,塑,辈,肃,忠,频,励,邀,哀,抢,孤,驶,拨,怒,森,陪,耀,陷,郭,邻,洛,井,惠,迟,勒,佳,氏,稀,撞,泡,渡,搬,漂,腾,暂,郑,抬,饱,柔,滴,猛,杜,阔,池,浮,寸,伏,澳,饮,吨,慰,幻,幼,递,污,爹,吓,赤,页,寂,祥,纲,肩,驻,晶,聪,苍,垂,巩,喷,偶,宋,屈,姻,摩,磁,筹,润,烂,骑,搭,狱,昌,乌,泰,拔,割,瓜,诞,躲,浅,衡,诺,钻,柴,综,渔,玻,凝,曼,怜,朗,潜,扣,键,储,踏,勤,鸟,截,摘,辞,愤,裤,患,饰,臣,撤,欠,敏,涂,番,赴,罚,陶,洪,涨,爬,帐,鸣,亏,朵,牲,夹,瓦,疾,盐,盟,剑,逢,悟,隆,貌,敲,甜,遵,挣,灌,趋,闷,撒,郎,赖,躺,牵,崇,棋,脉,脏,仔,厉,曰,茫,寿,誉,乔,泉,锁,刷,帽,桂,弯,傲,燃,纠,贷,绕,耗,赢,凶,串,锐,饿,驾,牢,芬,吐,舅,魔,奉,峡,抛,劫,羊,盒,沟,塘,窝,喂,洒,乙,凯,纹,惨,熊,剥,艾,摊,浩,眉,疯,辟,沈,填,饼,擦,逼,扭,埋,轰,劝,咬,墨,尘,唤,胁,鸿,丧,厘,炒,瘦,悠,掩,债,吵,丑,悬,狼,滩,傻,愁,愉,紫,鸭,氛,姆,署,胶,脆,臂,姿,扰,循,醉,谊,盼,碍,册,秒,疲,聊,削,贺,埃,瞧,纱,桃,巡,雾,驱,吊,冻,岗,腔,勃,悔,骗,惧,拾,怨,忧,斜,孟,扶,岭,挡,啥,芳,狠,猫,披,疼,迁,炎,贪,鉴,雇,夸,轨,迪,抑,迈,嘛,凤,衰,慧,抄,炉,胀,胎,魂,偿,辽,哩,梯,袭,症,晃,扑,缝,添,柳,漠,衫,笼,酷,菌,恒,尝,遥,翼,蓄,叙,嫁,朴,呈,夕,莱,浑,仙,厨,弦,绘,膀,盗,挖,尸,扮,冶,椅,畅,枯,燕,稻,娃,览,郊,覆,牺,猜,搜,杆,仓,幽,萧,董,锦,赚,跨,阁,丛,岩,柱,亭,恋,昂,疏,欺,懒,吞,盲,抚,盆,肤,顽,伪,脂,仗,宏,慕,漏,捉,舰,仇,牧,昆,厌,吾,宴,侦,泊,慨,滋,寺,浸,霸,岂,肠,渠,胃,慈,郁,奈,艳,抹,鼠,谱,柜,俱,斥,曹,弥,袁,傅,携,眠,妥,盯,贤,赫,呵,踪,匀,罐,巷,筒,歧,券,劣,档,汪,睁,慌,跌,秦,戚,谨,卧,厦,芽,戒,恼,奴,框,肌,殖,盈,踢,砖,役,溪,雕,卢,逝,蛇,辣,剪,咨,刮,堡,挨,捧,叛,浙,颠,碧,颤,膜,莲,舌,渴,齿,倡,姜,姨,骄,拟,泼,淋,溜,捞,棚,罩,苗,腹,桑,铃,砍,霞,聘,伐,拳,吁,庙,庸,诊,扯,捷,僚,丙,催,践,嫂,疆,凌,坑,祸,撑,羽,廉,晒,歪,扇,棒,辨,宙,儒,屏,遂,蔡,凑,卜,堵,纤,皱,侨,晴,滨,煮,辱,宅,葛,痕";
	public static String[] JIAN_TI_ARR=JIAN_TI.split(",");
	
	public static final String XING="zhuang,zhao,xi,zhan,teng,sha,zhuan,zheng,shao,shan,zhai,ge,dou,xu,bian,kuang,xiang,jiang,she,fu,shi,yang,zhi,wo,yun,he,zha,wu,yue,xuan,yuan,gu,lou,hou,fei,du,rui,liang,chong,cong,huan,di,huai,wen,man,mao,e,tong,quan,wei,luan,shu,zhong,tu,ren,nian,zong,hong,han,hao,hui,cheng,bing,kong,hua,huang,long,bu,tang,bo,gong,su,bi,leng,ruan,dai,fan,si,zuo,zhou,ru,kuai,gou,song,nan,cao,rao,shui,liao,hang,lian,lang,sun,nai,suo,tou,rong,guan,lai,guang,lan,que,qu,peng,men,lao,mei,cai,ba,qi,xin,you,xia,pang,xie,pan,ding,zai,ai,ao,ran,zan,an,yan,yao,pu,qiang,shen,chang,tai,ning,dang,cang,xian,xiao,cui,diao,chun,gui,luo,chen,rang,deng,zhang,weng,ping,geng,dong,ban,ou,bai,kan,heng,gai,meng,zou,gao,pi,tao,gan,tan,bao,sang　,lu,ling,wang,kou,cen,duan,yong,jiao,jian,zhuo,ma,ming,sheng,mi,min,huo,shang,mo,kui,xiong,mu,lei,guo,zhen,na,qin,qiu,kang,ni,pei,chao,tian,shuang,chan,ju,zeng,shou,jin,qiao,ke,qian,nong,jia,chai,bei,chu,xue,miao,ben,li,che,fang,chi,tuo,zang,xun,ying,wan,zi,zhu,hu,feng,yin,zu,xing,bie,ye,nie,lin,jing,liu,yu,niu,ji,yi";
	public static final String[] ZUHE=XING.split(",");
	
	
    public static int getRandomNum(){
    	return (int) (Math.random() * Integer.MAX_VALUE);
    }
    
    
    public static int getRandomNum(int section){
    	return (int) (Math.random() * section);
    }
    
    public static long getRandomLongNum(long section){
    	return (long) (Math.random() * section);
    }
    
    /**
     * 
     * 必须有一个是数字或者一个字母
     * @author <a href="mailto:zhouchao@zhexinit.com" >周超</a>
     * @param section
     * @return
     */
    public static String getRandomCharAndNum(int section){
    	int num=getRandomNum(section-1);
    	if(num==0){
    		num=1;
    	}
    	int charNum=section-num;
    	StringBuffer str=new StringBuffer();
    	
    	int select=getRandomNum(2);
    	if(select==0){
    		str.append(getRandomString(charNum));
    		str.append(getRandomInt(num));
    	}else{
    		str.append(getRandomInt(num));
    		str.append(getRandomString(charNum));
    	}
    	return str.toString();
    }
    
    public static String getRandomString(int section){
    	StringBuffer content=new StringBuffer();
    	for(int i=0;i<section;i++){
    		content.append(CHAT[getRandomNum(CHAT.length)]);
    	}
    	return content.toString();
    }
    
    public static String getRandomInt(int section){
    	StringBuffer content=new StringBuffer();
    	for(int i=0;i<section;i++){
    		content.append(NUMBER[getRandomNum(NUMBER.length)]);
    	}
    	return content.toString();
    }
    
    
    public static String getRandomUUID(){
    	return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static String getRandomNick(int section){
    	StringBuffer content=new StringBuffer();
    	for(int i=0;i<section;i++){
    		content.append(JIAN_TI_ARR[getRandomNum(JIAN_TI_ARR.length)]);
    	}
    	return content.toString();
    }
    
    public static String getRandomNick(){
    	StringBuffer content=new StringBuffer();
    	int section=getRandomNum(5)+2;
    	for(int i=0;i<section;i++){
    		content.append(JIAN_TI_ARR[getRandomNum(JIAN_TI_ARR.length)]);
    	}
    	return content.toString();
    }
    
    public static void main(String[] args){
    	for(int i=0;i<1000;i++){
    		System.out.println(getRandomNick());
    	}
    }

}
