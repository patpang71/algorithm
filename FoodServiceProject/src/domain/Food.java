package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Food {
	String name;
	int calories;
	String servingSize;
	
	/**
	 * @param name
	 * @param calories
	 * @param servingSize
	 */
	public Food(String name, int calories, String servingSize) {
		super();
		this.name = name;
		this.calories = calories;
		this.servingSize = servingSize;
	}

	public Food() {
		super();
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", servingSize=" + servingSize + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

}
