package access.cookie;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;


public class Cookie {
	public Cookie(){
		System.out.println("Cookie Constructor");
	}
	void bite(){ // ������Ȩ�ޣ� ��������ʹ������Ҳ���ܷ���
		System.out.println("bite");
	}
	
	private void test(){
		
	}
}

class SubCookie extends Cookie {
	public static void foo(){
		//new SubCookie().test();
	}
}
