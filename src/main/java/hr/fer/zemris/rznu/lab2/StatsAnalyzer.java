package hr.fer.zemris.rznu.lab2;

import hr.fer.zemris.rznu.lab2.access.WebAccessMap;
import hr.fer.zemris.rznu.lab2.access.WebAccessReduce;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileOutputFormat;

import java.io.IOException;

/**
 * Created by Branimir on 16.1.2015..
 */
public class StatsAnalyzer {
    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            System.out.println("Arguments?");
            System.exit(-1);
        }

        JobConf conf = new JobConf(StatsAnalyzer.class);
        conf.setJobName("Stats Analyzer");

        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        conf.setMapperClass(WebAccessMap.class);
        conf.setReducerClass(WebAccessReduce.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        JobClient.runJob(conf);
    }
}
