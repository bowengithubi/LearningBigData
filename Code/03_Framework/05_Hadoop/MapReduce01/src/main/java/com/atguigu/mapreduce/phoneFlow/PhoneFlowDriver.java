package com.atguigu.mapreduce.phoneFlow;

import com.atguigu.mapreduce.wordCount.WordCountDriver;
import com.atguigu.mapreduce.wordCount.WordCountMapper;
import com.atguigu.mapreduce.wordCount.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @description: 任务驱动
 * @author: xiaodong
 * @create: 2021-02-16 18:02
 **/
public class PhoneFlowDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 0、系统设置
        Configuration configuration = new Configuration();

        // 数据源使用HDFS
        configuration.set("fs.defaultFS", "hdfs://hadoop102:8020");
        // 数据源使用本地磁盘
        // configuration.set("fs.defaultFS", "file:///");

        // 此处写local表示程序在本地上运行，可以进行断点调试
        configuration.set("mapreduce.framework.name","local");
        // 此处写yarn表示程序在集群上运行，yarn负责调度
        // configuration.set("mapreduce.framework.name","yarn");

        configuration.set("mapreduce.app-submission.cross-platform","true");
        configuration.set("yarn.resourcemanager.hostname","hadoop103");

        // 1.获取Job
        Job job = Job.getInstance(configuration);

        // 2.设置driver类、map类、reduce类
        //job.setJarByClass(PhoneFlowDriver.class);
        job.setJar("D:\\LearningBigData\\Code\\03_Framework\\05_Hadoop\\MapReduce01\\target\\MapReduce01-1.0-SNAPSHOT.jar");

        job.setMapperClass(PhoneFlowMapper.class);
        job.setReducerClass(PhoneFlowReducer.class);

        // 3.设置map、reduce的输出
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowSum.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowSum.class);

        // 4、设置文件输入输出路径
        FileInputFormat.setInputPaths(job, new Path("/txt/phoneData.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/txt/phoneData"));

        // 5.任务提交
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
