package gym.sessions;

import gym.customers.Instructor;

public class SessionFactory {
    public static Session createSession(SessionType type, String dateTime, ForumType forum, Instructor instructor) {
        return switch (type) {
            case Pilates -> new PilatesSession(dateTime, forum, instructor);
            case MachinePilates -> new MachinePilatesSession(dateTime, forum, instructor);
            case ThaiBoxing -> new ThaiBoxingSession(dateTime, forum, instructor);
            case Ninja -> new NinjaSession(dateTime, forum, instructor);
        };
    }
}
