package gym.management;

import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.Person;
import gym.Exception.*;
import gym.sessions.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Secretary extends Person {
    private final List<Client> clients = new ArrayList<>();
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Session> sessions = new ArrayList<>();
    private final List<String> actionHistory = new ArrayList<>();

    public Secretary(Person person, double salary) {
        super(person.getName(), person.getBalance(), person.getGender(),
                person.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }


    public Client registerClient(Person person) throws DuplicateClientException, InvalidAgeException {
        if (clients.contains(person.getName())) {
            throw new DuplicateClientException("The client is already registered.");
        }

        if (person.getAge() < 18) {
            throw new InvalidAgeException("Error: Client must be at least 18 years old to register.");
        }
        Client client = new Client(person);
        clients.add(client);
        logAction("Registered new client: " + client.getName());
        return client;
    }

    public void unregisterClient(Client client) throws ClientNotRegisteredException {

        if (!clients.contains(client)) {
            throw new ClientNotRegisteredException("Error: Client is not registered with the gym and cannot be unregistered.");
        }
        client.setBlocked(true);
        logAction("Unregistered client: " + client.getName());
    }

    public Instructor hireInstructor(Person person, double hourlySalary, List<SessionType> qualifiedSessions) {
        Instructor instructor = new Instructor(person, hourlySalary, qualifiedSessions);
        instructors.add(instructor);
        logAction("Hired new instructor: " + instructor.getName() + " with salary per hour: " + hourlySalary);
        return instructor;
    }


    public Session addSession(SessionType type, String dateTime, ForumType forum, Instructor instructor) throws InstructorNotQualifiedException {

        if (!instructor.isQualifiedFor(type)) {
            throw new InstructorNotQualifiedException("Error: Instructor is not qualified to conduct this session type.");
        }
        Session session = SessionFactory.createSession(type, dateTime, forum, instructor);
        sessions.add(session);
        logAction("Created new session: " + type + " on " + dateTime + " with instructor: " + instructor.getName());
        return session;
    }

    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException {

        if (!clients.contains(client)) {
            throw new ClientNotRegisteredException("Error: Client is not registered with the gym and cannot enroll in lessons.");
        }

        if (session.getParticipants().contains(client.getName())) {
            throw new DuplicateClientException("Error: The client is already registered for this lesson.");
        }

        if (!session.addParticipant(client)) {
            System.out.println("No available spots for session " + session.getType());
        } else {
            logAction("Registered client: " + client.getName() + " to session: " + session.getType() + " on " + session.getDateTime());
        }
    }

    public void notify(Session session, String message) {
        for (Client client : session.getParticipants()) {
            client.addNotification(message);
        }
        logAction("Notification sent for session " + session.getType() + ": " + message);
    }


    public void notify(String message) {
        for (Client client : clients) {
            client.addNotification(message);
        }
        logAction("Notification sent to all clients: " + message);
    }


    public void notify(String date, String message) {
        for (Client client : clients) {
            client.addNotification(message);
        }
        logAction("Notification sent for date " + date + ": " + message);
    }


    public void paySalaries() {
        for (Instructor instructor : instructors) {
            double salary = instructor.getHourlySalary();
            System.out.println("Paying salary to instructor: " + instructor.getName() + " | Amount: " + salary);
            instructor.deductBalance(salary);
        }
    }

    private void logAction(String action) {
        actionHistory.add(action);
    }

    public void printActions() {
        for (String action : actionHistory) {
            System.out.println(action);
        }
    }
}