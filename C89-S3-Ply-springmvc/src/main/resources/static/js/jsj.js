// 注册Vue自定义组件： 组件名大小写不敏感，不能使用驼峰命名法
// `` （反引号）可以定义大段的包含换行的字符串
Vue.component(
	'luc',
	{
		data : function(){
			return { list : [] };
		},
		created(){
			axios.get("NewReg.do").then(res=>{
				this.list=res.data;
			})
		},
		template : `<div class="side_block" id="E05">
						<div class="title">新注册用户</div>
						<div class="separate"></div>
						<div class="side_user_list">
							<ul>
								<li v-for="n in list">
								<a target="_blank" href="user-.html">
								<img :src="n.headImg" :title="n.school">
								</a>
								</li>							
							</ul>
						</div>
						<div class="clearfloat"></div>
					</div>`
	}
)

Vue.component(
	'hotperson',
	{
		template : `<div class="side_block">
					<div class="title">热门个人</div>
					<div class="separate"></div>
					<div class="hot_seller">
						<ul>
							<li><a href="user/26332672/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26332672_dsjyhphalu0w1kui.jpg!tiny" alt="呼LL"
									title="呼LL"></a><a
								href="user/26332672/sell.html"
								target="_blank">呼LL&nbsp;&nbsp;(98)</a></li>
							<li><a href="user/26257747/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="孔文明" title="孔文明"></a><a
								href="user/26257747/sell.html"
								target="_blank">孔文明&nbsp;&nbsp;(98)</a></li>
							<li><a href="user/21551094/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/21551094_fmmmmatn23vqyd98.jpg!tiny" alt="kongquegege"
									title="kongquegege"></a><a
								href="user/21551094/sell.html"
								target="_blank">kongquegege&nbsp;&nbsp;(97)</a></li>
							<li><a href="user/26455368/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="奇琪轩" title="奇琪轩"></a><a
								href="user/26455368/sell.html"
								target="_blank">奇琪轩&nbsp;&nbsp;(96)</a></li>
							<li><a href="user/19022825/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/82717568_btrd8ju0x1303bnx.jpg!tiny" alt="二宮漣"
									title="二宮漣"></a><a
								href="user/19022825/sell.html"
								target="_blank">二宮漣&nbsp;&nbsp;(96)</a></li>
							<li><a href="user/22511421/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/22511421_quy1jxfo9o18f04v.jpg!tiny" alt="sippen"
									title="sippen"></a><a
								href="user/22511421/sell.html"
								target="_blank">sippen&nbsp;&nbsp;(95)</a></li>
							<li><a href="user/26249879/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="jnsht0535" title="jnsht0535"></a><a
								href="user/26249879/sell.html"
								target="_blank">jnsht0535&nbsp;&nbsp;(93)</a></li>
							<li><a href="user/25660862/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/64265162_alksikhxuv354n87.jpg!tiny" alt="冷月孤心"
									title="冷月孤心"></a><a
								href="user/25660862/sell.html"
								target="_blank">冷月孤心&nbsp;&nbsp;(92)</a></li>
							<li><a href="user/21151884/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/21151884_jjgxvn74bc8hdtcp.jpg!tiny" alt="我的书库"
									title="我的书库"></a><a
								href="user/21151884/sell.html"
								target="_blank">我的书库&nbsp;&nbsp;(92)</a></li>
							<li><a href="user/19142673/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/71610350_7ih19wkjvm9k6jqh.jpg!tiny" alt="吟风为歌"
									title="吟风为歌"></a><a
								href="user/19142673/sell.html"
								target="_blank">吟风为歌&nbsp;&nbsp;(92)</a></li>
						</ul>
					</div>
				</div>`
	}
)
Vue.component(
	'ltusers',
	{
		data : function(){
			return { users : [] };
		},
		created(){
			axios.get("getlastTimeUsers.do").then(res=>{
				this.users = res.data;
			});
		},
		template : `<div class="side_block" id="lastLoginedUsers">
						<div class="title">最近登录用户</div>
						<div class="separate"></div>
						<div class="side_user_list">
							<ul v-for="u in users">
								<li><a target="_blank"
									:href="'user/' + u.id"><img
										:src="u.headImg"
										:title="u.account+' ♀ '+u.school"></a></li>
							</ul>
						</div>
						<div class="clearfloat"></div>
					</div>`

	}
)

