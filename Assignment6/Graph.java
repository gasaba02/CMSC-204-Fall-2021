import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * This is the graph class that uses the Town(vertex) and Road(edge) classes to create a graph
 * @author Germain Asaba
 */
public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> myTowns;
	private Set<Road> myRoads;

	public Graph() {
		myTowns = new HashSet<Town>();
		myRoads = new HashSet<Road>();
	}
	/**
	 * This method returns a road that connects to Towns
	 * @param sourceVertex The first town from which the road leaves from. 
	 * @param destinationVertex The second Town the road connects to.
	 * @return This method returns a road that connects the two towns
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(Road road : myRoads) {
			if(((road.getFirstEndpoint().compareTo(sourceVertex) == 0) 
					&& (road.getSecondEndpoint().compareTo(destinationVertex) == 0)) 
					|| ((road.getSecondEndpoint().compareTo(sourceVertex) == 0) 
							&& (road.getFirstEndpoint().compareTo(destinationVertex) == 0))) {
				return road;
			}
		}
		return null;
	}

	/**
	 * This method creates a new road that connects the starting Town to the destination Town
	 * @param sourceVertex The first town the road leaves from.
	 * @param destinationVertex The second town the road connects to.
	 * @param weight The distance or range of the road.
	 * @param description The name of the road
	 * @return The new road that was created or null.
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException {
		Road myRoad = null;
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		else if(sourceVertex == null || destinationVertex == null ) {
			throw new NullPointerException();
			
		} else {
		 myRoad = new Road(sourceVertex, destinationVertex, weight, description);

		sourceVertex.addAdjacentTown(destinationVertex, weight);
		destinationVertex.addAdjacentTown(sourceVertex, weight);
		myRoads.add(myRoad);

		
		}
		return myRoad;
	}

	/**
	 * This method adds a specific Town to the graph.
	 * @param v The Town to be added to the graph.
	 * @return returns true if the Tonw was added
	 */
	@Override
	public boolean addVertex(Town v) {

		return myTowns.add(v);
	}

	/**
	 * This method checks to see if the graph contains a particular road
	 * @param sourceVertex source Town of the road.
	 * @param destinationVertex target Town of the road.
	 * @return true if this graph contains the specified road.
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road road : myRoads) {
			if(road.contains(sourceVertex) && road.contains(destinationVertex)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if the graph has a specific Town.
	 * @param v Town to be checked.
	 * @return returns true if the Town is in the graph.
	 */
	@Override
	public boolean containsVertex(Town v) {
		for(Town town : myTowns) {
			if(town.getTownName().compareToIgnoreCase(v.getTownName()) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns a set of roads that are in the graph.
	 * @return returns a set of roads in the graph.
	 */
	@Override
	public Set<Road> edgeSet() {

		return myRoads;
	}

	/**
	 * This method checks puts all the roads connected to a specific Town.
	 * @param vertex The town to be checked.
	 * @return Returns all the roads connected to the specified town as a set.
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> set  = new HashSet<>();
		for(Road rd : this.myRoads) {
			if(rd.contains(vertex)) {
				set.add(rd);
			}
		}
		return set;
	}

	/**
	 * This method removes a road that connects to specified towns.
	 * @param sourceVertex beginning town of the road.
	 * @param destinationVertex destination town of the road.
	 * @param weight distance of the road.
	 * @param description name of the road.
	 * @return The removed road.
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road rd = null;
		if(containsEdge(sourceVertex,destinationVertex)) {
			rd = new Road(sourceVertex, destinationVertex, weight, description);
			boolean result = myRoads.remove(rd);
			System.out.print(result);
		}
		 
		return rd;
	}

	/**
	 * This method removes a specified town from the graph.
	 * @param v The town to be removed.
	 * @return true if the town was removed or false otherwise.
	 */
	@Override
	public boolean removeVertex(Town v) {
		return myTowns.remove(v);
	}

	/**
	 * This method returns all the towns contained in this graph as a set.
	 * @return a set containing all the towns in this graph.
	 */
	@Override
	public Set<Town> vertexSet() {
		return myTowns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		return null;
	}

	/**
	 * This is the dijkstra method to find the shortest path.
	 * @param sourceVertex The town to find the shortest path from.
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {

	}


}
