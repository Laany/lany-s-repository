package scujcc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Test2 {
	public int getCount(String id) {
		int count = 0;
		String s[] = null;
		
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  

            /* 读入TXT文件 */  
            File filename = new File("F:\\hadoopdata\\bookcount"); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            line = br.readLine();  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                if (line.contains(id)) {
                	s = line.split("\t");
                	break;
                }
            } 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		
		count = Integer.parseInt(s[1]);
		return count;
	}
	
	public static void main(String[] args) {
		Test2 tt = new Test2();
		double k = 0;
		double i = tt.getCount("153020231");
		DecimalFormat df = new DecimalFormat("0.00%");
		k = 1/i;
		System.out.println(i);
		System.out.println(k);
		System.out.println(df.format(k));
	}
}
