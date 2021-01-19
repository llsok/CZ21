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
							<li><a href="user/26332672/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26332672_dsjyhphalu0w1kui.jpg!tiny" alt="呼LL"
									title="呼LL"></a><a
								href="user/26332672/sell"
								target="_blank">呼LL&nbsp;&nbsp;(98)</a></li>
							<li><a href="user/26257747/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="孔文明" title="孔文明"></a><a
								href="user/26257747/sell"
								target="_blank">孔文明&nbsp;&nbsp;(98)</a></li>
							<li><a href="user/21551094/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/21551094_fmmmmatn23vqyd98.jpg!tiny" alt="kongquegege"
									title="kongquegege"></a><a
								href="user/21551094/sell"
								target="_blank">kongquegege&nbsp;&nbsp;(97)</a></li>
							<li><a href="user/26455368/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="奇琪轩" title="奇琪轩"></a><a
								href="user/26455368/sell"
								target="_blank">奇琪轩&nbsp;&nbsp;(96)</a></li>
							<li><a href="user/19022825/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/82717568_btrd8ju0x1303bnx.jpg!tiny" alt="二宮漣"
									title="二宮漣"></a><a
								href="user/19022825/sell"
								target="_blank">二宮漣&nbsp;&nbsp;(96)</a></li>
							<li><a href="user/22511421/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/22511421_quy1jxfo9o18f04v.jpg!tiny" alt="sippen"
									title="sippen"></a><a
								href="user/22511421/sell"
								target="_blank">sippen&nbsp;&nbsp;(95)</a></li>
							<li><a href="user/26249879/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/default.jpg!tiny" alt="jnsht0535" title="jnsht0535"></a><a
								href="user/26249879/sell"
								target="_blank">jnsht0535&nbsp;&nbsp;(93)</a></li>
							<li><a href="user/25660862/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/64265162_alksikhxuv354n87.jpg!tiny" alt="冷月孤心"
									title="冷月孤心"></a><a
								href="user/25660862/sell"
								target="_blank">冷月孤心&nbsp;&nbsp;(92)</a></li>
							<li><a href="user/21151884/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/21151884_jjgxvn74bc8hdtcp.jpg!tiny" alt="我的书库"
									title="我的书库"></a><a
								href="user/21151884/sell"
								target="_blank">我的书库&nbsp;&nbsp;(92)</a></li>
							<li><a href="user/19142673/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/71610350_7ih19wkjvm9k6jqh.jpg!tiny" alt="吟风为歌"
									title="吟风为歌"></a><a
								href="user/19142673/sell"
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