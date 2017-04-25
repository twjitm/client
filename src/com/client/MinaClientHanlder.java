package com.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.client.entitiy.Person;

public class MinaClientHanlder extends IoHandlerAdapter{
	/**
	 * 连接创建之后发送数据
	 */
	
	 @Override  
	public void sessionOpened(IoSession session) throws Exception {  
//      Person person = new Person();  
//	       person.setAge(21);
//	       person.setName("唐文江");
//	       String json=JSON.toJSONString(person);
//       session.write(json);  
//      // session.write("123"+" /r/n");
       System.out.println("****************客户端发送数据*********");
   }  
     
	 /**
      * 断开重连
      */
	 public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	/*	 for(;;){
				try{
					Thread.sleep(3000);
				//	ConnectFuture future = connector.connect();
					//future.awaitUninterruptibly();// 等待连接创建成功
					//session = future.getSession();// 获取会话
					if(session.isConnected()){
						//logger.info("断线重连["+ connector.getDefaultRemoteAddress().getHostName() +":"+ connector.getDefaultRemoteAddress().getPort()+"]成功");
						break;
					}
				}catch(Exception ex){
					//logger.info("重连服务器登录失败,3秒再连接一次:" + ex.getMessage());
				}
			}*/
		};
	 
	/**
	 * 服务端返回的数据
	 */
   @Override  
   public void messageReceived(IoSession session, Object message)  
           throws Exception {  
	       System.out.println("客户端接收服务端返回的数据*********"+message.toString());
	       Person p=(Person) JSON.toJSON(message.toString());
       System.out.println("Server Say:name:" + p.getName()+p.getAge());  
   }  
     /**
      * 断开连接
      */
   @Override  
   public void sessionClosed(IoSession session) throws Exception {  
	   System.out.println("服务宕机了**************");
       session.close();  
   }  
}
