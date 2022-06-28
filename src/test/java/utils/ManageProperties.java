package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ManageProperties {

    public static TestProperties loadProperties() {
        var mapper = new ObjectMapper(new YAMLFactory());
            File file= new File("src/test/resources/properties/test-properties.yml");

        try {
            return mapper.readValue(file, TestProperties.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

