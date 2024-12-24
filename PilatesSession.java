package gym.sessions;

import gym.customers.Instructor;

public class PilatesSession extends Session {
    public PilatesSession(String dateTime, ForumType forum, Instructor instructor) {
        super(SessionType.Pilates, dateTime, forum, instructor);
    }
}
