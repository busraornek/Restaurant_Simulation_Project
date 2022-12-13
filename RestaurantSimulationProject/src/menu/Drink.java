package menu;

public class Drink {
	private final String name;
	private final int preparationDurationDrink;
	

	public Drink(String name, int preparationDurationDrink) {
		this.name = name;
		this.preparationDurationDrink = preparationDurationDrink;
		
	}

	public String toString() {
		return name;
	}

}
