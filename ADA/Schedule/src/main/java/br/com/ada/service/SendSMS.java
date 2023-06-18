package br.com.ada.service;

import br.com.ada.config.interfaces.NotificationInterface;

public class SendSMS implements NotificationInterface<Integer> {

    @Override
    public void sendNotification(Integer numero) {
        //LOGICA DO ENVIO DE SMS
        System.out.println("enviando sms de item novo adicionado para " + numero);
    }
}
