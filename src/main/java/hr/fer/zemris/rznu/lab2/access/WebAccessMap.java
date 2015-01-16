package hr.fer.zemris.rznu.lab2.access;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Branimir on 16.1.2015..
 */
public class WebAccessMap extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable longWritable,
                    Text text,
                    OutputCollector<Text, IntWritable> textIntWritableOutputCollector,
                    Reporter reporter) throws IOException {

    }
}
