package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServerTest {
	Scanner sc;

	public void main() {
		int port = 8080;
		ServerSocket server = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		sc = new Scanner(System.in);
		while (true) {
			int sel = showView();

			switch (sel) {
			case 1:
				try {
					server = new ServerSocket(port);
					System.out.println("[서버 준비 완료]");
					System.out.println("클라이언트 접속 요청을 기다립니다.....");
					Socket client = server.accept();
					System.out.println("클라이언트 접속 완료");

					OutputStream out = client.getOutputStream();
					InputStream in = client.getInputStream();
					dos = new DataOutputStream(out);
					dis = new DataInputStream(in);
					while (true) {
						System.out.print("나 : ");
						String myMsg = sc.nextLine();
						if (myMsg.equals("exit")) {
							dos.writeUTF(myMsg);
							System.out.println("채팅이 종료되었습니다.");
							break;
						}
						dos.writeUTF(myMsg);
						String clientMsg = dis.readUTF();
						if (clientMsg.equals("exit")) {
							System.out.println("채팅이 종료되었습니다.");
							break;
						}
						System.out.println("[client] : " + clientMsg);
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
				break;
			case 2:
				try {
					server = new ServerSocket(port);
					System.out.println("DNS서버 준비 완료");

					int cnt = 0;
					while (true) {
						System.out.println("클라이언트 요청 대기 상태...");
						Socket client = server.accept();
						OutputStream out = client.getOutputStream();
						InputStream in = client.getInputStream();
						dos = new DataOutputStream(out);
						dis = new DataInputStream(in);
						String domain = dis.readUTF();
						cnt++;
						if (domain.equals("www.naver.com")) {
							dos.writeUTF("125.809.222.142");
						} else if (domain.equals("www.google.com")) {
							dos.writeUTF("172.217.175.4");
						} else if (domain.equals("www.iei.or.kr")) {
							dos.writeUTF(" 211.43.14.187");
						}
						System.out.println("요청 " + cnt + "건 처리 완료");
						System.out.println("서버를 종료하시겠습니까[y/n]? ");
						String str = sc.next();
						if(str.equals("y")) {
							break;
						}else if(str.equals("n")){
							continue;
						}
						
					}

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
		System.out.println("1. 채팅 서버 시작");
		System.out.println("2. DNS 서버 시작");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		sc.nextLine();
		return sel;
	}
}
