package com.android.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeService {

	public static String getCode(String codePath) throws Exception {
		// TODO Auto-generated method stub
		URL url=new URL(codePath);//ʵ����һ��URL����
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();//ʵ����һ��HttpURLConnection����
		connection.setConnectTimeout(5000);//�������ӳ�ʱʱ��Ϊ5��
		connection.setRequestMethod("GET");//�������ӵķ�ʽΪget��ʽ
		int code=connection.getResponseCode();//��ȡ״̬��
		//�������ɹ��Ļ�
		if(code==200){
			InputStream inputStream=connection.getInputStream();//��ȡ������������InputStream����
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//ʵ����һ��ByteArrayOutputStream����
			byte[] buffer=new byte[1024];//ʵ����һ���ֽ��������
			int len=0;//����һ����������ʼֵΪ0
			//����ȡ����������������ʱ��ѭ��д������
			while((len=inputStream.read(buffer))!=-1){
				outputStream.write(buffer, 0, len);//д������
			}
			inputStream.close();//�ر�������
			byte[] data=outputStream.toByteArray();//����ֽ�����
			String result=new String(data, "UTF-8");//ͨ����ȡ�����ֽ���������ʵ����һ��String���󣬱����ʽΪUTF-8
			return result;//����д�������
		}
		return null;
	}

}
