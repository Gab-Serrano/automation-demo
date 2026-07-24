package com.technologylatam.config;

import com.technologylatam.exception.ConfigPropertiesException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {

    private static final Properties prop = new Properties();
    private static final ConfigManager INSTANCE = new ConfigManager();

    private ConfigManager() {
        loadProperties();
    }

    private void loadProperties() {

        try (InputStream input = ConfigManager.class
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

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    public static String getBrowser() {
        String browser = ConfigParams.BROWSER;
        return System.getProperty(browser, prop.getProperty(browser));
    }

    public static String getBaseUrl(){
        String baseUrl = ConfigParams.BASE_URL;
        return System.getProperty(baseUrl, prop.getProperty(baseUrl));
    }

    public static String getExplicitWait(){
        String explicitWait = ConfigParams.EXPLICIT_WAIT;
        return System.getProperty(explicitWait, prop.getProperty(explicitWait));
    }

    public static Boolean isHeadless(){
        String headless = ConfigParams.HEADLESS;
        return Boolean.parseBoolean(System.getProperty(headless, prop.getProperty(headless, "false")));
    }

    public static String getProperty(String property){
        return System.getProperty(property, prop.getProperty(property, null));
    }

    public static boolean isIncognito() {
        String incognito = ConfigParams.INCOGNITO;
        return Boolean.parseBoolean(System.getProperty(incognito, prop.getProperty(incognito, incognito)));
    }

}
