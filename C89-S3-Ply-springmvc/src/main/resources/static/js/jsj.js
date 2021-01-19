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
	'hbs',
	{
		template : `<div class="side_block">
					<div class="title">热门书店</div>
					<div class="separate"></div>
					<div class="hot_seller">
						<ul>
							<li><a href="user/26398619/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26398619_u8qh0icocnbarbes.jpg!tiny" alt="启航ing"
									title="启航ing"></a><a
								href="user/26398619/sell"
								target="_blank">启航ing&nbsp;&nbsp;(409738)</a></li>
							<li><a href="user/26226787/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/93860536_pvmk0snsd9fxqkmu.jpg!tiny" alt="一方书店"
									title="一方书店"></a><a
								href="user/26226787/sell"
								target="_blank">一方书店&nbsp;&nbsp;(102913)</a></li>
							<li><a href="user/26256434/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26256434_stxmrnzp8s19jyun.jpg!tiny" alt="zxsd69"
									title="zxsd69"></a><a
								href="user/26256434/sell"
								target="_blank">zxsd69&nbsp;&nbsp;(94131)</a></li>
							<li><a href="user/26323795/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26323795_9cqz7krwnhdcbyj5.jpg!tiny" alt="友佳特价书店"
									title="友佳特价书店"></a><a
								href="user/26323795/sell"
								target="_blank">友佳特价书店&nbsp;&nbsp;(93289)</a></li>
							<li><a href="user/16982378/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/8692929230_1504180972.jpg!tiny" alt="上游" title="上游"></a><a
								href="user/16982378/sell"
								target="_blank">上游&nbsp;&nbsp;(90381)</a></li>
							<li><a href="user/26438497/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/1803262834_1606718236.jpg!tiny" alt="honestyisgold"
									title="honestyisgold"></a><a
								href="user/26438497/sell"
								target="_blank">honestyisgold&nbsp;&nbsp;(46459)</a></li>
							<li><a href="user/26257385/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26257385_dzjjvwws5m6omira.jpg!tiny" alt="三未书屋"
									title="三未书屋"></a><a
								href="user/26257385/sell"
								target="_blank">三未书屋&nbsp;&nbsp;(35416)</a></li>
							<li><a href="user/24099523/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/24099523_pn70je326thqjkic.jpg!tiny" alt="倾城小小"
									title="倾城小小"></a><a
								href="user/24099523/sell"
								target="_blank">倾城小小&nbsp;&nbsp;(23582)</a></li>
							<li><a href="user/25158186/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/25158186_dzg5rxx0nj36dwel.jpg!tiny" alt="激素脸啊"
									title="激素脸啊"></a><a
								href="user/25158186/sell"
								target="_blank">激素脸啊&nbsp;&nbsp;(13373)</a></li>
							<li><a href="user/26154282/sell"
								target="_blank"><img class="user_pic_tiny"
									src="res/26154282_0epqtcprt6t3c2mo.jpg!tiny" alt="拼搏精灵"
									title="拼搏精灵"></a><a
								href="user/26154282/sell"
								target="_blank">拼搏精灵&nbsp;&nbsp;(12558)</a></li>
						</ul>
					</div>
				</div>`
	}
)