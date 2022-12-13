package menu;

public class Food {
	private final String name;
	private final int preparationDurationFood;
	
	public Food(String name,int preparationDurationFood) {
		this.name = name;
		this.preparationDurationFood = preparationDurationFood;
		
	}

	public String toString() {
		return name;
	}

}
