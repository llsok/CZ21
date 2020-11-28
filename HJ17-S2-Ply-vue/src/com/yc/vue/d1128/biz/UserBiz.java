package com.yc.vue.d1128.biz;

import java.sql.SQLException;

import com.yc.vue.d1128.bean.User;
import com.yc.vue.d1128.dao.UserDao;
import com.yc.vue.d1128.util.Utils;
import com.yc.vue.dyg.biz.BizException;

public class UserBiz {

	private UserDao dao = new UserDao();

	public void register(User user) throws BizException {
		// 字段验证
		Utils.checkNull(user.getPhone(), "电话号码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getName(), "昵称不能为空");
		// 同名验证
		User dbuser = dao.selectByName(user.getName());
		if (dbuser != null) {
			throw new BizException("该用户名已经被注册！");
		}
		// 写入数据库
		try {
			dao.insert(user);
		} catch (SQLException e) {
			throw new BizException("注册失败，请联系管理员！", e);
		}
	}

}
