package access.cookie;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;


public class Cookie {
	public Cookie(){
		System.out.println("Cookie Constructor");
	}
	void bite(){ // 包访问权限， 其它包即使是子类也不能访问
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
