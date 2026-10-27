package service;

import model.Customer;
import model.Event;
import model.Ticket;
import repository.TicketRepository;

public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket buyTicket(Long ticketId, Event event, Customer customer) {
        event.reserveSeat();
        Ticket ticket = new Ticket(ticketId, event, customer);
        repository.save(ticket);
        return ticket;
    }

    public void cancelTicket(Ticket ticket) {
        repository.delete(ticket);
        ticket.getEvent().releaseSeat();
    }
}