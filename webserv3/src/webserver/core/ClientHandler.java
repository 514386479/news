package webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import webserver.http.EmptyRequestException;
import webserver.http.HttpRequest;

public class ClientHandler implements Runnable {
       private Socket socket;
       private InputStream in;
	public ClientHandler(Socket socket) {
	
		this.socket = socket;
	   
		
	}
       //����ҵ����߳�
	@Override
	public void run() {
		try {
			System.out.println("��ʼ����ҵ��");
			/*
			 * ����ͻ�������Ĵ�������
			 * 1:��������
			 * 2:��������
			 * 3:��Ӧ�ͻ���
			 * */
			 HttpRequest request=new HttpRequest(socket);
			
		} catch (EmptyRequestException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
