package restorant;
import restaurantSimulation.Customer;


public class Main {

	public static void main(String[] args) {

		System.out.println("Start the restaurant simulation ." );
		System.out.print("Table: 5   " );
		System.out.print("Waiter: 4   " );
		System.out.print("Chef: 3   " );
		System.out.println("Customer: 13" );
		
		
	    int customerCount = 14;
        for (int i = 1; i < customerCount; ++i) {
        	Customer customer = new Customer(i);
            Thread thread = new Thread(customer);
            thread.start();
           
        }
        System.out.println("Restaurant simulation finished." );
	}

}
