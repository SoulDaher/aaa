package gym.sessions;

public enum SessionType {
    Pilates(30,60),
    MachinePilates(10,80),
    ThaiBoxing(20, 100),
    Ninja(5, 150);

    private final int maxParticipants;

    SessionType(int maxParticipants, int price) {
        this.maxParticipants = maxParticipants;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }
}
