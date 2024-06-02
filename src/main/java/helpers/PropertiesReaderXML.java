package helpers;

import interfaces.TestHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderXML implements TestHelper {
    public static String getProperty(String key,String path ){
        Properties properties = new Properties();
        try (FileInputStream fis=new FileInputStream(path)){
            properties.loadFromXML(fis);
            return properties.getProperty(key);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        PropertiesWriterXML propertiesWriterXML = new PropertiesWriterXML();

        propertiesWriterXML.setProperty("maxValue","3",false,TestHelper.XML_FILE_PATH);

        System.out.println("Value :"+getProperty("user1",XML_FILE_PATH));


    }

}
