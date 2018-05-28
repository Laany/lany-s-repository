package scujcc;

import java.io.IOException;
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

public class FirstRead{
	public static class WordMapper extends Mapper<Object, Text, Text, Text> {
		private String id;    //学号
		private String date;  //年月
		private String type;  //操作类型
		private String trash; //无用数据
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
            		id = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
            		trash = itr.nextToken();
                	type = itr.nextToken().substring(0, 2);
        		    date =itr.nextToken();
        		    trash = date.substring(0, 4);
        		    System.out.println(type);
        		    System.out.println(trash);
                }
            	System.out.println("1111");
            	
            	if (type.equals("借书") && trash.equals("2017")) {
            		System.out.println("444444");
            		context.write(new Text(id), new Text(date));
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			System.out.println("111");
			String date;
			int first=1231;
			System.out.println("aaaaa");
			try {
	            for (Text val : values) {
	            	date= new String(val.getBytes(), 0, val.getLength());
	            	date = date.substring(5, 7) + date.substring(8, 10);
	            	//System.out.println(date);
	            	if (Integer.parseInt(date) <= first)
	            		first = Integer.parseInt(date);
	            }
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(first);
			date = Integer.toString(first);
			if (date.length() == 3)
				date = "2017-" + "0" + Integer.toString(first).substring(0, 1) + "-" + Integer.toString(first).substring(1, 3);
			if (date.length() == 4)
				date = "2017-" + Integer.toString(first).substring(0, 2) + "-" + Integer.toString(first).substring(2, 4);
			
			Test test = new Test();
			if (test.getWeather(date) != null )
				date = test.getWeather(date);
            context.write(key, new Text(date));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(FirstRead.class);  
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