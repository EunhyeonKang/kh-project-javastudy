package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public void main() {
		//1.서버 아이피 주소 / 포트번호 지정
		String serverIp = "127.0.0.1"; //자기자신컴퓨터를 호출하는 아이피 (루프백 아이피)
		int serverPort = 8888;
		Socket socket =null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		Scanner sc = new Scanner(System.in);
		try {
			//지정된 서버 아이피와 포트로 소켓객체를 생성하면서 요청, accept
			socket = new Socket(serverIp,serverPort);
			System.out.println("서버 접속 완료");
			//3. 서버와 연결할 입력 및 출력 스트림 생성
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//보조스트림을 통한 성능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			//5. 스트림을 통한 입력 및 출력
			String serverMsg = dis.readUTF();
			System.out.println("server : "+serverMsg);
			System.out.print("[client]메시지 입력 : ");
			String msg = sc.nextLine();
			dos.writeUTF(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
