package gym.customers;

import gym.sessions.SessionType;

import java.util.List;

public class Instructor extends Person {
    private final double hourlySalary;
    private final List<SessionType> qualifiedSessions;

    public Instructor(Person person, double hourlySalary, List<SessionType> qualifiedSessions) {
        super(person.getName(), person.getBalance(), person.getGender(), person.getBirthDate().toString());
        this.hourlySalary = hourlySalary;
        this.qualifiedSessions = qualifiedSessions;
    }

    public boolean isQualifiedFor(SessionType type) {
        return qualifiedSessions.contains(type);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Role: Instructor | Salary per Hour: %.2f | Certified Classes: %s",
                hourlySalary, qualifiedSessions);
    }

    public double getHourlySalary() {
        return hourlySalary;
    }
}
