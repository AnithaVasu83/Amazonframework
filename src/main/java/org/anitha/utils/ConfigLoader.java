package org.anitha.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private  Properties props;

    public ConfigLoader() {

        try {

            props=new Properties();
            InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to find the file", e);
        }
    }

        public String get(String key){
       {
            return props.getProperty(key);

        }


    }


}
