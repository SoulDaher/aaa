package gym.sessions;

import gym.customers.Instructor;

public class ThaiBoxingSession extends Session {
    public ThaiBoxingSession(String dateTime, ForumType forum, Instructor instructor) {
        super(SessionType.ThaiBoxing, dateTime, forum, instructor);
    }
}
