package com.sp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readProperties {
    public static String readPro(String prop,String file)throws IOException{
        String baseur=System.getProperty("user.dir")+"/prop/";
        FileInputStream files = new FileInputStream(baseur+file+".properties");
        Properties properties = new Properties();
        properties.load(files);
        String  param = properties.getProperty(prop);
        return param;

    }
}
