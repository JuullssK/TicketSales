package repository;

import model.Ticket;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTicketRepository implements TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) { tickets.add(ticket); }
    public void delete(Ticket ticket) { tickets.remove(ticket); }
    public List<Ticket> findAll() { return new ArrayList<>(tickets); }
}