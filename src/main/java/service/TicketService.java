package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Customer;
import model.Event;
import model.Ticket;
import repository.TicketRepository;

//fghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfghfgh

public class TicketService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(TicketService.class);

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket buyTicket(Long ticketId, Event event, Customer customer) {

        try {
            event.reserveSeat();
        } catch (IllegalStateException e) {
            LOGGER.warn("Покупка билета невозможна: нет свободных мест. Событие: {}",
                    event.getName());
            throw e;
        }

        try {
            Ticket ticket = new Ticket(ticketId, event, customer);
            repository.save(ticket);

            LOGGER.info("Билет успешно куплен. ID билета: {}, событие: {}",
                    ticketId, event.getName());

            return ticket;

        } catch (RuntimeException e) {
            event.releaseSeat();

            LOGGER.error("Ошибка при обработке покупки билета. ID билета: {}",
                    ticketId, e);

            throw e;
        }
    }

    public void cancelTicket(Ticket ticket) {
        repository.delete(ticket);
        ticket.getEvent().releaseSeat();

        LOGGER.info("Билет возвращён. ID билета: {}", ticket.getId());
    }
}