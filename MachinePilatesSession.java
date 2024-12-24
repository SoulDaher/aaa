package gym.sessions;

import gym.customers.Instructor;

public class MachinePilatesSession extends Session {
    public MachinePilatesSession(String dateTime, ForumType forum, Instructor instructor) {
        super(SessionType.MachinePilates, dateTime, forum, instructor);
    }
}
