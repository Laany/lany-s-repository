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

public class MostLike2 {
	public static class WordMapper extends Mapper<Object, Text, Text, Text> {
		private String id;    //学号
		private String name;	//姓名
		private String place; //消费地点
		private String times; //次数
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
            		id = itr.nextToken();
            		name = itr.nextToken();
        		    place = itr.nextToken();
        		    times = itr.nextToken();
                }
            	
            	
            	context.write(new Text(id + "\t" + name), new Text(place + "\t" + times));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			int i = 0;
			String date;
			String dates[] = null;
			int time = 0;
			int times = 0;
			String place = null;
			
	        for (Text val : values) {
	        	date= new String(val.getBytes(), 0, val.getLength());
	        	dates = date.split("\t");
	        	System.out.println(date);
	        	time = Integer.parseInt(dates[1]);
	        	
	        	if (time > times) {
	        	    times = time;
	        	    place = dates[0];
	            }
	        }
            context.write(key, new Text(place + "\t" + Integer.toString(times)));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(MostLike2.class);  
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
