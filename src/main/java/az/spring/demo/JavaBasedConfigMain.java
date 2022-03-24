package az.spring.demo;

import az.spring.demo.config.AppConfig;
import az.spring.demo.message.Notification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfigMain {


    public static void main(String[] args) {

        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(AppConfig.class);
        Notification notification1 = applicationContext1.getBean("notificationEmail",Notification.class);
        notification1.alert();

    }
}
