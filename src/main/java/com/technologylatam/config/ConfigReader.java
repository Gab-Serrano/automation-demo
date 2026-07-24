package com.technologylatam.config;

import com.technologylatam.exception.ConfigPropertiesException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties prop = new Properties();
    private static final ConfigReader INSTANCE = new ConfigReader();

    private ConfigReader() {
        loadProperties();
    }

    private void loadProperties() {

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new ConfigPropertiesException("No se encontró ningún archivo config.properties.");
            }

            prop.load(input);

        } catch (IOException | ConfigPropertiesException ex) {
            throw new ConfigPropertiesException("Error al cargar archivo config.properties", ex);
        }
    }

    public static ConfigReader getInstance() {
        return INSTANCE;
    }

    public static String getBrowser() {
        return prop.getProperty(ConfigParams.BROWSER);
    }

}
