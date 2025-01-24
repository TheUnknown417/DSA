import java.util.Scanner;

class Passenger {
    String name;
    int ticketNumber;
    Passenger next;

    public Passenger(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.next = null;
    }
}

class ReservationSystem {
    Passenger head;
    int ticketCounter;

    public ReservationSystem() {
        this.head = null;
        this.ticketCounter = 0;
    }

    public void reserveTicket(String passengerName) {
        ticketCounter++;
        Passenger newPassenger = new Passenger(passengerName, ticketCounter);

        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }

        System.out.println("Ticket reserved for " + passengerName + ". Your ticket number is " + ticketCounter);
    }

    public void cancelTicket(int ticketNumber) {
        if (head == null) {
            System.out.println("No reservations found.");
            return;
        }

        if (head.ticketNumber == ticketNumber) {
            head = head.next;
            System.out.println("Ticket number " + ticketNumber + " has been cancelled.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && current.ticketNumber != ticketNumber) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("No reservation found for ticket number " + ticketNumber);
        } else {
            previous.next = current.next;
            System.out.println("Ticket number " + ticketNumber + " has been cancelled.");
        }
    }

    public void checkReservation(int ticketNumber) {
        Passenger current = head;
        while (current != null) {
            if (current.ticketNumber == ticketNumber) {
                System.out.println("Ticket number " + ticketNumber + " is reserved for " + current.name);
                return;
            }
            current = current.next;
        }
        System.out.println("No reservation found for ticket number " + ticketNumber);
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("No passengers are currently reserved.");
            return;
        }

        Passenger current = head;
        System.out.println("List of passengers:");
        while (current != null) {
            System.out.println("Ticket number: " + current.ticketNumber + ", Passenger: " + current.name);
            current = current.next;
        }
    }
}

public class AirplaneReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem system = new ReservationSystem();

        while (true) {
            System.out.println("\n--- Airplane Reservation System ---");
            System.out.println("1. Reserve a Ticket");
            System.out.println("2. Cancel a Ticket");
            System.out.println("3. Check Reservation by Ticket Number");
            System.out.println("4. Display All Passengers");
            System.out.println("5. Exit");
            System.out.print("Please choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    system.reserveTicket(name);
                    break;

                case 2:
                    System.out.print("Enter ticket number to cancel: ");
                    int cancelTicketNumber = scanner.nextInt();
                    system.cancelTicket(cancelTicketNumber);
                    break;

                case 3:
                    System.out.print("Enter ticket number to check: ");
                    int checkTicketNumber = scanner.nextInt();
                    system.checkReservation(checkTicketNumber);
                    break;

                case 4:
                    system.displayPassengers();
                    break;

                case 5:
                    System.out.println("Thank you for using the Airplane Reservation System!");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }

    }

}
