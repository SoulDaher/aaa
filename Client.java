package gym.customers;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    private final List<String> notifications;
    private boolean isBlocked;

    public Client(Person person) {
        super(person.getName(), person.getBalance(), person.getGender(), person.getBirthDate().toString());
        this.notifications = new ArrayList<>();
        this.isBlocked = false;
    }

    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }


    public void addNotification(String message) {
        notifications.add(message);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
