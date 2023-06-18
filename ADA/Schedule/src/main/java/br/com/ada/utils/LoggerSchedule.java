package br.com.ada.utils;

public class LoggerSchedule {

    public static <T> void log(T message){
        System.out.println("Applicarion [LOG] " + message.toString());
    }
}
