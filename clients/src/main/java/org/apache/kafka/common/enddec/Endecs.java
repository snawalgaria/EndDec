package org.apache.kafka.common.enddec;

import java.util.Map;

public class Endecs {

    static protected class WrapperEndecs<T> implements Endec<T> {
        final private Encryptor<T> encryptor;
        final private Decryptor<T> decryptor;

        public WrapperEndecs(Encryptor<T> encryptor, Decryptor<T> decryptor) {
            this.encryptor = encryptor;
            this.decryptor = decryptor;
        }

        @Override
        public Encryptor<T> encryptor() {
            return encryptor;
        }

        @Override
        public Decryptor<T> decryptor() {
            return decryptor;
        }

        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
            encryptor.configure(configs, isKey);
            decryptor.configure(configs, isKey);

        }

        @Override
        public Serializer<T> serializer() {
            return null;
        }

        @Override
        public Deserializer<T> deserializer() {
            return null;
        }

        @Override
        public void close() {
            encryptor.close();
            decryptor.close();
        }
    }

    static public final class StringEndec extends WrapperEndecs<String> {
        public StringEndec() {
            super(new StringEncryptor(), new StringDecryptor());
        }
    }

    static public <T> Endec<T> endecFrom(final Encryptor<T> encryptor, final Decryptor<T> decryptor) {
        if(encryptor == null) {
            throw new IllegalArgumentException("encryptor must not be null");
        }
        if(decryptor == null) {
            throw new IllegalArgumentException("decryptor must not be null");
        }

        return new WrapperEndecs<>(encryptor, decryptor);
    }

    static public Endec<String> String() {
        return  new StringEndec();
    }


}
