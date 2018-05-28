package org.apache.hadoop.examples;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;

import org.apache.hadoop.classification.InterfaceAudience.Private;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.examples.StudentBack.WordMapper;
import org.apache.hadoop.examples.StudentBack.WordReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.hamcrest.core.SubstringMatcher;

import com.sun.java.swing.plaf.windows.DesktopProperty;

public class StudentCost{
	public static class WordMapper extends Mapper<Object, Text, Text, DoubleWritable> {
		private String id;    //学号
		private String year;  //年月
		private String mount; //余额
		private double cost;  //花费
		private String type;  //操作类型
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
            		year = itr.nextToken().substring(0, 4);
            		mount = itr.nextToken();
            		cost = Double.parseDouble(itr.nextToken());
                	id = itr.nextToken();
        		    type =itr.nextToken().substring(0,4);
        		    System.out.println(type);
                }
            	System.out.println("1111");
            	
            	if (type.equals("联网售饭") || type.equals("可能消费") || type.equals("商场消费") || type.equals("图书收费") || 
            			type.equals("医疗收费") || type.equals("独立售饭") || type.equals("独立商场") ||type.equals("独立图书") || 
            			type.equals("独立医疗")) {
            		System.out.println("444444");
            		context.write(new Text(id + "+" + year), new DoubleWritable(cost));
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
		public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
			System.out.println("111");
			double sum = 0;
            for (DoubleWritable val : values) {
            	double data = val.get();
                sum = sum + data;
            }
            context.write(key, new DoubleWritable(sum));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job(conf, "StudentCost");  
		job.setJarByClass(StudentCost.class);  
		job.setMapperClass(WordMapper.class);  
		//job.setCombinerClass(WordReducer.class);  
		job.setReducerClass(WordReducer.class); 
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DoubleWritable.class);
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(DoubleWritable.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}