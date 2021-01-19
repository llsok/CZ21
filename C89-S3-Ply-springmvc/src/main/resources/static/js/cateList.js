// 注册Vue自定义组件： 组件名大小写不敏感，不能使用驼峰命名法
// `` （反引号）可以定义大段的包含换行的字符串
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