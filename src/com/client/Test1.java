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
	      // 获取过滤器链          
	      DefaultIoFilterChainBuilder chain=connector.getFilterChain();  
	      connector.getFilterChain().addLast("codec",
	                new ProtocolCodecFilter(new TextLineCodecFactory()));
	      ProtocolCodecFilter filter= new ProtocolCodecFilter(new  TextLineCodecFactory(Charset.forName( "UTF-8" )));   
	      // 添加编码过滤器 处理乱码、编码问题    
	      chain.addLast("objectFilter",filter);  
	      // 消息核心处理器       
	      connector.setHandler(new MinaClientHanlder());  
	      // 设置链接超时时间       
	      connector.setConnectTimeoutCheckInterval(30);  
	      // 连接服务器，知道端口、地址      
	      ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",9226));  
	      // 等待连接创建完成      
	      cf.awaitUninterruptibly();  
	      cf.getSession().getCloseFuture().awaitUninterruptibly();  
	      connector.dispose();
	      
	}
}
