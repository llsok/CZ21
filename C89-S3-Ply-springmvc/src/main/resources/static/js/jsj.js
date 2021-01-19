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