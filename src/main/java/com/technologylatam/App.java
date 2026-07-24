package com.technologylatam;

import com.technologylatam.config.ConfigReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        System.out.println(ConfigReader.getBrowser());
    }
}
