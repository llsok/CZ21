package com.yc.sq.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.sq.bean.SqMember;
import com.yc.sq.bean.SqMemberExample;
import com.yc.sq.dao.SqMemberMapper;

@Service
public class MemberBiz {
	
	@Resource
	private SqMemberMapper sum;
	
	public SqMember login(SqMember sm) throws BizException {
		
		SqMemberExample example = new SqMemberExample();
		// 链式调用， 构建条件
		example.createCriteria()
				.andNameEqualTo(sm.getName())
				.andPwdEqualTo(sm.getPwd());
		List<SqMember> list = sum.selectByExample(example);
		if(list.isEmpty()) {
			throw new BizException("用户名或密码错误！");
		}
		return list.get(0);
	}
	
	@Transactional
    public void register(SqMember sm) throws Exception {
    	SqMemberExample example=new SqMemberExample();
    	example.createCriteria().andNameEqualTo(sm.getName());
    	List<SqMember> list=sum.selectByExample(example);
    	if (list.isEmpty()) {
		    sum.insertSelective(sm);
		}else {
			throw new BizException("该账号已被使用！");
		}
	}

}
