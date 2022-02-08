package cn.xiaodong.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * kafka消费者
 *
 * @author: xiaodong
 * @create: 2021-07-21 07:30
 **/
public class Consumer {

    public static void main(String[] args) {
        // 1.实例化consumer
        // 集群连接配置
        Properties properties = new Properties();

        // 从配置文件中，加载Kafka集群配置
        try {
            properties.load(Producer.class.getResourceAsStream("/kafka_consumer1.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 设置订阅的topic
        consumer.subscribe(Arrays.asList("first"));

        // 2.接收消息

        while (true) {
            // 拉取数据
            ConsumerRecords<String, String> records = consumer.poll(2000);
            // 将拉取的数据遍历输出
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }

            // 如果本次没有拉到数据，退出循环
            if (records.isEmpty()) {
                break;
            }
        }

        // 3.关闭资源
        consumer.close();
    }


}
