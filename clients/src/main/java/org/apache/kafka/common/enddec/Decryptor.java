package org.apache.kafka.common.enddec;
/*
An Interface to Decrypt and Deserialize
*/

public interface Decryptor<T> extends Deserializer<T> {

    byte[] decrypt(byte[] data);

}
