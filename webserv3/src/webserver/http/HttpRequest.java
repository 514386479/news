package webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HttpRequest {
	private Socket socket;
	private InputStream in;
	/*
	 * �����������Ϣ����
	 */
	// ����ʽ
	private String method;
	// �������Դ·��
	private String url;
	// ����ʹ�õ�Э��汾
	private String protocol;

	public HttpRequest(Socket socket) throws EmptyRequestException {

		try {
			this.socket = socket;
			in = socket.getInputStream();
			/*
			 * 1.���������� 2.������Ϣͷ 3.������Ϣ����
			 * 
			 */
			// 1
			parseRequestLine();
			// 2
			parseHeaders();
			// 3
			parseContent();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 1.����������
	 */
	private void parseRequestLine() throws EmptyRequestException {
		String str =readLine(in);
        String [] arr=str.split(" ");
        System.out.println("������"+str);
        if(arr.length>=3){
        	 method=arr[0];
         	// �������Դ·��
             url=arr[1];
         	// ����ʹ�õ�Э��汾
         	protocol=arr[2];
        }else{
        	throw new EmptyRequestException("������");	
        }
       

	}
	

	// ������Ϣͷ
	private void parseHeaders() {
		
	}

	// ������Ϣ����
 private void parseContent()  {
		
	}

	

	private String readLine(InputStream in) {
		StringBuilder builder = new StringBuilder();

		int d = -1;
		char c1 = '1', c2 = '1';
		try {
			while ((d = in.read()) != -1) {
				c2 = (char) d;
				if (c1 == 13 && c2 == 10) {
					break;
				}
				builder.append(c2);
				c1 = c2;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return builder.toString().trim();

	}
}
