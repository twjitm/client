package com.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.alibaba.fastjson.JSON;
import com.client.entitiy.Person;

public class MinaClientHanlder extends IoHandlerAdapter{
	/**
	 * ���Ӵ���֮��������
	 */
	
	 @Override  
	public void sessionOpened(IoSession session) throws Exception {  
//      Person person = new Person();  
//	       person.setAge(21);
//	       person.setName("���Ľ�");
//	       String json=JSON.toJSONString(person);
//       session.write(json);  
//      // session.write("123"+" /r/n");
       System.out.println("****************�ͻ��˷�������*********");
   }  
     
	 /**
      * �Ͽ�����
      */
	 public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	/*	 for(;;){
				try{
					Thread.sleep(3000);
				//	ConnectFuture future = connector.connect();
					//future.awaitUninterruptibly();// �ȴ����Ӵ����ɹ�
					//session = future.getSession();// ��ȡ�Ự
					if(session.isConnected()){
						//logger.info("��������["+ connector.getDefaultRemoteAddress().getHostName() +":"+ connector.getDefaultRemoteAddress().getPort()+"]�ɹ�");
						break;
					}
				}catch(Exception ex){
					//logger.info("������������¼ʧ��,3��������һ��:" + ex.getMessage());
				}
			}*/
		};
	 
	/**
	 * ����˷��ص�����
	 */
   @Override  
   public void messageReceived(IoSession session, Object message)  
           throws Exception {  
	       System.out.println("�ͻ��˽��շ���˷��ص�����*********"+message.toString());
	       Person p=(Person) JSON.toJSON(message.toString());
       System.out.println("Server Say:name:" + p.getName()+p.getAge());  
   }  
     /**
      * �Ͽ�����
      */
   @Override  
   public void sessionClosed(IoSession session) throws Exception {  
	   System.out.println("����崻���**************");
       session.close();  
   }  
}
