package kh.java.start;

import kh.java.func.CharStreamTest;
import kh.java.func.FileTest;
import kh.java.func.StreamTest;
import kh.java.func.UserMgr;
import kh.java.func.byteStreamTest;

public class Start {

	public static void main(String[] args) {
		byteStreamTest bt = new byteStreamTest();
		CharStreamTest ct = new CharStreamTest();
		FileTest ft = new FileTest();
		StreamTest st = new StreamTest();
		UserMgr um = new UserMgr();
//		bt.primaryStram();
//		ct.primaryStream();
//		ct.subStream();
//		ct.charStreamReader();
//		st.imageStream();
//		ft.fileTest();
		um.main();
	}

}
