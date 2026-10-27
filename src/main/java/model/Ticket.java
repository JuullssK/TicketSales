package model;

public class Ticket {
    private Long id;
    private Event event;
    private Customer customer;

    public Ticket(Long id, Event event, Customer customer) {
        this.id = id;
        this.event = event;
        this.customer = customer;
    }

    public Long getId() { return id; }
    public Event getEvent() { return event; }
    public Customer getCustomer() { return customer; }
}