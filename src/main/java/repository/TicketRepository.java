package repository;

import model.Ticket;
import java.util.List;

public interface TicketRepository {
    void save(Ticket ticket);
    void delete(Ticket ticket);
    List<Ticket> findAll();
}