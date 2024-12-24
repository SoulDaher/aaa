package gym.customers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Person {
    private final String name;
    private double balance;
    private final Gender gender;
    private final LocalDate birthDate;
    private int ID;

    public Person(String name, double balance, Gender gender, String birthDate) {
        this.name = name;
        this.balance = balance;
        this.gender = gender;
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Try parsing the date
        this.birthDate = parseDateWithFormats(birthDate, formatter1, formatter2);
    }
    private LocalDate parseDateWithFormats(String date, DateTimeFormatter... formatters) {
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException ignored) {
                // Try the next format
            }
        }
        throw new IllegalArgumentException("Invalid date format. Please use DD-MM-YYYY or YYYY-MM-DD.");
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getID() {return ID;}

    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthDate.getYear();
        if (now.getMonthValue() < birthDate.getMonthValue() ||
                (now.getMonthValue() == birthDate.getMonthValue() && now.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    public void deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance.");
        }
    }


    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Gender: %s | Birthday: %s | Age: %d | Balance: %.2f",
                hashCode(), name, gender, birthDate, getAge(), balance);
    }

}
