package com.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class Test1 {
	 public static void main(String[] args) {
		  NioSocketConnector connector=new NioSocketConnector();  
	      // ��ȡ��������          
	      DefaultIoFilterChainBuilder chain=connector.getFilterChain();  
	      connector.getFilterChain().addLast("codec",
	                new ProtocolCodecFilter(new TextLineCodecFactory()));
	      ProtocolCodecFilter filter= new ProtocolCodecFilter(new  TextLineCodecFactory(Charset.forName( "UTF-8" )));   
	      // ��ӱ�������� �������롢��������    
	      chain.addLast("objectFilter",filter);  
	      // ��Ϣ���Ĵ�����       
	      connector.setHandler(new MinaClientHanlder());  
	      // �������ӳ�ʱʱ��       
	      connector.setConnectTimeoutCheckInterval(30);  
	      // ���ӷ�������֪���˿ڡ���ַ      
	      ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",9226));  
	      // �ȴ����Ӵ������      
	      cf.awaitUninterruptibly();  
	      cf.getSession().getCloseFuture().awaitUninterruptibly();  
	      connector.dispose();
	      
	}
}
