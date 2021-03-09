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
					System.out.println("ä�� ���� ���� �Ϸ�!!");
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					dis = new DataInputStream(in);
					dos = new DataOutputStream(out);
					while (true) {
						String serverMsg = dis.readUTF();
						System.out.println("[server] : " + serverMsg);
						if(serverMsg.equals("exit")) {
							System.out.println("ä���� ����Ǿ����ϴ�.");
							break;
						}
						System.out.print("�� : ");
						String clientMsg = sc.nextLine();
						dos.writeUTF(clientMsg);
						if (clientMsg.equals("exit")) {
							System.out.println("ä���� ����Ǿ����ϴ�.");
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
					System.out.print("�˰���� �������ּҸ� �Է��ϼ��� : ");
					String domain = sc.nextLine();
					dos.writeUTF(domain);
					String dIp = dis.readUTF();
					System.out.println("["+domain+"]�� �ּҴ� "+dIp+"�Դϴ�.");
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				break;
			}
		}

	}

	public int showView() {
		System.out.println("----- ��Ʈ��ũ ���α׷��� �ǽ� -----");
		System.out.println("1. ä�� Ŭ���̾�Ʈ ����");
		System.out.println("2. DNS Ŭ���̾�Ʈ ����");
		System.out.print("���� > ");
		int sel = sc.nextInt();
		sc.nextLine();
		return sel;
	}
}
