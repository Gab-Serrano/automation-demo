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

    public static String getBaseUrl(){
        return prop.getProperty(ConfigParams.BASE_URL);
    }

    public static String getImplicitWait(){
        return prop.getProperty(ConfigParams.IMPLICIT_WAIT);
    }

    public static String getExplicitWait(){
        return prop.getProperty(ConfigParams.EXPLICIT_WAIT);
    }

    public static Boolean isHeadless(){
        return Boolean.valueOf(prop.getProperty(ConfigParams.HEADLESS));
    }

    public static String getProperty(String property){
        return prop.getProperty(property, null);
    }

}
