package gym.sessions;

import gym.customers.Instructor;

public class NinjaSession extends Session {
    public NinjaSession(String dateTime, ForumType forum, Instructor instructor) {
        super(SessionType.Ninja, dateTime, forum, instructor);
    }
}
