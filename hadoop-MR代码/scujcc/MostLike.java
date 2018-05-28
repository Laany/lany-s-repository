package scujcc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MostLike {
	public static class WordMapper extends Mapper<Object, Text, Text, Text> {
		private String id;    //学号
		private String name;	//姓名
		private String comsume; //消费
		private String remain; //余额
		private String type;  //操作类型
		private String date;  //年月日时间
		private String place; //消费地点
		private String s[] = null;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
            		id = itr.nextToken();
            		name = itr.nextToken();
            		comsume = itr.nextToken();
            		remain = itr.nextToken();
                	type = itr.nextToken();
        		    date =itr.nextToken();
        		    s = date.split(" ");
        		    place = itr.nextToken();
                }
            	
            	if(!place.contains("四川大学锦城学院") && !place.contains("售卡室") && !place.contains("交行转入") && !place.contains("文印中心") &&
            			!place.contains("学生公司印务") && !place.contains("车队") && !place.contains("美来生活") && !place.contains("体育馆") &&
            			!place.contains("图书馆") && !place.contains("杏岛会所") && !place.contains("医务室")) {
            		context.write(new Text(id + "\t" + name + "\t" + place), new Text(s[1].substring(0, 2) + s[1].substring(3, 5)));
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, Text, Text, IntWritable> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			int i = 0;
			String date;
			int time = 0;
			
	        for (Text val : values) {
	        	date= new String(val.getBytes(), 0, val.getLength());
	        	System.out.println(date);
	        	time = Integer.parseInt(date);
	        	
	        	if (time>=1630 && time<2100) {
	        	    ++i;
	            }
	        }
            context.write(key, new IntWritable(i));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(MostLike.class);  
		job.setMapperClass(WordMapper.class);   
		job.setReducerClass(WordReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(IntWritable.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}
