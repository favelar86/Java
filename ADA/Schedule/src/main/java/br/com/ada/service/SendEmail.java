package br.com.ada.service;

import br.com.ada.config.interfaces.NotificationInterface;

public class SendEmail implements NotificationInterface<String> {

    @Override
    public void sendNotification(String email) {
        //LOGICA DO ENVIO DE EMAIL
        System.out.println("enviando email de item novo adicionado para " + email);
    }
}
