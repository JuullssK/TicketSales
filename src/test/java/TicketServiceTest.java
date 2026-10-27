import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.Event;
import model.Ticket;
import repository.InMemoryTicketRepository;
import repository.TicketRepository;
import service.TicketService;

public class TicketServiceTest {

    @Test
    void shouldBuyTicketSuccessfully() {
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);
        Event event = new Event(1L, "Concert", 10);
        Customer customer = new Customer(1L, "Ivan");

        Ticket ticket = service.buyTicket(1L, event, customer);

        assertNotNull(ticket);
        assertEquals(9, event.getAvailableSeats());
    }

    @Test
    void shouldThrowExceptionWhenNoSeats() {
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        Event event = new Event(1L, "Concert", 1);

        service.buyTicket(1L, event, new Customer(1L, "Ivan"));

        assertThrows(IllegalStateException.class,
                () -> service.buyTicket(2L, event, new Customer(2L, "Petr")));
    }

    @Test
    void shouldReturnSeatAfterCancellation() {
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        Event event = new Event(1L, "Concert", 2);
        Ticket ticket = service.buyTicket(1L, event, new Customer(1L, "Ivan"));

        service.cancelTicket(ticket);

        assertEquals(2, event.getAvailableSeats());
    }
    
    @Test
    void shouldCreateTicketWithCorrectData() {
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        Event event = new Event(2L, "Rock Concert", 100);
        Customer customer = new Customer(5L, "Anna");

        Ticket ticket = service.buyTicket(10L, event, customer);

        assertNotNull(ticket);
        assertEquals(100L, ticket.getId());
        assertEquals("Rock Concert", ticket.getEvent().getName());
        assertEquals("Anna", ticket.getCustomer().getName());
    }

}