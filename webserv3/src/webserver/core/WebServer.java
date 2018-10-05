package webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
   private ServerSocket server;
   
	public WebServer() {
	try {
		System.out.println("��ʼ���������");
		server=new ServerSocket(8080);
		System.out.println("������������");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void start(){
		try {
			System.out.println("�ȴ��ͻ�������");
			
			while(true){
				Socket socket=server.accept();
				//����һ���̴߳���ÿͻ�������
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();

	}

}