Vue.component(
	'cate',
	{
		data : function(){
			return { calist : {} };
		},
		created(){
			axios.get("selectAllCate.do").then(res=>{
				this.calist=res.data;
			})
		},
		template : `<div class="side_block">
					<div class="title">书籍分类</div>
					<div class="separate"></div>
					<div id="booktype_sidebar_div">
						<a v-for="c in calist" :href="'category.html?'+c.id" category_key="1000">{{c.name}}</a> 
					</div>
				</div>`
	}
)
Vue.component(
		"yetou",
		{
			data : function(){
				return { 
					lu : {}
				};
			},
			created(){
				axios.get("getLoginedUser.do").then(res=>{
					this.lu = res.data.data;
				})
			},
			template : `<div class="site_top_row">
							<div class="center_980">
								<div class="school_location" style="float: left;">
									[<a href="javascript:void(0)"
										onclick="showSchoolList();return false;">所有学校</a>]
								</div>
								<div id="top_user_info" style="float: right;">
									<a v-if="lu.account" href="user-01set.html">{{lu.account}}</a>
									<a v-else href="login.html">登录</a>
									|
									<a href="sell.html/create">出售</a>|
									<a style="color: rgb(254, 137, 0);" href="register.html">立即注册</a>|
									<a class="app_mobile" target="_blank" href="site/app">下载APP</a>
								</div>
								<div class="clearfloat"></div>
							</div>
						</div>`
		}
	)
	Vue.component(
	'hbs',
	{
		template : `<div class="side_block">
					<div class="title">热门书店</div>
					<div class="separate"></div>
					<div class="hot_seller">
						<ul>
							<li><a href="user/26398619/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26398619_u8qh0icocnbarbes.jpg!tiny" alt="启航ing"
									title="启航ing"></a><a
								href="user/26398619/sell.html"
								target="_blank">启航ing&nbsp;&nbsp;(409738)</a></li>
							<li><a href="user/26226787/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/93860536_pvmk0snsd9fxqkmu.jpg!tiny" alt="一方书店"
									title="一方书店"></a><a
								href="user/26226787/sell.html"
								target="_blank">一方书店&nbsp;&nbsp;(102913)</a></li>
							<li><a href="user/26256434/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26256434_stxmrnzp8s19jyun.jpg!tiny" alt="zxsd69"
									title="zxsd69"></a><a
								href="user/26256434/sell.html"
								target="_blank">zxsd69&nbsp;&nbsp;(94131)</a></li>
							<li><a href="user/26323795/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26323795_9cqz7krwnhdcbyj5.jpg!tiny" alt="友佳特价书店"
									title="友佳特价书店"></a><a
								href="user/26323795/sell.html"
								target="_blank">友佳特价书店&nbsp;&nbsp;(93289)</a></li>
							<li><a href="user/16982378/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/8692929230_1504180972.jpg!tiny" alt="上游" title="上游"></a><a
								href="user/16982378/sell.html"
								target="_blank">上游&nbsp;&nbsp;(90381)</a></li>
							<li><a href="user/26438497/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/1803262834_1606718236.jpg!tiny" alt="honestyisgold"
									title="honestyisgold"></a><a
								href="user/26438497/sell.html"
								target="_blank">honestyisgold&nbsp;&nbsp;(46459)</a></li>
							<li><a href="user/26257385/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26257385_dzjjvwws5m6omira.jpg!tiny" alt="三未书屋"
									title="三未书屋"></a><a
								href="user/26257385/sell.html"
								target="_blank">三未书屋&nbsp;&nbsp;(35416)</a></li>
							<li><a href="user/24099523/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/24099523_pn70je326thqjkic.jpg!tiny" alt="倾城小小"
									title="倾城小小"></a><a
								href="user/24099523/sell.html"
								target="_blank">倾城小小&nbsp;&nbsp;(23582)</a></li>
							<li><a href="user/25158186/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/25158186_dzg5rxx0nj36dwel.jpg!tiny" alt="激素脸啊"
									title="激素脸啊"></a><a
								href="user/25158186/sell.html"
								target="_blank">激素脸啊&nbsp;&nbsp;(13373)</a></li>
							<li><a href="user/26154282/sell.html"
								target="_blank"><img class="user_pic_tiny"
									src="res/26154282_0epqtcprt6t3c2mo.jpg!tiny" alt="拼搏精灵"
									title="拼搏精灵"></a><a
								href="user/26154282/sell.html"
								target="_blank">拼搏精灵&nbsp;&nbsp;(12558)</a></li>
						</ul>
					</div>
				</div>`
	}
)


