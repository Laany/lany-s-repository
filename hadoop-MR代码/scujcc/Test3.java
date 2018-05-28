package scujcc;

public class Test3 {
	public static void main(String[] args) {
		String a = "2017-12-17 16:14:39.807";
		System.out.println(a.substring(11, 13) + a.substring(14, 16));
		String b = "  四川大学锦城学院    ";
		String s[] = a.split(" ");
		System.out.println(s[1].substring(0, 2) + s[1].substring(3, 5));
		if (!b.contains("一") && !b.contains("四")) {
			System.out.println("111");
		}
		
		Double dou1 = 3000.0000;  
		Double dou2 = 20.00;
		Double dou3;
		//dou = (double)Math.round(dou*100)/100;
	}
}
