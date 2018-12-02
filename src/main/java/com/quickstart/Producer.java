package com.quickstart;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * Producer ：用于将消息发送到消息队列
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group");
        producer.setNamesrvAddr("192.168.119.128:9876");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message msg = new Message("orders", ("orders" + i).getBytes());
            SendResult result = producer.send(msg);
            System.out.println(result);
            System.out.println(msg + "send out");
            Thread.sleep(500);
        }

        producer.shutdown();
    }
}
