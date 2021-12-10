import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
/**
 * This is the town graph manager class that creates and object of the graph class.
 * @author Germain asaba
 * 
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph;
	ArrayList<Town> myTowns;
	ArrayList<Road> myRoads;

	/**
	 * Default constructor.
	 */
	public TownGraphManager() {
		graph = new Graph();
		myTowns = new ArrayList<>();
		myRoads = new ArrayList<>();
	}



	/**
	 * This method adds a road to the graph
	 * @param town1 name of 1st town
	 * @param town2 name of 2nd town
	 * @param roadName name of road
	 * @return true if the road was added 
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		Town sourceVertex = new Town (town1);
		Town destinationVertex = new Town (town2);

		graph.addVertex(sourceVertex);
		graph.addVertex(destinationVertex);
		Road rd = graph.addEdge(sourceVertex, destinationVertex, weight, roadName);

		return true;



	}

	/**
	 * This method gets the name of the road that both towns are connected by
	 * @param town1 name of 1st town 
	 * @param town2 name of 2nd town 
	 * @return the name of the road.
	 */
	@Override
	public String getRoad(String town1, String town2) {

		Road myRd = graph.getEdge(new Town(town1), new Town(town2));
		if(myRd == null) {
			return null;
		}
		return myRd.getRoadName();

	}

	/**
	 * This method adds a town to the graph
	 * @param v the town's name  
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {

		if(!containsTown(v)){
			myTowns.add(new Town(v));
			return true;
		}
		return false;
	}

	/**
	 * This method gets a town with a given name
	 * @param name the town's name 
	 * @return the Town's name
	 */
	@Override
	public Town getTown(String name) {
		Town town = null;
		for(int i = 0; i < myTowns.size(); i++) {
			if(myTowns.get(i).getTownName().equals(name)) {
				town = myTowns.get(i);
			}
		}
		return town;
	}

	/**
	 * This method determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false otherwise
	 */
	@Override
	public boolean containsTown(String v) {
		for(Town town : myTowns){
			if(town.getTownName().compareToIgnoreCase(v) == 0)
				return true;
		}
		return false;
	}

	/**
	 * This method determines if a road is in the graph
	 * @param town1 name of 1st town 
	 * @param town2 name of 2nd town 
	 * @return true if the road is in the graph, false otherwise
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {

		Town sourceT = new Town(town1);
		Town destTown = new Town(town2);
		return graph.containsEdge(sourceT, destTown);


	}

	/**
	 * This method creates an arraylist of all road titles in sorted order by road name
	 * @return the sorted array.
	 */
	@Override
	public ArrayList<String> allRoads() {
		Set<Road> rds = graph.edgeSet();
		ArrayList<String> result = new ArrayList<String>();
		for(Road r: rds) { 
			result.add(r.getRoadName());
		}
		Collections.sort(result);
		return result;

	}

	/**
	 * This method deletes a road from the graph
	 * @param town1 name of 1st town
	 * @param town2 name of 2nd town
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false otherwise
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		Town sourceT = new Town(town1);
		Town destinationT = new Town(town2);
		Road rd = graph.getEdge(sourceT, destinationT);
		if(rd == null) {
			return false;
		}
		graph.removeEdge(sourceT, destinationT, rd.getDistance(), road);
		return true;

	}

	/**
	 * This method deletes a town from the graph
	 * @param v name of town 
	 * @return true if the town was successfully deleted, false otherwise
	 */
	@Override
	public boolean deleteTown(String v) {
		Town sourceTown = null;

		for(int i = 0; i < myTowns.size(); i++) {
			if(myTowns.get(i).getTownName().equals(v)) {
				sourceTown = myTowns.get(i);
			}
		}
		return myTowns.remove(sourceTown);
	}

	/**
	 * This method creates an arraylist of all towns in alphabetical order
	 * @return an arraylist of all towns in alphabetical order 
	 */
	@Override
	public ArrayList<String> allTowns() {

		Set<Town> myTowns = graph.vertexSet();
		ArrayList<String> rs = new ArrayList<String>();
		for(Town town: myTowns) rs.add(town.getTownName());
		Collections.sort(rs);
		return rs;



	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of 1st town
	 * @param town2 name of 2nd town
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return null;
	}

	/**
	 * This method populates a graph with information form a txt file.
	 * @param selectedFile the txt file
	 * @throws FileNotFoundException thrown if the file wasn't found
	 */
	public void populateTownGraph(File selectedFile) throws FileNotFoundException{


		BufferedReader objReader = null;
		try {
			String ln;

			objReader = new BufferedReader(new FileReader(selectedFile));

			while ((ln = objReader.readLine()) != null) {

				System.out.println(ln);

				String [] townInfo = ln.split(",");
				String rdName = townInfo[0];

				String[] detailedTownInfo = townInfo[1].split(";");
				String weight = detailedTownInfo[0];
				String source = detailedTownInfo[1];
				String destination = detailedTownInfo[2];
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				if (objReader != null)
					objReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}



	}

}
