package cn.xiaodong.kafka;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka手动提交Offset
 *
 * @author: xiaodong
 * @create: 2021-08-23 05:05
 **/
public class ConsumerManusal {

    /**
     * offset进度记录
     */
    private static Map<TopicPartition, Long> offset = new HashMap<TopicPartition, Long>();

    /**
     * consumer消费的分区
     */
    private static Collection<TopicPartition> assignedPartitions = new ArrayList<TopicPartition>();

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

        // 2.订阅话题
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 设置订阅的topic
        consumer.subscribe(Arrays.asList("first"), new ConsumerRebalanceListener() {
            // 分区分配之前做的事（当consumer Group中的消费者发生变化，会进行分区的重新分配）
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                // 提交旧的offset
                commitOffset(partitions);
            }

            // 分区分配之后做的事（当consumer Group中的消费者发生变化，会进行分区的重新分配）
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
                // 获取新的offset
                readOffset();
                assignedPartitions = partitions;
                for (Iterator<TopicPartition> iterator = partitions.iterator(); iterator.hasNext(); ) {
                    TopicPartition partition = iterator.next();
                    Long offsetKey = offset.get(partition);
                    if (offsetKey == null) {
                        consumer.seek(partition, 0);
                    } else {
                        consumer.seek(partition, offsetKey);
                    }
                }
            }
        });

        // 2.接收消息
        while (true) {
            // 拉取数据
            ConsumerRecords<String, String> records = consumer.poll(2000);

            // 将数据消费与offset提交，进行原子化绑定
            try {
                // 将拉取的数据遍历输出（进行消费操作）
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                }

                commitOffset(assignedPartitions);
            } catch (Exception e) {

            }

            // 设置退出循环
            Boolean isBreak = false;
            if (isBreak) {
                break;
            }
        }

        // 3.关闭资源
        consumer.close();
    }

    /**
     * 将缓存中的offset提交到自定义介质中
     */
    private static void commitOffset(Collection<TopicPartition> assinedPartitions) {

    }

    /**
     * 从自定义介质中，获取Offset
     */
    private static void readOffset() {

    }

}
