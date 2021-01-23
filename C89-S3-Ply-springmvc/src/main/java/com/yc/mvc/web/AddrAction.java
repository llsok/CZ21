package com.yc.mvc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.mvc.dao.AddrMapper;
import com.yc.mvc.po.JsjAddr;
import com.yc.mvc.po.JsjUser;
import com.yc.mvc.web.po.Result;

@RestController
public class AddrAction {

	@Resource
	private AddrMapper am;
	
	/**
	 * 根据id查询收货地址
	 */
	@GetMapping("getAddrById.do")
	public JsjAddr getAddrById(int id) {
		return am.getAddrById(id);
	}
	
	@GetMapping("changeCode.do")
	public Result changeCode(int id) {
		am.changeCode(id);
		return Result.success("修改成功", null);
	}
	
	/**
	 * 添加收货地址
	 */
	@PostMapping("insertAddr.do")
	public Result insertAddr(@Valid JsjAddr addr, Errors errors,@SessionAttribute JsjUser loginedUser) {
		if (errors.hasFieldErrors("addrName") || errors.hasFieldErrors("addrPhone")
				|| errors.hasFieldErrors("addrPost")) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}

		try {
			addr.setUid(loginedUser.getId());
			if(addr.getCode()==1) {
				am.updateAllCode();
			}
			am.insertAddr(addr);
			return Result.success(1, "添收货信息成功！", null);
		} catch (Exception e) {
			// e.printStackTrace();
			return Result.failure(0, "字段验证错误！", errors.getAllErrors());
		}
				
	}
	
	/**
	 * 删除收获地址
	 */
	@GetMapping("deleteAddr.do")
	public Result deleteAddr(int id) {
		 am.deleteAddr(id);
		 return Result.success("删除成功", null);
	}
	
	/**
	 * 查询用户的所有收货地址
	 */
	@GetMapping("getaddr.do")
	public List<JsjAddr> getAddr(@SessionAttribute JsjUser loginedUser) {
		return am.getAddr(loginedUser.getId());
	}
	
	@PostMapping("changeAddr.do")
	public Result changeAddr(@Valid JsjAddr addr, Errors errors) {
		if (errors.hasFieldErrors("addrName") || errors.hasFieldErrors("addrPhone")
				|| errors.hasFieldErrors("addrPost")) {
			return Result.failure("字段验证错误！", errors.getAllErrors());
		}

		try {
			if(addr.getCode()==1) {
				am.updateAllCode();
			}
			am.changeAddr(addr);
			return Result.success("修改成功", null);
		} catch (Exception e) {
			// e.printStackTrace();
			return Result.failure(0, "字段验证错误！", errors.getAllErrors());
		}
		
	}
}
