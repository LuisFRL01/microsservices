package luisfrl01.com.github.clients.notification;

public record NotificationRequest(String message, String toCustomerEmail, Integer toCustomerId) {
}
