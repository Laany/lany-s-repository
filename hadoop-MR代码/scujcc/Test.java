package scujcc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Test {
//	public static void main(String args[]) {  
//        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
//
//            /* 读入TXT文件 */  
//            File filename = new File("F:\\hadoopdata\\weather.txt"); // 要读取以上路径的input。txt文件  
//            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
//            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
//            String line = "";  
//            line = br.readLine();  
//            while (line != null) {  
//                line = br.readLine(); // 一次读入一行数据
//                if (line.contains("2017-01-01")) {
//                	System.out.println(line);
//                	break;
//                }
//            } 
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }
	
	public String getWeather(String date) {
		String informtion=null;
		
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  

            /* 读入TXT文件 */  
            File filename = new File("F:\\hadoopdata\\weather.txt"); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            line = br.readLine();  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                if (line.contains(date)) {
                	informtion = line;
                	break;
                }
            } 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		
		return informtion;
	}
}
