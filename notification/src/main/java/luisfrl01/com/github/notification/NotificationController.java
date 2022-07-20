package luisfrl01.com.github.notification;

import lombok.extern.slf4j.Slf4j;
import luisfrl01.com.github.clients.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public void registerNotification(@RequestBody NotificationRequest request) {
        log.info("new notification {}", request);
        notificationService.send(request);
    }
}
