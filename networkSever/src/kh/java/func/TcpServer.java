package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	public void main() {
		//1.서버에서 사용할 포트번호 지정
		//(0~65535 1000이내는 예약 번호가 많으므로 1000번이후)
		int port = 8888;
		//반환할 객체들을 미리 선언
		ServerSocket server = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//2. 서버용 소켓객체를 생성 -> 서버의 포트가 열리면서 서버가 대기상태가 가능
			//소켓레퍼런스 생성시 포트번호를 매개변수로 전달하면 해당포트 사용
			server = new ServerSocket(port);
			System.out.println("서버 준비 완료.......");
			//3. 클라이언트 접속 요청 대기 
			//4. 클라이언트 접속 요청이 들어오면 수락하여 클라이언트에 대한 소켓객체 생성
			System.out.println("클라이언트 접속 요청을 기다립니다.");
			Socket client = server.accept();
			System.out.println("클라이언트 접속 완료");
			//5. 연결된 클라이언트와 입력 및 풀력스트림 생성
			//객페를 새로 만드는 것이 아니라 소켓에 만들어진 스트림을 가져오는 개념
			OutputStream out = client.getOutputStream();
			InputStream in = client.getInputStream();
			//6. 보조스츠림을 총한 성능 개선
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			//7. 스트림을 총한 데이터 입력 및 출력
			System.out.print("[server]메시지 입력 : ");
			String msg = sc.nextLine();
			dos.writeUTF(msg);
			String clientMsg = dis.readUTF();
			System.out.println("client : "+clientMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
