package model;

public class Event {
    private Long id;
    private String name;
    private int totalSeats;
    private int availableSeats;

    public Event(Long id, String name, int totalSeats) {
        this.id = id;
        this.name = name;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAvailableSeats() { return availableSeats; }

    public void reserveSeat() {
        if (availableSeats <= 0) {
            throw new IllegalStateException("Нет свободных мест");
        }
        availableSeats--;
    }

    public void releaseSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
}