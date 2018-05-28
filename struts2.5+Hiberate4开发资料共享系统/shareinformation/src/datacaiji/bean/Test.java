package datacaiji.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = sdf.format(new Date());
		System.out.println(time.substring(0, 4));
		System.out.println(time.substring(5,7));
		System.out.println(time.substring(8,10));
		System.out.println(time.substring(11,13));
		System.out.println(time.substring(14,16));
		System.out.println(time.substring(17,19));
		System.out.println(time);
		
		Test tt = new Test();
		int a = tt.f();
		
		System.out.println(a);
	}
	
	public int f() {
		int a = 0;
		
		try {
			a = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
