package az.spring.demo.message;

import az.spring.demo.message.Message;

public class Sms implements Message {

    @Override
    public void send(){
        System.out.println("Sms was sent successfully");
    }
}
