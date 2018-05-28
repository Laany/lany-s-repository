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

public class BookCount{
	public static class WordMapper extends Mapper<Object, Text, Text, IntWritable> {
		private String id;    //学号
		private String name;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) {  
            		id = itr.nextToken();
            		name = itr.nextToken();
            		break;
                }
            	context.write(new Text(id+name), new IntWritable(1));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int sum = 0;
			System.out.println("aaaaa");
			try {
	            for (IntWritable val : values) {
	            	sum += val.get();
	            }
			} catch (Exception e) {
				// TODO: handle exception
			}
            context.write(key, new IntWritable(sum));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(BookCount.class);  
		job.setMapperClass(WordMapper.class);   
		job.setReducerClass(WordReducer.class); 
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);  
		job.setOutputValueClass(IntWritable.class);  
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
		System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}  
}