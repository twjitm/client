package com.client.entitiy;
/**
 * 消息的定�?
 * @author twj
 *
 */
import java.util.Date;
public class Message {
	
private String despId;//发�?�?
private String sendId;//接收�?
private Date senddate;//发�?时间
private Object msgdata;//发�?数据

public String getDespId() {
	return despId;
}
public void setDespId(String despId) {
	this.despId = despId;
}
public String getSendId() {
	return sendId;
}
public void setSendId(String sendId) {
	this.sendId = sendId;
}
public Date getSenddate() {
	return senddate;
}
public void setSenddate(Date senddate) {
	this.senddate = senddate;
}
public Object getMsgdata() {
	return msgdata;
}
public void setMsgdata(Object msgdata) {
	this.msgdata = msgdata;
}

	
}
