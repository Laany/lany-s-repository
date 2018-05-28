package org.apache.hadoop.examples;

import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("this	is	a	test	1");
		while (st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st.nextToken());
			break;
//			if (st.hasMoreTokens()) {
//				continue;
//			}
//			else {
//				st.nextToken();
//			}
		}
	}
}
