package com.yc.C89S2Plyspringboot.biz;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// 定义服务器地址
@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebSocket {
	// Hashtable 用来存放每个客户端对应的 id : Session 对象。
	private static Hashtable<String,Session> webSocketMap = new Hashtable<>();
	
	/**
	 * Hashtable, HashMap 的区别
	 * 1. Hashtable 线程安全   （访问效率低， 安全性高）
	 * 2. Hashtable 不允许null作为key值
	 */

	// 连接建立成功调用的方法    @PathParam 地址参数  /websocket/{id} ==》 id
	@OnOpen
	public void onOpen(@PathParam("id")String id, Session session) {
		// 将id保存到会话
		session.getUserProperties().put("myid", id);
		webSocketMap.put(id, session);
	}

	// 连接关闭调用的方法
	@OnClose
	public void onClose(Session session) {
		// 删除会话
		String id = (String) session.getUserProperties().get("myid");
		webSocketMap.remove(id);
	}

	// 收到客户端消息后调用的方法
	@OnMessage
	/**
	 * 
	 * @param message
	 * @param session 发送者的session
	 * @throws IOException
	 */
	public void onMessage(String message, Session session) throws IOException {
		// 消息的格式：如何知道该消息发给谁？  id:msg
		String[] items = message.split(":");
		String youid = items[0];
		String msg = items[1];
		String myid = (String) session.getUserProperties().get("myid");
		// 查找接受者的Session
		Session recvSession = webSocketMap.get(youid);
		// 发送消息
		recvSession.getBasicRemote().sendText(myid + ":" + msg);
	}
	
	@Scheduled(cron = "0 * 9-17 * * *")
	public void hello() throws IOException {
		for(Session session : webSocketMap.values()) {
			String id = (String) session.getUserProperties().get("myid");
			session.getBasicRemote().sendText("系统消息:" + id + "你好");
		}
	}
}

