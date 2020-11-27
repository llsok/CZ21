package com.yc.vue.dyg.biz;

import java.sql.SQLException;

import com.yc.vue.dyg.bean.DygMsg;
import com.yc.vue.dyg.dao.DygDao;

public class DygBiz {
	
	private DygDao dao = new DygDao();
	
	public void addMsg(DygMsg msg) throws BizException {
		
		if(msg.getCreateName()==null || msg.getCreateName().isEmpty()) {
			throw new BizException("留言人的名字未填写！");
		}
		if(msg.getEmail()==null || msg.getEmail().isEmpty()) {
			throw new BizException("留言人的邮箱地址未填写！");
		}
		if(msg.getContent()==null || msg.getContent().isEmpty()) {
			throw new BizException("留言的内容未填写！");
		}
		
		try {
			dao.insertMsg(msg);
		} catch (SQLException e) {
			throw new BizException("业务繁忙，请稍后再试！", e);
		}
	}

}
