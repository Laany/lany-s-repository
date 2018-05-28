package scujcc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import javafx.animation.Interpolatable;



public class SameBook{
	public static class WordMapper extends Mapper<Object, Text, Text, Text> {
		private String id;    //学号
		private String stuname;  //学生名字
		private String bookname;  //书名
		private String xueyuan; //院系
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) { 
            		bookname = itr.nextToken();
            		id = itr.nextToken();
            		stuname = itr.nextToken();
            		xueyuan = itr.nextToken();
                }
            	context.write(new Text(bookname), new Text(id + "\t" + stuname + "\t" + xueyuan));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			System.out.println("111");
			String bookname = new String(key.getBytes(), 0, key.getLength());
			System.out.println("aaaaa");
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			for (Text val : values)
			{
				String inf = new String(val.getBytes(), 0, val.getLength());
				list1.add(inf);
				list2.add(inf);
			}
			Iterator<String> it1 = list1.iterator(); //第一次的到学号
			Iterator<String> it2 = list2.iterator(); //第二次得到学号
			
			try {
	            while (it1.hasNext()) {  //便利同一个key值里的所有学生
	            	String[] aa = it1.next().split("\t");
	            	String samestudent = bookname + "\t";
	            	while (it2.hasNext())  //第二次遍历key里的所有学生
	            	{
	            		String[] bb = it2.next().split("\t");
	            		if (!bb[0].equals(aa[0])) //如果学号不相等
	            			samestudent = samestudent + bb[1] + "(" + bb[2] + ")" + ",";
	            	}
	            	it2 = list2.iterator();
	            	context.write(new Text(aa[0] + "\t" +aa[1]), new Text(samestudent));
	            }
			} catch (Exception e) {
				// TODO: handle exception
			}
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(SameBook.class);  
		job.setMapperClass(WordMapper.class);   
		job.setReducerClass(WordReducer.class); 
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(Text.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}