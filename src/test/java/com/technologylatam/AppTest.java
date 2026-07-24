package com.technologylatam;

import com.technologylatam.model.Cart;
import com.technologylatam.provider.DataProviders;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest {

    public static void main(String[] args) {


        for (int i = 0; i < DataProviders.cartData().length; i++){
            for (int j = 0; j < DataProviders.cartData()[i].length; j++){
                log.info("Data: {}, {}", ((Cart) DataProviders.cartData()[i][j]).getUser(), ((Cart) DataProviders.cartData()[i][j]).getItem());
            }
        }

    }
}
