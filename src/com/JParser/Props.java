package com.JParser;

import java.util.Properties;

public class Props {
    private static Properties props = new Properties();
    private static final String defString = "NO";
    private Props() {}
    public static void initProps(){
        props.setProperty("version","0.0.1");
        props.setProperty("input",defString);
    }
    public static boolean isDefault(String str){
        return defString.equals(str);
    }
    public static void addProp(String key,String val){
        props.setProperty(key,val);
    }
}
