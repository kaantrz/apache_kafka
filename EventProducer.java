import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        Producer<String, byte[]> producer = new KafkaProducer<>(props);

        try {
            // creates sample object
            Data data = new Data(1, "Hello Kafka!");

            // serializes the object
            byte[] serializedData = SerializationUtils.serialize(data);

            // publishes the object to Kafka
            ProducerRecord<String, byte[]> record = new ProducerRecord<>("test-topic", serializedData);
            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Message sent successfully: " + metadata.topic() + ", partition " + metadata.partition() + ", offset " + metadata.offset());
                } else {
                    exception.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
