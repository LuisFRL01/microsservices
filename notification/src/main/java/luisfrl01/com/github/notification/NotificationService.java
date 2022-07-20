package luisfrl01.com.github.notification;

import luisfrl01.com.github.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void send(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerEmail())
                .sender("Microservice")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
    }
}
