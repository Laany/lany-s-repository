package org.apache.hadoop.examples;

import java.io.IOException;  
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.examples.CountAverage.WordMapper;
import org.apache.hadoop.examples.CountAverage.WordReducer;
import org.apache.hadoop.fs.FileSystem;  
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
  
public class YeSun {  
	  
    public static class WordMapper extends  
            Mapper<Object, Text, Text, Text> {  
  
    	private String child;
        private String parent;
  
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {  
        	child = value.toString().split(" ")[0];  
            parent = value.toString().split(" ")[1];  
            context.write(new Text(child), new Text("-" + parent));  
            context.write(new Text(parent), new Text("+" + child));
            }    
    }  
  
    public static class WordReducer extends  
            Reducer<Text, Text, Text, Text> {  
  
        public void reduce(Text key, Iterable<Text> values,  
                Context context) throws IOException, InterruptedException {  
        	ArrayList<Text> grandparent = new ArrayList<Text>();  
            ArrayList<Text> grandchild = new ArrayList<Text>();  
            for (Text t : values) {
                String s = t.toString();  
                if (s.startsWith("-")) {  
                    grandparent.add(new Text(s.substring(1)));  
                } else {  
                    grandchild.add(new Text(s.substring(1)));  
                }  
            }    
            for (int i = 0; i < grandchild.size(); i++) {  
                for (int j = 0; j < grandparent.size(); j++) {  
                    context.write(grandchild.get(i), grandparent.get(j));  
                }  
            }    
        }  
    }  
  
    public static void main(String[] args) throws Exception {  
        Configuration conf = new Configuration();  
        String[] otherArgs = new GenericOptionsParser(conf, args)  
                .getRemainingArgs();  
//        if (otherArgs.length != 2) {  
//            System.err.println("Usage: wordcount <in> <out>");  
//            System.exit(2);  
//        }  
        Job job = new Job();  
        job.setJarByClass(YeSun.class);  
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