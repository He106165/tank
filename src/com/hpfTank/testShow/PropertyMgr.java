package com.hpfTank.testShow;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties properties=new Properties();
    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  Object get (String key){
        if(key==null) return null;
        return  properties.get(key);
    }
    public static  Integer getInt (String key){
        if(key==null) return null;
        return  Integer.valueOf(properties.get(key).toString());
    }

    public static  void main(String[] args){
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
