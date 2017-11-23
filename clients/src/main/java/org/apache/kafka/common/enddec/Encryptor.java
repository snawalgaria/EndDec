package org.apache.kafka.common.enddec;
/**
 * An Interface to Serialize and Encrypt
 */
public interface Encryptor<T> extends Serializer<T> {

    byte[] encrypt(String topic,byte[] data);
}
