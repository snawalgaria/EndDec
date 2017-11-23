package org.apache.kafka.common.enddec;

public interface Endec<T> extends Serde<T> {

    Encryptor<T> encryptor();

    Decryptor<T> decryptor();
}
