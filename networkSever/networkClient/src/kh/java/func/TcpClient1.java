package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TcpClient1 {
	Scanner sc;
	public void main() {
		String serverIp = "1.220.236.74";
		int serverPort = 18080;
		Socket socket = null;
		DataInputStream dis= null;
		DataOutputStream dos= null;
		
		sc = new Scanner(System.in);
		try {
			socket = new Socket(serverIp,serverPort);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			while(true) {
				String getMsg = dis.readUTF();
				System.out.println(getMsg);
				String lastStr = getMsg.substring(getMsg.length()-1);
				char[] lastChar = lastStr.toCharArray();
				char ch = lastChar[lastChar.length-1];
				if(ch=='?') {
					System.out.print("³ª : ");
					String setMsg = sc.nextLine(); 
					dos.writeUTF(setMsg);
				}else {
					continue;
				}
			}
			
			
			
			
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
