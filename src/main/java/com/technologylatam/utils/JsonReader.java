package com.technologylatam.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technologylatam.config.ConfigManager;
import com.technologylatam.config.ConfigParams;
import com.technologylatam.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public final class JsonReader {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final String DATAFOLDER = ConfigManager.getProperty(ConfigParams.DATAFOLDER);

    private JsonReader(){}

    public static <T> T read(String dataFileName, Class<T> clazz){

        try(InputStream inputStream = JsonReader.class.getClassLoader()
                .getResourceAsStream(DATAFOLDER + dataFileName)){

            return MAPPER.readValue(inputStream, clazz);

        }catch (IOException ex){
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }
}
