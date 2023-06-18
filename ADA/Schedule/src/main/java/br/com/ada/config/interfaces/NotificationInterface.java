package br.com.ada.config.interfaces;

@FunctionalInterface
public interface NotificationInterface<T> {

    void sendNotification(T t);
}
