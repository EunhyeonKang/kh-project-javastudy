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

			System.out.println("클라이언트의 접속을 기다립니다.....");
			Socket socket = server.accept();
			System.out.println("클라이언트가 접속했습니다.");
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			ArrayList<Integer> array = new ArrayList<Integer>();
			ArrayList<Integer> array1 = new ArrayList<Integer>();
			System.out.println("<<<<<BaseBall Game>>>>>");
			System.out.print("서버 숫자 : ");
			for (int i = 0; i < 3; i++) {
				int rNum = r.nextInt(10);
				array.add(rNum);
				System.out.print(array.get(i) + " ");
			}
			System.out.println();
			while (true) {
				cnt++;
				System.out.println("<<<<<Game Start>>>>>");
				while (true) {
					System.out.print("클라이언트가 입력한 수 -> ");
					for (int i = 0; i < array.size(); i++) {
						int cNum = dis.readInt();
						array1.add(cNum);
						System.out.print(array1.get(i) + " ");
						for (int j = 0; j < array1.size(); j++) {
							if (array.get(i) == array1.get(j) && i == j) {
								s++;
							} else if (array.get(i) == array1.get(j) && i != j) {
								b++;
							}
						}
					}
					array1.clear();
					System.out.println();
					System.out.println(s + "스트라이크 " + b + "볼");
					
					dos.writeInt(s);
					dos.writeInt(b);
					
					String cMsg = dis.readUTF();
					if(cMsg.equals("exit")) {
						System.out.println("3스크라이크. 정답 현재 클라이언트와의 접속을 종료합니다.");
						break;
					}
					s = 0;
					b = 0;
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
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
