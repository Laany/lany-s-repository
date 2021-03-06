package org.apache.hadoop.examples;

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

public class StudentCount {
	public static class WordMapper extends Mapper<Object, Text, Text, IntWritable> {
		private int score;
		private String id;
		private String data;
		private String subject;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
                	id = itr.nextToken(); 
        		    data = itr.nextToken();
        		    subject = itr.nextToken();
        		    score = Integer.parseInt(itr.nextToken());
        		    System.out.println(score);
        		    break;
                }
                context.write(new Text(id + "+" + data), new IntWritable(score));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			System.out.println("1111");
			int sum = 0;
            int avg = 0;
            int count = 0;
            for (IntWritable val : values) {  
                sum += val.get();
                ++count;
            }
            System.out.println(key);
            System.out.println(sum);
            System.out.println(count);
            avg = sum/count;
            context.write(key, new IntWritable(avg));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job(conf, "StudentCount");  
		job.setJarByClass(StudentCount.class);  
		job.setMapperClass(WordMapper.class);  
		job.setCombinerClass(WordReducer.class);  
		job.setReducerClass(WordReducer.class);  
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(IntWritable.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}
