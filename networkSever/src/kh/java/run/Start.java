package kh.java.run;

import kh.java.func.TcpChatServer;
import kh.java.func.TcpServerTest;
import kh.java.func.udpServer;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TcpServer ts = new TcpServer();
//		ts.main();
//		TcpServerTest sts = new TcpServerTest();
//		sts.main();
//		TcpChatServer tcs = new TcpChatServer();
//		tcs.chatServer();
		udpServer ss = new udpServer();
		ss.main();
	}

}
