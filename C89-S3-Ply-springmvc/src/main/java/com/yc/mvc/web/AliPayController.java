package com.yc.mvc.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.yc.mvc.AlipayConfig;


@Controller
public class AliPayController{
	
	AlipayConfig a=new AlipayConfig();
	
	//支付宝支付主页
	
	@RequestMapping("/payin")
	public String index(){

		return "index";
	}
	
	@RequestMapping("/pay")
	public String pay(){

		return "alipay.trade.page.pay";
	}
	
	@RequestMapping("notifyurl")
	public String notifyurl(){
		return "notify_url";
	}
	
	@RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
	public String returnUrl(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, AlipayApiException {
	    System.out.println("=================================同步回调=====================================");

	    // 获取支付宝GET过来反馈信息
	    Map<String, String> params = new HashMap<String, String>();
	    Map<String, String[]> requestParams = request.getParameterMap();
	    for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
	        String name = (String) iter.next();
	        String[] values = (String[]) requestParams.get(name);
	        String valueStr = "";
	        for (int i = 0; i < values.length; i++) {
	            valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
	        }
	        // 乱码解决，这段代码在出现乱码时使用
	        valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
	        params.put(name, valueStr);
	    }

	    System.out.println(params);//查看参数都有哪些
	    boolean signVerified = AlipaySignature.rsaCheckV1(params,a.alipay_public_key,a.charset,a.sign_type); // 调用SDK验证签名
	    //验证签名通过
//	    if(signVerified){
//	        // 商户订单号
//	        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//	        
//	        // 支付宝交易号
//	        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//	        
//	        // 付款金额
//	        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//	        
//	        System.out.println("商户订单号="+out_trade_no);
//	        System.out.println("支付宝交易号="+trade_no);
//	        System.out.println("付款金额="+total_amount);
//	        
//	        //支付成功，修复支付状态
//	        payService.updateById(Integer.valueOf(out_trade_no));
	        return "ok";//跳转付款成功页面
//	    }else{
//	        return "no";//跳转付款失败页面
//	    }
	    
	}

	
}
