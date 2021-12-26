package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    // declare Properties obj at class level, so it can be accessible in static method
    private static Properties properties=new Properties();

    // we want to only load the file once, so we can use static block
    static {
        try {
            FileInputStream in = new FileInputStream("config.properties");
            properties.load(in);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // get the value of key according to the key provided
    public static String read(String key){
        return properties.getProperty(key);
    }





}