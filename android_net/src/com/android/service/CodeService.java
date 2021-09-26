package com.android.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeService {

	public static String getCode(String codePath) throws Exception {
		// TODO Auto-generated method stub
		URL url=new URL(codePath);//实例化一个URL对象
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();//实例化一个HttpURLConnection对象
		connection.setConnectTimeout(5000);//设置连接超时时间为5秒
		connection.setRequestMethod("GET");//设置连接的方式为get方式
		int code=connection.getResponseCode();//获取状态码
		//如果请求成功的话
		if(code==200){
			InputStream inputStream=connection.getInputStream();//获取输入流，返回InputStream对象
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//实例化一个ByteArrayOutputStream对象
			byte[] buffer=new byte[1024];//实例化一个字节数组对象
			int len=0;//定义一个变量，初始值为0
			//当获取到的输入流有数据时，循环写入数据
			while((len=inputStream.read(buffer))!=-1){
				outputStream.write(buffer, 0, len);//写入数据
			}
			inputStream.close();//关闭输入流
			byte[] data=outputStream.toByteArray();//获得字节数组
			String result=new String(data, "UTF-8");//通过获取到的字节数组数据实例化一个String对象，编码格式为UTF-8
			return result;//返回写入的数据
		}
		return null;
	}

}
