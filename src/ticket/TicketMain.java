package ticket;

public class TicketMain {
  public static void main(String[] args) {
    Ticket ticket = new Ticket();

    float[][] items1 = {
      {1, 1, 3.80f},
      {2, 1, 2.0f},
      {3, 3, 2.20f},
      {4, 5, 2.90f},
      {5, 10, 3.20f},
      {6, 12, 3.70f},
      {7, 5, 3.10f},
      {8, 7, 3.60f},
      {9, 12, 2.70f}
    };

    System.out.println(ticket.generateTicket(items1));
  }
}
