package com.android.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageService {

	public static byte[] getImage(String imagePath) throws Exception {
		// TODO Auto-generated method stub
		URL url=new URL(imagePath);//ʵ����URL����url
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();//ʵ����HttpURLConnection����connection
		connection.setConnectTimeout(5000);//�������ӳ�ʱʱ��Ϊ5��
		connection.setRequestMethod("GET");//�������󷽷�Ϊget��ʽ
		int code=connection.getResponseCode();//��ȡ״̬��
		//���״̬������ɹ��Ļ�����code����HttpURLConnection.HTTP_OK��Ҳ����д��code==200
		if(code==HttpURLConnection.HTTP_OK){
			InputStream inputStream=connection.getInputStream();//���������������һ��InputStream����
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//ʵ����һ���ֽ������������������
			byte[] buffer=new byte[1024];//ʵ����һ���ֽ��������
			int len=0;//����һ����������ʼֵΪ0
			//����ȡ����������������ʱ��ѭ��д������
			while((len=inputStream.read(buffer))!=-1){
				outputStream.write(buffer, 0, len);//д������
			}
			inputStream.close();//�ر�������
			return outputStream.toByteArray();//���������ֽ�����
	}
		return null;
	}
}
		