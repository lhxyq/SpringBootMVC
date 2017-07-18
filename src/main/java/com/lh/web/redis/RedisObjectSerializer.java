package com.lh.web.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by LH 2446059046@qq.com on 2017/7/18.
 */
public class RedisObjectSerializer implements RedisSerializer{
    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deSerializer = new DeserializingConverter();
    public static final byte[] EMPY_ARRY = new byte[0];

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (null == object)
            return EMPY_ARRY;
        return serializer.convert(object);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes))
            return null;
        return deSerializer.convert(bytes);
    }

    private boolean isEmpty(byte[] bytes) {
        return  null == bytes || 0 == bytes.length;
    }
}
