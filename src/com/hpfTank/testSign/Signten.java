package com.hpfTank.testSign;

public class Signten {

    private static volatile  Signten  signten;

    static{
        signten=new Signten();
    }

    private static class SigntenHolder{
        private final static  Signten SINGNTEN=new Signten();
    }

    private Signten(){};

    public static  Signten getSignten1(){
        if(signten==null){
            synchronized(Signten.class){
                if (signten==null){
                    return new Signten();
                }
            }
        }
        return signten;
    }

    public static synchronized  Signten getSignten2(){
        if(signten==null){
             return new Signten();
        }
        return signten;
    }

    public static Signten getSignten3(){
        return SigntenHolder.SINGNTEN;
    }
}
