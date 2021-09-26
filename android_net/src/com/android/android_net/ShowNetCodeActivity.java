package com.android.android_net;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.service.CodeService;

public class ShowNetCodeActivity extends Activity {

	private EditText codePath_et;//����EditText����
	private Button show_netcode;//����Button����
	private TextView textView;//����textView����
	private String result="";//��ʼ��һ���յ�String���ͱ���
	private Handler handler;//����һ��Handler����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code);
		/* ��ȡ���ֹ������еĸ����ؼ� */
		codePath_et=(EditText)findViewById(R.id.codePath_et);
		show_netcode=(Button)findViewById(R.id.show_netcode);
		textView=(TextView)findViewById(R.id.textView);
		
		//Ϊ��ť�����Ӽ����¼�
		show_netcode.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String codePath=codePath_et.getText().toString();//��ȡ����Դ���·��
				//�½�һ���߳�
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							result=CodeService.getCode(codePath);//����CodeSErvice���getCode�����������ַ�������
							Message msg=handler.obtainMessage();//ͨ��handler������Message��Ϣ
							handler.sendMessage(msg);//������Ϣ
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();//����һ���߳�		
				
				//ʵ����һ��Handler����
				handler=new Handler(){

					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						if(result!=null){
							textView.setText(result);//�����ı���ͼ��ʾ���ı�
						}
						super.handleMessage(msg);
					}
					
				};
			}
		});
	}
	
}
