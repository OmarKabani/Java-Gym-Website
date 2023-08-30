package servlets;

public class SportClass {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	private int id;
    private double cost;
    private String coach;
    private String name;
    private String time;
    private int numberOfPlaces;
    private double rating;

    public SportClass(int id, double cost, String coach, String name, String time, int numberOfPlaces, double rating) {
        this.id = id;
        this.cost = cost;
        this.coach = coach;
        this.name = name;
        this.time = time;
        this.numberOfPlaces = numberOfPlaces;
        this.rating = rating;
    }

    // Getters and setters for each field
    // ...
}
