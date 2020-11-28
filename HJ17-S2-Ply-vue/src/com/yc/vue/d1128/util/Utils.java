package com.yc.vue.d1128.util;

import com.yc.vue.dyg.biz.BizException;

public class Utils {
	
	/**
	 * 	ÅÐ¶Ï´«ÖµÊÇ·ñÎª¿Õ »ò¿Õ×Ö·û´®
	 * @param value
	 * @param msg
	 * @throws BizException
	 */
	public static void checkNull(Object value, String msg) throws BizException {
		if(value == null) {
			throw new BizException(msg);
		}
		if(value instanceof String) {
			String svalue =(String) value;
			if(svalue.trim().isEmpty()) {
				throw new BizException(msg);
			}
		}
	}

}
