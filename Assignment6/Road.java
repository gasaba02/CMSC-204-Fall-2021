import java.util.Objects;
/**
 * This the road class that will function as an edge for the graph.
 * @author Germain Asaba
 *
 */
public class Road implements Comparable<Road>{

	private Town firstEndpoint;
	private Town secondEndpoint;
	private String roadName;
	private int distance;


	/**
	 * Parameterized constructor
	 * @param firstEndpoint first town
	 * @param secondEndpoint second town
	 * @param roadName name of the road/edge
	 */
	public Road(Town firstEndpoint, Town secondEndpoint, String roadName) {
		this.firstEndpoint = firstEndpoint;
		this.secondEndpoint = secondEndpoint;
		this.roadName = roadName;
		this.distance = 1;
	}

	/**
	 * Second parameterized constructor
	 * @param firstEndpoint first town
	 * @param secondEndpoint second town
	 * @param distance weight of the road/edge
	 * @param roadName name of the road/edge
	 */
	public Road(Town firstEndpoint, Town secondEndpoint, int distance, String roadName) {
		this.firstEndpoint = firstEndpoint;
		this.secondEndpoint = secondEndpoint;
		this.roadName = roadName;
		this.distance = distance;
	}




	/**
	 * This method gets the first town
	 * @return the first town
	 */
	public Town getFirstEndpoint() {
		return firstEndpoint;
	}




	/**
	 * This method sets the first town
	 * @param firstEndpoint town to be set
	 */
	public void setFirstEndpoint(Town firstEndpoint) {
		this.firstEndpoint = firstEndpoint;
	}




	/**
	 * This method gets the second town
	 * @return the second town
	 */
	public Town getSecondEndpoint() {
		return secondEndpoint;
	}


	/**
	 * This method sets the second town
	 * @param secondEndpoint the town to be set
	 */
	public void setSecondEndpoint(Town secondEndpoint) {
		this.secondEndpoint = secondEndpoint;
	}



	/**
	 * This method gets the name of the road/edge
	 * @return the name os the road
	 */
	public String getRoadName() {
		return roadName;
	}




	/**
	 * This method sets the name of the road
	 * @param roadName name for the road.
	 */
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}




	/**
	 * This method gets the distance of the road
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * This method checks if a specified town is contained in the graph
	 * @param vertex the town to check for
	 * @return
	 */
	public boolean contains(Town vertex) {
		return (firstEndpoint.compareTo(vertex) == 0 || secondEndpoint.compareTo(vertex) == 0);
	}




	/**
	 * This method sets the distance of a town
	 * @param distance the distance being set to
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * This method returns a string representation of the attributes of this class
	 */
	public String toString() {
		String result = "";
		result = "Road {" + "First Endpoint = " + firstEndpoint.getTownName() + ", Second Endpoint = " + 
				secondEndpoint.getTownName() + ", Name = " + roadName + ", Distance = " + distance + "} ";

		return result;
	}





	/**
	 * This method compares two objects of this class and returns whether 
	 * they're the same is their distance are equal
	 */
	@Override
	public int compareTo(Road o) {
		if(this.distance < (o.distance)) {
			return -1;
		}
		else if (this.distance > (o.distance)) {
			return 1;
		}
		else

			return 0;
	}

	/**
	 * This method generates a hash code using the attributes of this class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(distance, firstEndpoint, roadName, secondEndpoint);
	}

	/**
	 * This method checks if two objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		return distance == other.distance && Objects.equals(firstEndpoint, other.firstEndpoint)
				&& Objects.equals(roadName, other.roadName) && Objects.equals(secondEndpoint, other.secondEndpoint);
	}



}
