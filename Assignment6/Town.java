import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
/**
 * This is the town class which will be used as a vertex in the graph class
 * @author Germain Asaba
 *
 */
public class Town implements Comparable<Town> {
	private String townName;
	private Map<Town, Integer> adjacentTowns;
	private Integer range;
	private LinkedList<Town> shortestRoute;

	/**
	 * Defualt constructor
	 */
	public Town() {
		super();
		this.adjacentTowns = new HashMap<>();
		this.range = Integer.MAX_VALUE;
		this.shortestRoute = new LinkedList<>();

	}

	/**
	 * Parameterized constructor
	 * @param townName The name of the town
	 */
	public Town(String townName) {
		this.townName = townName;
		this.adjacentTowns = new HashMap<>();
		this.range = Integer.MAX_VALUE;
		this.shortestRoute = new LinkedList<>();

	}


	/**
	 * This method keeps track of the adjacent towns
	 * @param town The adjacent town
	 * @param distance the distance to the adjacent town
	 */
	public void addAdjacentTown(Town town, int distance)
	   {
	       this.adjacentTowns.put(town, distance);
	   }

	/**
	 * This method compares two objects and determines if they're the same using the town name attribute
	 * @param o the object being compared
	 */
	@Override
	public int compareTo(Town o) {
		if(townName.compareToIgnoreCase(o.townName) < 0) {
			return -1;
		}
		else if (townName.compareToIgnoreCase(o.townName) > 0) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * This method creates a string representation of the attributes in this class
	 * @return the string representation
	 */
	@Override
	public String toString() {
		String result = "";
		result = "Town{\" + \"Name = \" + nameOfTown + \", AdjTowns = \" + adjacentTowns.values() + \"}\"";
		return result;
	}

	/**
	 * This method gets the name of the town
	 * @return the name of the town
	 */
	public String getTownName() {
		return townName;
	}

	/**
	 * This method sets the name of the town
	 * @param townName the town name to be set
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}

	/**
	 * This method gets the distance between the town
	 * @return the distance
	 */
	public int getRange() {
		return range;
	}

	/**
	 * This method sets the distance
	 * @param range the distance to be set
	 */
	public void setRange(Integer range) {
		this.range = range;
	}
	
	/**
	 * This method keeps track of the adjacency matrix
	 * @return the adjacent towns
	 */
	public Map<Town, Integer> getAdjacentTowns(){
		return adjacentTowns;
	}
	
	/**
	 * This method sets the adjacent towns
	 * @param adjacentTowns the adjacent towns
	 */
	public void setAdjacentTowna(Map<Town, Integer> adjacentTowns) {
		this.adjacentTowns = adjacentTowns;
	}

	/**
	 * This method keeps track of the shortest route
	 * @return the shortest route
	 */
	public LinkedList<Town> getShortestRoute() {
		return shortestRoute;
	}

	/**
	 * This method sets the shortest route
	 * @param shortestRoute the shortes route to be set
	 */
	public void setShortestRoute(LinkedList<Town> shortestRoute) {
		this.shortestRoute = shortestRoute;
	}

	/**
	 * This method creates a hash code 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(townName);
	}

	/**
	 * This method compares to objects and determines if they're equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		return Objects.equals(townName, other.townName);
	}
	
	

}
