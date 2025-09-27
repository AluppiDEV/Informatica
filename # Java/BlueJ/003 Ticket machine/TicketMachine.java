/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 7.0
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int cost)
    {
        if (cost >= 0) 
        {
            price = cost;
        }
        else
        {
            price = 1;
        }
        balance = 0;
        total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Update the price of a ticket.
     */
    public void newPrice(int cost)
    {
        price = cost;
    }

    /**
     * Update the price of a ticket.
     */
    public void showPrce()
    {
        System.out.println("The actual price of a ticket is " + getPrice() + " cents.");
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * Return the amount of the money machine
     * had already colected.
     */
    public int getTotal()
    {
        return total;
    }

    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        if(balance >= 5)
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + getPrice() + " cents.");
            System.out.println("##################");
            if (balance - 5 > 0) 
            {    
                System.out.println("# Your rest is " + (balance - 5) + " cents");
                System.out.println("##################");
            }
            System.out.println();
    
            // Update the total collected with the balance.
            total = total + 5;
            // Clear the balance.
            balance = 0;
        }
        else
        {
            System.out.println("#######################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Add more money");
            System.out.println("# the cost is " + getPrice() + " cents.");
            System.out.println("#######################");
            System.out.println();
        }
    }

    /**
     * Print the instructon for the user 
     */
    public void prompt()
    {
        System.out.println("You have to insert 5 cents to print a ticket");
        System.out.println("You already have " + getBalance() + " cents");
    }
}
