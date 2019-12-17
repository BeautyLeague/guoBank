package com.guobank.wanzehao.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class HttpClientUtil {
	public String ClientUtil(String phone,String smsText,String Uid,String key) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
		NameValuePair[] data = { new NameValuePair("Uid",Uid),
				new NameValuePair("Key", key),
				new NameValuePair("smsMob", phone),
				new NameValuePair("smsText", smsText) };
		post.setRequestBody(data);//请求的数据
		client.executeMethod(post);//请求地址
		Header[] headers = post.getResponseHeaders();//头
		int statusCode = post.getStatusCode();//状态码
		System.out.println("statusCode:" + statusCode);
		//循环头部信息
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes(
				"utf-8"));
		post.releaseConnection();
		return result;// 打印返回消息状态
	}
}
