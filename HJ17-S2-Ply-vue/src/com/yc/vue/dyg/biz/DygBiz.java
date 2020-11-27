package com.yc.vue.dyg.biz;

import java.sql.SQLException;

import com.yc.vue.dyg.bean.DygMsg;
import com.yc.vue.dyg.dao.DygDao;

public class DygBiz {
	
	private DygDao dao = new DygDao();
	
	public void addMsg(DygMsg msg) throws BizException {
		
		if(msg.getCreateName()==null || msg.getCreateName().isEmpty()) {
			throw new BizException("�����˵�����δ��д��");
		}
		if(msg.getEmail()==null || msg.getEmail().isEmpty()) {
			throw new BizException("�����˵������ַδ��д��");
		}
		if(msg.getContent()==null || msg.getContent().isEmpty()) {
			throw new BizException("���Ե�����δ��д��");
		}
		
		try {
			dao.insertMsg(msg);
		} catch (SQLException e) {
			throw new BizException("ҵ��æ�����Ժ����ԣ�", e);
		}
	}

}
