package org.apache.kafka.common.enddec;
import org.apache.kafka.common.serialization.Serializer;
/**
 * An Interface to Serialize and Encrypt
 */
public interface Encryptor<T> extends Serializer<T> {

    Byte[] encrypt(T data);
}
