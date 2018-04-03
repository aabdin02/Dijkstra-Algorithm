import java.util.ArrayList;
//This class is a representation of undirected graph

public class GraphNode {
	char value;
	boolean visited = false;
	//The Edge is split into two: the Nodes, the Weight
	ArrayList<GraphNode> networks;
	ArrayList<Double> weights;
	Double minimumDistance = Double.POSITIVE_INFINITY;

	public GraphNode(char val){
		this.value = val;
		this.networks = new ArrayList<GraphNode>();
		this.weights = new ArrayList<Double>();
	}

	//Adds an Edge
	public void addEdge(GraphNode network, Double weight){
		this.networks.add(network);
		this.weights.add(weight);
	}

	//since it is undirected graph, there is a possiblity of visiting the same node 
	public void setVisited(boolean visit){
		this.visited = visit;
	}
	public void setMinimumDistance(Double val){
		this.minimumDistance = val;
	}

	//Graph Traversal: Print One Path before printing the siblings
	public void printDepthFirst(){
		this.visited = true;
		for(int i = 0; i < networks.size(); i++){
			GraphNode next = this.networks.get(i);
			if(!next.visited){
				next.setVisited(true);
				System.out.print(next.value + "\t");
				System.out.println(weights.get(i));
				next.printDepthFirst();
			}
		}
	}

	//Make sure that all graph Nodes are reset to not visited!
	public void resetVisited(){
		this.visited = false;
		for (int i = 0; i < networks.size(); i++) {
			GraphNode neighbor = this.networks.get(i);
			if(neighbor.visited){
				neighbor.setVisited(false);
			}
		}
	}
}