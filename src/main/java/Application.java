import model.Customer;
import model.Event;
import model.Ticket;
import repository.InMemoryTicketRepository;
import repository.TicketRepository;
import service.TicketService;

public class Application {
    public static void main(String[] args) {
        TicketRepository repository = new InMemoryTicketRepository();
        TicketService service = new TicketService(repository);

        Event concert = new Event(1L, "Rock Concert", 2);
        Customer customer = new Customer(1L, "Ivan");

        Ticket ticket = service.buyTicket(1L, concert, customer);

        System.out.println("Свободных мест после покупки: " + concert.getAvailableSeats());

        service.cancelTicket(ticket);

        System.out.println("Свободных мест после отмены: " + concert.getAvailableSeats());
    }
}