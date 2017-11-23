package org.apache.kafka.common.enddec;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringDecryptor extends StringDeserializer implements Decryptor<String> {

    Logger log= LoggerFactory.getLogger(StringDecryptor.class);

    @Override
    public String deserialize(String topic, byte[] data) {
        try {
            //byte[] decrypted = decrypt(data);
            return super.deserialize(topic, data);
        }
        catch(NullPointerException exe) {
            log.error("Data inside decryptor is null"+exe.getMessage());
            return "Null Pointer";
        }
    }
    @Override
    public byte[] decrypt(byte[] data) {

        for(int i=0;i<data.length;i++) {
            data[i]=(byte) (data[i]-2);
        }
        return data;

    }
}
