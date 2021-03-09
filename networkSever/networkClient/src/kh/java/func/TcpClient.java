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
		//1.���� ������ �ּ� / ��Ʈ��ȣ ����
		String serverIp = "127.0.0.1"; //�ڱ��ڽ���ǻ�͸� ȣ���ϴ� ������ (������ ������)
		int serverPort = 8888;
		Socket socket =null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		Scanner sc = new Scanner(System.in);
		try {
			//������ ���� �����ǿ� ��Ʈ�� ���ϰ�ü�� �����ϸ鼭 ��û, accept
			socket = new Socket(serverIp,serverPort);
			System.out.println("���� ���� �Ϸ�");
			//3. ������ ������ �Է� �� ��� ��Ʈ�� ����
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//������Ʈ���� ���� ���� ����
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			//5. ��Ʈ���� ���� �Է� �� ���
			String serverMsg = dis.readUTF();
			System.out.println("server : "+serverMsg);
			System.out.print("[client]�޽��� �Է� : ");
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
