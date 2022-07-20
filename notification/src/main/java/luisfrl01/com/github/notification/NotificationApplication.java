package luisfrl01.com.github.notification;

import luisfrl01.com.github.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"luisfrl01.com.github.notification", "luisfrl01.com.github.amqp"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "luisfrl01.com.github.clients")
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig config) {
//        return args -> {
//            producer.publish("foo", config.getInternalExchange(),
//                    config.getInternalNotificationRoutingKeyExchange());
//        };
//    }
}
