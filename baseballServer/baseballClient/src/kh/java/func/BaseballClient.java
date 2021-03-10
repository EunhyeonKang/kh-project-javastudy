package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseballClient {
	public void gameClient() {
		Scanner sc = new Scanner(System.in);
		String serverIp = "127.0.0.1";
		int serverPort = 8989;
		Socket socket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		int cnt = 0;
		try {
			socket = new Socket(serverIp, serverPort);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			int[] array = new int[3];
			System.out.println("<<<<<Baseball Game>>>>>");
			while (true) {
				System.out.println("<<<<<Game Start>>>>>");
				while (true) {
					cnt++;
					for (int i = 0; i < 3; i++) {
						System.out.print((i + 1) + "��° ���� �Է� : ");
						int cNum = sc.nextInt();
						array[i] = cNum;

					}
					for (int i = 0; i < 3; i++) {
						dos.writeInt(array[i]);
					}
					int s = dis.readInt();
					int b = dis.readInt();
					cnt++;
					if (s == 3||cnt==9) {
						System.out.println(cnt + "ȸ -----> " + s + "��Ʈ����ũ");
						System.out.println("�����մϴ�!!");
						System.out.println("���α׷��� �����մϴ�.");
						break;
					} else {
						System.out.println(cnt + "ȸ -----> " + s + "��Ʈ����ũ " + b + "��");
					}
				}

				break;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}