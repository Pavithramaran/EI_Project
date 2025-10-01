public class Main {
    public static void main(String[] args) {
        Notification email = NotificationFactory.createNotification("email");
        email.notifyUser();

        Notification sms = NotificationFactory.createNotification("sms");
        sms.notifyUser();

        Notification push = NotificationFactory.createNotification("push");
        push.notifyUser();
    }
}
