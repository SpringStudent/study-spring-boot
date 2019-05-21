package ning.zhou.study.springboot.studyspringboot.tool;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import static com.mysql.jdbc.Constants.EMPTY_BYTE_ARRAY;
import static org.apache.commons.lang.ArrayUtils.isEmpty;
import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * @author 周宁
 * @Date 2019-05-17 9:41
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object, byte[]> serializer = new SerializingConverter();

    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (object == null) {
            return EMPTY_BYTE_ARRAY;
        }
        return serializer.convert(object);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        return deserializer.convert(bytes);
    }
}