Vue.component(
	'mul',
	{
		template : 
			`<div class="side_block">
					<div class="title">最多人关注</div>
					<div class="separate"></div>
					<div class="side_user_list">
						<ul>
							<li><a target="_blank"
								href="user/540305"><img
									src="res/540305_n1dab5l6dee972hc.jpg!middle"
									title="旧书街客服 ♂ 北京交通大学"></a></li>
							<li><a target="_blank"
								href="user/543702"><img
									src="res/4801464973_1447948297.jpg!middle"
									title="daihanla ♀ 北京邮电大学"></a></li>
							<li><a target="_blank"
								href="user/1730678"><img
									src="res/4949898217_1395410353.jpg!middle"
									title="旧书街官方活动 ♂ 北京邮电大学"></a></li>
							<li><a target="_blank"
								href="user/4822592"><img
									src="res/4822592_v0g8zc4s448n2zp6.jpg!middle"
									title="eddison ♂ 北京大学"></a></li>
							<li><a target="_blank"
								href="user/11494418"><img
									src="res/1390796519_1467885194.jpg!middle"
									title="布科书屋 ♂ 山东传媒职业学院"></a></li>
							<li><a target="_blank"
								href="user/11525234"><img
									src="res/5139204071_1479230482.jpg!middle" title="艾念333 ♂ 河北大学"></a></li>
							<li><a target="_blank"
								href="user/15624945"><img
									src="res/9819130012_1468891330.jpg!middle"
									title="小豆腐啊 ♀ 山东师范大学"></a></li>
							<li><a target="_blank"
								href="user/15768037"><img
									src="res/8701011384_1489841601.jpg!middle"
									title="醉三年 ♂ 河北交通职业技术学院"></a></li>
							<li><a target="_blank"
								href="user/15853618"><img
									src="res/8767971901_1470919411.jpg!middle" title="怪盗 ♀ 清华大学"></a></li>
							<li><a target="_blank"
								href="user/16034138"><img
									src="res/16034138_qgmqrf65vicok57v.jpg!middle"
									title="梵歌旧书帮 ♂ 莆田学院"></a></li>
							<li><a target="_blank"
								href="user/16605959"><img
									src="res/0091191133_1479986351.jpg!middle"
									title="西施书屋 ♀ 宁波工程学院"></a></li>
							<li><a target="_blank"
								href="user/16638354"><img
									src="res/7468920359_1480572497.jpg!middle"
									title="蒲公英TM ♂ 河北师范大学"></a></li>
							<li><a target="_blank"
								href="user/16745713"><img
									src="res/4357262108_1493876789.jpg!middle" title="翠研 ♀ 重庆大学"></a></li>
							<li><a target="_blank"
								href="user/16982378"><img
									src="res/8692929230_1504180972.jpg!middle"
									title="上游 ♂ 哈尔滨工程技术职业学院"></a></li>
							<li><a target="_blank"
								href="user/17297648"><img
									src="res/8446001075_1491383097.jpg!middle"
									title="冰儿790315 ♀ 东北财经大学"></a></li>
							<li><a target="_blank"
								href="user/17898422"><img
									src="res/17898422_dxj4hgmaygvu5esd.jpg!middle"
									title="琅嬛 ♂ 枣庄学院"></a></li>
							<li><a target="_blank"
								href="user/17931502"><img
									src="res/2303436157_1500259991.jpg!middle"
									title="吉光片羽 ♂ 河南财经政法大学"></a></li>
							<li><a target="_blank"
								href="user/18631084"><img
									src="res/18631084_8las37adrgyvwys7.jpg!middle"
									title="争取5元10元出 ♂ 对外经济贸易大学"></a></li>
							<li><a target="_blank"
								href="user/19167800"><img
									src="res/6630286866_1541560291.jpg!middle"
									title="卖图书的女汉纸 ♂ 南京大学"></a></li>
							<li><a target="_blank"
								href="user/19175418"><img
									src="res/19175418_qak54pv61lqmxrkn.jpg!middle"
									title="心灵书屋 ♀ 上海外国语大学"></a></li>
							<li><a target="_blank"
								href="user/22333097"><img
									src="res/22333097_6eygylayxuykgex4.jpg!middle"
									title="sky78 ♂ 北京大学"></a></li>
							<li><a target="_blank"
								href="user/22466149"><img
									src="res/3987045210_1544458241.jpg!middle" title="四眼猫 ♂ 成都学院"></a></li>
							<li><a target="_blank"
								href="user/22476232"><img
									src="res/22476232_nn68l1csye5f9nwd.jpg!middle"
									title="清水精品书屋 ♂ 延边大学"></a></li>
							<li><a target="_blank"
								href="user/22486582"><img
									src="res/94822324_gul21wtmdp3phxag.jpg!middle"
									title="王二丫 ♀ 宁夏医科大学"></a></li>
						</ul>
					</div>
					<div class="clearfloat"></div>
				</div>
			`
	}
)






