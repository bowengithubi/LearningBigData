package cn.xiaodong.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Kafka消息生产者
 *
 * @author: xiaodong
 * @create: 2021-07-21 05:58
 **/
public class Producer {

    public static void main(String[] args) {

        // step 1. 实例化Kafka集群

        // 集群连接配置
        Properties properties = new Properties();

        // 从配置文件中，加载Kafka集群配置
        try {
            properties.load(Producer.class.getResourceAsStream("/kafka.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


//        // 设置集群配置（方式一：直接设置）
//        // 序列化处理类
//        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        // ack级别
//        properties.setProperty("acks", "all");
//        // kafka集群连接地址
//        properties.setProperty("bootstrap.servers", "hadoop102:9092");

        // 使用集群配置，连接kafka集群
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        // step 2. 发送消息
        for (int i = 0; i < 10; i++) {
            // 调用集群发送数据
            Future<RecordMetadata> future = kafkaProducer.send(
                    // 封装Recorder
                    new ProducerRecord<>("first", i + "", "value" + i), new Callback() {
                        // 发送成功后回调函数
                        @Override
                        public void onCompletion(RecordMetadata metadata, Exception exception) {
                            System.out.println(metadata);
                        }
                    });

//            try {
//                // 同步消息发送
//                // 获取Kafka发送数据后，返回的信息
//                // 因为kafka是异步操作，发送一条后，等待获取返回信息，会使kafka变成同步操作
//                RecordMetadata recordMetadata = future.get();
//                System.out.println("recordMetadata" + recordMetadata);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }

            System.out.println("发送第" + i + "条数据，调用完毕！");
        }


        // step 3. 关闭资源
        kafkaProducer.close();
    }
}
