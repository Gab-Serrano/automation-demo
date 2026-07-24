package com.technologylatam.provider;

import com.technologylatam.config.ConfigManager;
import com.technologylatam.config.ConfigParams;
import com.technologylatam.model.CartCheckout;
import com.technologylatam.model.User;
import com.technologylatam.utils.JsonReader;
import org.testng.annotations.DataProvider;

public final class DataProviders {

    private static final String USERDATAFILE = ConfigManager.getProperty(ConfigParams.USERDATAFILE);
    private static final String CARTDATAFILE = ConfigManager.getProperty(ConfigParams.CARTDATAFILE);
    private static final String HOMEDATAFILE = ConfigManager.getProperty(ConfigParams.HOMEDATAFILE);

    @DataProvider(name = "userData")
    public static Object[][] userData(){

        User[] data = JsonReader.read(USERDATAFILE, User[].class);

        Object[][] result = new Object[data.length][1];

        for (int i = 0; i < data.length; i++){
            result[i][0] = data[i];
        }

        return result;
    }

    @DataProvider(name = "cartData")
    public static Object[][] cartData(){

        CartCheckout[] data = JsonReader.read(CARTDATAFILE, CartCheckout[].class);

        Object[][] result = new Object[data.length][1];

        for (int i = 0; i < data.length; i++){
            result[i][0] = data[i];
        }

        return result;
    }

    @DataProvider(name = "homeData")
    public static Object[][] homeData(){

        User[] data = JsonReader.read(HOMEDATAFILE, User[].class);

        Object[][] result = new Object[data.length][1];

        for (int i = 0; i < data.length; i++){
            result[i][0] = data[i];
        }

        return result;
    }
}
