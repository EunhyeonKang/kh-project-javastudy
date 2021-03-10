package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TcpChatServer {
	public void chatServer() {
		Scanner sc = new Scanner(System.in);
		//1. 포트번호 지정
		int port = 5555;
		ServerSocket server = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("[서버 준비 완료]");
			System.out.println("클라이언트 접속 요청을 기다립니다...");
			Socket client = server.accept();
			OutputStream out = client.getOutputStream();
			InputStream in = client.getInputStream();
			while(true) {
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);
				System.out.print("server : ");
				String str = sc.nextLine();
				dos.writeUTF(str);
				if(str.equals("exit")) {
					break;
				}
				
				String cliMsg = dis.readUTF();
				if(cliMsg.equals("exit")) {
					System.out.println("채팅이 종료되었습니다.");
					break;
				}
				System.out.println("[client] : "+cliMsg+now());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String now() {
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" [HH:mm:ss]");
		String now = sdf.format(time);
		return now;
	}
}
