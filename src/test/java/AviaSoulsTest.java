import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moscow", "London", 17000, 10, 14);
    Ticket ticket2 = new Ticket("Moscow", "Berlin", 15000, 2, 5);
    Ticket ticket3 = new Ticket("Moscow", "London", 16500, 9, 13);
    Ticket ticket4 = new Ticket("Moscow", "London", 16000, 8, 13);
    Ticket ticket5 = new Ticket("New York", "London", 38000, 7, 15);
    Ticket ticket6 = new Ticket("Moscow", "London", 11000, 9, 14);
    Ticket ticket7 = new Ticket("Moscow", "London", 17000, 18, 22);
    Ticket ticket8 = new Ticket("Moscow", "London", 17000, 18, 22);
    Ticket ticket9 = new Ticket("London", "Moscow", 14000, 18, 22);

    @Test
    public void shouldSearchIfSeveralResults() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);

        Ticket[] expected = {ticket6, ticket4, ticket3, ticket1, ticket7, ticket8};
        Ticket[] actual = aviaSouls.search("Moscow", "London");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfZeroResults() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Paris", "London");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByIfSeveralResults() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);

        Ticket[] expected = {ticket1, ticket3, ticket7, ticket8, ticket4, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "London", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByIfZeroResults() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Mexico", "London", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, actual);
    }



}
