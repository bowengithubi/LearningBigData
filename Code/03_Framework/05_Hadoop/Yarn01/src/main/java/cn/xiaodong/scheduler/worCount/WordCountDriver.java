package cn.xiaodong.scheduler.worCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.io.compress.SnappyCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @description:  测试mapreduce压缩
 * @author: xiaodong
 * @create: 2021-02-16 11:35
 **/
public class WordCountDriver {

    /**
     * 设置任务属性
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws Exception {
        // 设置连接Hadoop的用户名
        System.setProperty("HADOOP_USER_NAME", "atguigu");

        // 0、系统设置
        Configuration configuration = new Configuration();

        // 数据源使用HDFS
        configuration.set("fs.defaultFS", "hdfs://hadoop102:8020");
        // 数据源使用本地磁盘
        // configuration.set("fs.defaultFS", "file:///");

        // 此处写local表示程序在本地上运行，可以进行断点调试
//        configuration.set("mapreduce.framework.name", "local");
        // 此处写yarn表示程序在集群上运行，yarn负责调度，无法进行断点调试
         configuration.set("mapreduce.framework.name","yarn");

        configuration.set("mapreduce.app-submission.cross-platform", "true");
        configuration.set("yarn.resourcemanager.hostname", "hadoop103");

        // 配置任务队列
        configuration.set("mapred.job.queue.name","hive");

        // 1.获取Job
        Job job = Job.getInstance(configuration);

        // 2.设置driver类、map类、reduce类
//        job.setJarByClass(WordCountDriver.class);
        job.setJar("D:\\Code\\LearningBigData\\Code\\03_Framework\\05_Hadoop\\Yarn01\\target\\Yarn01-1.0-SNAPSHOT.jar");

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 合并策略
        job.setCombinerClass(WordCountReducer.class);

        // 3.设置map、reduce的输出
        // mapper的输出格式
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        // reducer的输出格式
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 4、设置文件输入输出路径
        // hadoop可以自动识别输入文件是否是压缩文件，并自动进行解压
        FileInputFormat.setInputPaths(job, new Path("/txt/wordCount3.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/txt/wordCountOutput3"));

        // 5.任务提交
        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }
}
