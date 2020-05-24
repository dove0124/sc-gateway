package cn.springcloud.book.util.converter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConverter {

    public static <T> T convertJsonStrToObject(String jsonStr, TypeReference<T> targetType) {
        T object = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            object = mapper.readValue(jsonStr, targetType);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static <T> String convertJsonObjectToStr(T jsonObject) {
        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonStr = mapper.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
