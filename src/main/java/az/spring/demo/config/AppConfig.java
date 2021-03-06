package az.spring.demo.config;


import az.spring.demo.message.Message;
import az.spring.demo.message.Notification;
import az.spring.demo.message.Sms;
import az.spring.demo.message.Email;
import az.spring.demo.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean("message-sms")
    public Message getSms() {
        return new Sms();
    }

    @Bean("message-email")
    public Message getEmail(){
        return new Email();
    }

    @Bean
    public Employee getEmployee(){
        return new Employee();
    }

    @Bean(name = "notificationEmail")
    @Scope("singleton")
    public Notification getNotificationEmail(@Qualifier("message-email") Message message, Employee employee){

        Notification notification = new Notification();
        notification.setEmployee(employee);
        notification.setMessage(message);
        return notification;
    }


    @Bean(name = "notificationSms")
    @Scope("prototype")
    public Notification getNotificationSms(){

        Notification notification = new Notification();
        notification.setEmployee(getEmployee());
        notification.setMessage(getSms());
        return notification;
    }
}
