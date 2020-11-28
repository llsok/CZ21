package com.yc.vue.d1128.biz;

import java.sql.SQLException;

import com.yc.vue.d1128.bean.User;
import com.yc.vue.d1128.dao.UserDao;
import com.yc.vue.d1128.util.Utils;
import com.yc.vue.dyg.biz.BizException;

public class UserBiz {

	private UserDao dao = new UserDao();

	public void register(User user) throws BizException {
		// �ֶ���֤
		Utils.checkNull(user.getPhone(), "�绰���벻��Ϊ��");
		Utils.checkNull(user.getEmail(), "���䲻��Ϊ��");
		Utils.checkNull(user.getName(), "�ǳƲ���Ϊ��");
		// ͬ����֤
		User dbuser = dao.selectByName(user.getName());
		if (dbuser != null) {
			throw new BizException("���û����Ѿ���ע�ᣡ");
		}
		// д�����ݿ�
		try {
			dao.insert(user);
		} catch (SQLException e) {
			throw new BizException("ע��ʧ�ܣ�����ϵ����Ա��", e);
		}
	}

}
