package com.yc.mvc;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116684674";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCB24565WpyOx3N/Wt1A2IzgvQl6OgJGnoi9Qs7sXW2q6nap0zzr4eumHV8VM9ucrQ3C0nKjOHcSarCpeP/N/cD9T0zrdrXhiFoCetc+cbLR9YNH1e+OK//4O7+P/XxtnVavljpbvn6zo/yUq30p8aDjhMby+fIiLnW1bN/5aHJZ+QQ/YX3DaphFzUC9QCmYnScVmw4X8xbEHFkHZNQfRy1lMkAFKd/kKDONFMSe0DvgXyJYQVcxICAD5+GfMiTh7LAqHyCV/B2DZQTWcQf4mp38JMDy94aLMt8CAfAxTcQLZQkQEVFdlPGCDlb33mbscjsJYTDEWWUT+6fT/vSiAbnAgMBAAECggEAM9Yh9Rr5N+ozRpQfvhEAtVFUBoIHhgLEuIma11RKigXSgs7/39K01dRUKbJtL0ioecSOy0Ubr+TUPmkcLzf26eSObr+6uQf489/pzS6D1YeygYB+dReJ4hm3LVT452kPRY7wTRaYwS6NtYydlikXDFK9e/4UYy95B7I8uhQ/VfcJ5QEy2jXZolfd5KcIfAARt78pT8Zgk3eWT8yjdJ95r+0Xf8oFQyMx/2BJSadXHJM4oiGDxOXSYPMGDqUwV2fEBagAieS0Hw0uFS7r71LieRbuDPDT1U95qGIuNeSrC0MSZDyPN1TyiDZ1dcR2W7zBbAfPjZH8gdVrU4Q18AbAAQKBgQDDCbFUhwO0IPluj1yGrN+vb5XZZrtRUtMrNFH7uTbrscuW/325o3KaCor6wGrBts6BV+OTJ0sW8NX2OHJUL6iTAKcbQKaPYw7oBNjMmQEpUK4Zoggf9opvdoMuJoh6DvGFNIy6KDJ+Olf45HJYZNlOW8/KA4LBjCrdq2RsB7agAQKBgQCqclnJYkEEWXxAoQLYGgNV7LJ40b5Pn/4Avp2yBOcInbcE9eYN/nrNTsUtrPnV/ajcZQx2ijOeeOQCHy9nsUO3I2WmjxgjH80Y3lbWwy4mww+3D8DHqMECFXiStxYWAVJQaJKy2sK+kU40J3Cct0Anuyx8yEpYuVKlUnQEUP2m5wKBgAw/CI5pJ9dglqjVgZbHNgha9kq/Q5W4oJ++2kL2/zbPZBwoEKneVGzNqqpR+KIPK2o9rYFo3zMijhy2sJ8OmwQX72Yrqgmoy5/P5hj6pnMEqNndLatsHIchJt139+vKEmotwYRSz9DTMwDivzdDpc1gwGxLyiMC/RIMF/McjOABAoGAf3oMqvBAPjeLFW8WiHdUHVRs2q3LzxOSzg3CNV0zSZ9jPWOHjtnQEHMkR5gCNsiDHWq52oJcPt6dcPTP6JaMVZE0ulB1NffX1gycF/1cLANhYoF2ph0RVTSnu9sQup58aMT9SqUQV6SnP5xrvdnUMqLrj9vgtuDL7fdv67aDLusCgYBL9BUD6RyBtuPs30zReN22Wl4UjtmGM6lIYt87HkQ8xEoPontLEyiB+L0qzdX89D2aMufdWrXtcEOgL3PoJCVNkRr1TVF5XQXQf9En+0Q5qbapr/jU6mLl4zmV1wqJcgBPk2H15zOqZFArDLGE/p5fS+LfPNrYpy2+YfzWOpljng==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgduOeuVqcjsdzf1rdQNiM4L0JejoCRp6IvULO7F1tqup2qdM86+Hrph1fFTPbnK0NwtJyozh3EmqwqXj/zf3A/U9M63a14YhaAnrXPnGy0fWDR9Xvjiv/+Du/j/18bZ1Wr5Y6W75+s6P8lKt9KfGg44TG8vnyIi51tWzf+WhyWfkEP2F9w2qYRc1AvUApmJ0nFZsOF/MWxBxZB2TUH0ctZTJABSnf5CgzjRTEntA74F8iWEFXMSAgA+fhnzIk4eywKh8glfwdg2UE1nEH+Jqd/CTA8veGizLfAgHwMU3EC2UJEBFRXZTxgg5W995m7HI7CWEwxFllE/un0/70ogG5wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问

	public static String notify_url = "https://www.baidu.com/?tn=58025142_9_oem_dg&ch=12";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问

	public static String return_url = "https://www.baidu.com/?tn=58025142_9_oem_dg&ch=12";


	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

