package gym.sessions;

import gym.customers.Client;
import gym.customers.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private final SessionType type;
    private final String dateTime;
    private final ForumType forum;
    private final Instructor instructor;
    private final List<Client> participants;
    private final int maxParticipants;

    public Session(SessionType type, String dateTime, ForumType forum, Instructor instructor) {
        this.type = type;
        this.dateTime = dateTime;
        this.forum = forum;
        this.instructor = instructor;
        this.participants = new ArrayList<>();
        this.maxParticipants = type.getMaxParticipants();
    }


    public SessionType getType() {
        return type;
    }

    public boolean addParticipant(Client client) {
        if (participants.size() < maxParticipants) {
            participants.add(client);
            return true;
        }
        return false;
    }

    public List<Client> getParticipants() {
        return participants;
    }

    public String getDateTime() {
        return dateTime;
    }


    @Override
    public String toString() {
        return String.format("Session Type: %s | Date: %s | Forum: %s | Instructor: %s | Participants: %d/%d",
                type, dateTime, forum, instructor.getName(), participants.size(), maxParticipants);
    }
}
