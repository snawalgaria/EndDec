package org.apache.kafka.common.enddec;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class StringEncryptor extends StringSerializer implements Encryptor<String> {
    Logger log=LoggerFactory.getLogger(StringEncryptor.class);
    @Override
    public byte[] serialize(String topic, String data) {
        try {


            byte[] serialized = super.serialize(topic, data);
            byte[] encrypted = encrypt(topic, serialized);

            return encrypted;
        }
        catch(NullPointerException exe) {
         log.error("Encountered Null pointer exception "+exe.getMessage());
         byte[] sample ="Hello".getBytes();
         return  sample;
        }

    }

    @Override
    public byte[] encrypt(String topic, byte[] serialized) {

        for(int i=0;i<serialized.length;i++)
        {
            serialized[i]=(byte)(serialized[i]+2);
        }
        return serialized;
    }
}
