package luisfrl01.com.github.customer;

import luisfrl01.com.github.amqp.RabbitMQMessageProducer;
import luisfrl01.com.github.clients.fraud.FraudCheckResponse;
import luisfrl01.com.github.clients.fraud.FraudClient;
import luisfrl01.com.github.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if( response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                String.format("Hi %s, welcome.", customer.getFirstName()),
                customer.getEmail(),
                customer.getId()
        );

        producer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
