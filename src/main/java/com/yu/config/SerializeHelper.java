package com.yu.config;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SerializeHelper {

	private ObjectMapper objectMapper = new  ObjectMapper();
	public String toJson(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
	
	public <T>T toObject(String jsonString, Class<T> obj) {
		try {
			return objectMapper.readValue(jsonString, obj);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
