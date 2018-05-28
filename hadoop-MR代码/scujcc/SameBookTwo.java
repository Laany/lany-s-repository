package scujcc;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class SameBookTwo{
	static Test2 tt = new Test2();
	
	public static class WordMapper extends Mapper<Object, Text, Text, Text> {
		private String id;    //学号
		private String stuname;  //学生名字
		private String bookname;  //书名
		private String samestudent; //相同学生
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();  
            StringTokenizer itr = new StringTokenizer(line, "\t");
            try {
            	while (itr.hasMoreTokens()) { 
            		id = itr.nextToken();
            		stuname = itr.nextToken();
            		bookname = itr.nextToken();
            		samestudent = itr.nextToken();
                }
            	
            	if (!samestudent.equals("")) {
            		String s[] = samestudent.split(",");
            		
            		for (int i=0; i<s.length; ++i) {
            			if (!s[i].equals("")) { 
            				context.write(new Text(id + "\t" + stuname + "\t" + s[i]), new Text(bookname));
            			}
            		}
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}    
	}  
	
	public static class WordReducer extends Reducer<Text, Text, Text, Text> {
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			String samestudent = new String(key.getBytes(), 0, key.getLength());
			String s[] = samestudent.split("\t");
			String id = s[0];
			String stuname1 = s[1];
			String stuname2 = s[2];
			
			double sum = tt.getCount(id);
			int count = 0;
			double qihedu = 0;
			String str = "";
			for (Text val : values)
			{
				String bookname = new String(val.getBytes(), 0, val.getLength());
				str = str + "-" +bookname;
				++count;
			}
			
			DecimalFormat df = new DecimalFormat("0.00%");
			qihedu = count/sum;
			
			str = stuname2 + "-" +df.format(qihedu) + str;
			context.write(new Text(stuname1), new Text(str));
		}  
	}  
	
	public static void main(String[] args) throws Exception {  
		Configuration conf = new Configuration();  
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();   
		Job job = new Job();  
		job.setJarByClass(SameBookTwo.class);  
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