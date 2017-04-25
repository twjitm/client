package com.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
/**
 *客户端
 * @author 
 *
 */
public class Test {
 public static void main(String[] args) {
	  NioSocketConnector connector=new NioSocketConnector();  
      // 获取过滤器链          
      DefaultIoFilterChainBuilder chain=connector.getFilterChain();  
      //  new ();
      connector.getFilterChain().addLast("logger", new LoggingFilter());
      connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
    ProtocolCodecFilter filter= new ProtocolCodecFilter(new  TextLineCodecFactory(Charset.forName( "UTF-8" )));   
//      // 添加编码过滤器 处理乱码、编码问题    
     chain.addLast("objectFilter",filter);
      // 消息核心处理器       
      connector.setHandler(new MinaClientHanlder());  
      // 设置链接超时时间       
      connector.setConnectTimeoutCheckInterval(30);  
      // 连接服务器，知道端口、地址      
      ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",9226));  
      // 等待连接创建完成      
      cf.awaitUninterruptibly();  
      File file=new File("d://test.txt");
      try {
	/*	InputStream input=new FileInputStream(file);
		@SuppressWarnings("resource")
		BufferedInputStream buf=new BufferedInputStream(input);
		 byte[] bytes=new byte[buf.available()];
		 int len =0;
		 while((len=buf.read(bytes))!=-1){
			 buf.read(bytes, 0, len);
		 }
		for(byte b:bytes){
			System.out.println((char)b);
		} */
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      cf.getSession().write(file);
      cf.getSession().getCloseFuture().awaitUninterruptibly();
      connector.dispose();  
      
}

}
