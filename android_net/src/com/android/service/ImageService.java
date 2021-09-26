package com.android.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageService {

	public static byte[] getImage(String imagePath) throws Exception {
		// TODO Auto-generated method stub
		URL url=new URL(imagePath);//实例化URL对象url
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();//实例化HttpURLConnection对象connection
		connection.setConnectTimeout(5000);//设置连接超时时间为5秒
		connection.setRequestMethod("GET");//设置请求方法为get方式
		int code=connection.getResponseCode();//获取状态码
		//如果状态码请求成功的话，即code等于HttpURLConnection.HTTP_OK，也可以写成code==200
		if(code==HttpURLConnection.HTTP_OK){
			InputStream inputStream=connection.getInputStream();//获得输入流，返回一个InputStream对象
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//实例化一个字节数组输出输入流对象
			byte[] buffer=new byte[1024];//实例化一个字节数组对象
			int len=0;//定义一个变量，初始值为0
			//当获取到的输入流有数据时，循环写入数据
			while((len=inputStream.read(buffer))!=-1){
				outputStream.write(buffer, 0, len);//写入数据
			}
			inputStream.close();//关闭输入流
			return outputStream.toByteArray();//返回数据字节数组
	}
		return null;
	}
}
		