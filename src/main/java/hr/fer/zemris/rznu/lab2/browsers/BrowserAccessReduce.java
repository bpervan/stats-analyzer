package hr.fer.zemris.rznu.lab2.browsers;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Branimir on 16.1.2015..
 */
public class BrowserAccessReduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    public void reduce(Text text,
                       Iterator<IntWritable> intWritableIterator,
                       OutputCollector<Text, IntWritable> textIntWritableOutputCollector,
                       Reporter reporter) throws IOException {

        int counter = 0;
        while(intWritableIterator.hasNext()){
            intWritableIterator.next();
            counter++;
        }

        textIntWritableOutputCollector.collect(text, new IntWritable(counter));
    }
}
