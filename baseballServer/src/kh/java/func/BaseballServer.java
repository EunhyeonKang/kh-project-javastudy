package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseballServer {
	public void gameServer() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int serverPort = 8989;
		ServerSocket server = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		int s = 0;
		int b = 0;
		int cnt = 0;
		try {
			server = new ServerSocket(serverPort);
			while (true) {
				s = 0;
				b = 0;
				System.out.println("클라이언트의 접속을 기다립니다.....");
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속했습니다.");
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);
				int[] array = new int[3];
				int[] array1 = new int[3];
				System.out.println("<<<<<BaseBall Game>>>>>");

				for (int i = 0; i < 3; i++) {
					int rNum = r.nextInt(10);
					array[i] = rNum;

				}

				for (int i = 0; i < array.length; i++) {
					// 중복된 값인지
					int rNum1 = r.nextInt(10);
					// 입력 범위가 정상인 경우
					boolean bool = true;
					for (int j = 0; j < i; j++) {
						if (rNum1 == array[j]) {
							i--;
							bool = false;
							break;
						}
					}
					if (bool) {
						array[i] = rNum1;
					}
				}
				System.out.print("서버 숫자 : ");
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();

				System.out.println("<<<<<Game Start>>>>>");
				while (true) {
					System.out.print("클라이언트가 입력한 수 -> ");
					for (int i = 0; i < array.length; i++) {
						int cNum = dis.readInt();
						array1[i] = cNum;
						System.out.print(array1[i] + " ");

					}
					for (int i = 0; i < array.length; i++) {
						for (int j = 0; j < array1.length; j++) {
							if (array[i] == array1[j]) {
								if (i == j) {
									s++;
								} else {
									b++;
								}
							}

						}
					}
					System.out.println();
					System.out.println(s + "스트라이크 " + b + "볼");
					cnt++;
					if (s == 3 || cnt == 9) {
						System.out.println("3스크라이크. 정답 현재 클라이언트와의 접속을 종료합니다.");
						dos.writeInt(s);
						dos.writeInt(b);
						break;
					}
					dos.writeInt(s);
					dos.writeInt(b);
					s = 0;
					b = 0;
				}

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
}