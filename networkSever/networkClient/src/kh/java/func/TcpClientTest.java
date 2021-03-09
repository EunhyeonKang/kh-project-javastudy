package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientTest {
	Scanner sc;

	public void main() {
		String serverIp = "127.0.0.1";
		int serverPort = 8080;
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		sc = new Scanner(System.in);
		while (true) {
			int sel = showView();
			switch (sel) {
			case 1:
				try {
					socket = new Socket(serverIp, serverPort);
					System.out.println("채팅 서버 접속 완료!!");
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					dis = new DataInputStream(in);
					dos = new DataOutputStream(out);
					while (true) {
						String serverMsg = dis.readUTF();
						System.out.println("[server] : " + serverMsg);
						if(serverMsg.equals("exit")) {
							System.out.println("채팅이 종료되었습니다.");
							break;
						}
						System.out.print("나 : ");
						String clientMsg = sc.nextLine();
						dos.writeUTF(clientMsg);
						if (clientMsg.equals("exit")) {
							System.out.println("채팅이 종료되었습니다.");
							break;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						dis.close();
						dos.close();
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				break;
			case 2:
				try {
					socket =new Socket(serverIp,serverPort);
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					dis = new DataInputStream(in);
					dos = new DataOutputStream(out);
					System.out.print("알고싶은 도메인주소를 입력하세요 : ");
					String domain = sc.nextLine();
					dos.writeUTF(domain);
					String dIp = dis.readUTF();
					System.out.println("["+domain+"]의 주소는 "+dIp+"입니다.");
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
			}
		}

	}

	public int showView() {
		System.out.println("----- 네트워크 프로그래밍 실습 -----");
		System.out.println("1. 채팅 클라이언트 시작");
		System.out.println("2. DNS 클라이언트 시작");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		sc.nextLine();
		return sel;
	}
}
