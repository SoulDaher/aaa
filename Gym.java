package gym.management;

import gym.customers.Client;
import gym.customers.Instructor;
import gym.customers.Person;
import gym.sessions.Session;

import java.util.ArrayList;
import java.util.List;

public class Gym {
    private static Gym instance;
    private String name;
    private Secretary secretary;
    private double balance;
    private final List<Client> clients;
    private final List<Instructor> instructors;
    private final List<Session> sessions;
    private final List<String> actionHistory;

    public Gym() {
        this.clients = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.actionHistory = new ArrayList<>();
        this.balance = 0;
    }

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecretary(Person person, double salary) {
        if (secretary != null) {
            actionHistory.add("A new secretary has started working at the gym: " + person.getName());
        }
        this.secretary = new Secretary(person, salary);
        actionHistory.add("A new secretary has started working at the gym: " + secretary.getName());
    }
    public Secretary getSecretary() {
        return secretary;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<String> getActionHistory() {
        return actionHistory;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder gymInfo = new StringBuilder();
        gymInfo.append("Gym Name: ").append(name).append("\n");
        gymInfo.append("Gym Secretary: ").append(secretary).append("\n");
        gymInfo.append("Gym Balance: ").append(balance).append("\n");

        gymInfo.append("\nClients Data:\n");
        for (Client client : clients) {
            gymInfo.append(client).append("\n");
        }

        gymInfo.append("\nEmployees Data:\n");
        for (Instructor instructor : instructors) {
            gymInfo.append(instructor).append("\n");
        }

        gymInfo.append("\nSessions Data:\n");
        for (Session session : sessions) {
            gymInfo.append(session).append("\n");
        }

        return gymInfo.toString();
    }

}
