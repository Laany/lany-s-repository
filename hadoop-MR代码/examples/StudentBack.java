package org.apache.hadoop.examples;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configuration.IntegerRanges;
import org.apache.hadoop.examples.CountAverage.WordMapper;
import org.apache.hadoop.examples.CountAverage.WordReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class StudentBack{
	public static class WordMapper extends Mapper<Object, Text, Text, IntWritable> {
		private String id;
		private String year;
		private int date;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
                	id = itr.nextToken(); 
        		    year = itr.nextToken().substring(0, 4);
        		    date =Integer.parseInt(itr.nextToken().substring(0, 2));
        		    break;
                }
                context.write(new Text(id + "+" + year), new IntWritable(date));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, IntWritable, Text, Text> {
		public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			System.out.println("111");
            int count1 = 0;
            int count2 = 0;
            for (IntWritable val : values) {
            	int date = val.get();
            	if(date>=21 && date<23) {
            		++count1;
            	}
            	if(date>=23) {
            		++count2;
            	}
            }
            if (count2 > 1)
            	System.out.println(count2);
            context.write(key, new Text(count1 + "+" +count2));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job(conf, "StudentBack");  
		job.setJarByClass(StudentBack.class);  
		job.setMapperClass(WordMapper.class);  
		//job.setCombinerClass(WordReducer.class);  
		job.setReducerClass(WordReducer.class); 
		job.setMapOutputValueClass(IntWritable.class);
		job.setMapOutputKeyClass(Text.class);
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(Text.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}