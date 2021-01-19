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
		'foot',
		{
			template : ` <div class="bottom">
			<div class="center_980">
				<div class="bottom_left">
					<ul>
						<li><a href="site/about">关于我们</a></li>
						<li><a href="site/joinus">申请合作</a></li>
						<li><a href="site/privacy">隐私政策</a></li>
						<li><a href="site/term">服务条款</a></li>
						<li><a href="site/help">帮助</a></li>
						<li><a href="site/link">友情链接</a></li>
					</ul>
				</div>
				<div id="copyright">
					© 2020 by 旧书街 <a href="http://beian.miit.gov.cn/">蜀ICP备16007902号-2</a>
				</div>
			</div>
		</div>
		<h1 class="jiushujie_slogan">买卖二手书，就上旧书街。旧书街二手书交易网-您身边的旧书网站</h1>`
		}


)