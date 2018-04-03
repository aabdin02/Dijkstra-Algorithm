/* This class is a representation of Dijkstra Algorithm
 Input: Graph
 Output: Shortest Path as a linkedList
 */
 import java.util.LinkedList;
 import java.util.ArrayList;

public class Dijkstra{
	LinkedList<GraphNode> path;

	public LinkedList<GraphNode> shortestPath(GraphNode from, GraphNode destination){
		path = new LinkedList<GraphNode>();
		from.minimumDistance = 0.0;
		helper(from, destination);

		return path;
	}

	public boolean helper(GraphNode from, GraphNode destination){
		from.setVisited(true);
		path.add(from);
		if(from.value == destination.value) return true;

		for(int i = 0; i < from.networks.size(); i++){//Nodes Size
			GraphNode node = from.networks.get(i);
			if(!node.visited){
				if(from.networks.get(i).minimumDistance == Double.POSITIVE_INFINITY){
					node.setMinimumDistance(from.weights.get(i) + from.minimumDistance);
				}else{
					//Distance from current source
					double distance = from.weights.get(i) + from.minimumDistance;
					double distance1 = node.minimumDistance; //Distance from the previous path
					if(distance1 > distance){
						node.setMinimumDistance(distance);
					}
				}
			}
		}

		for(int i = 0; i < from.networks.size();i++){
			GraphNode nextShortest = getNextShortestMinimumDistance(from.networks);
			if(nextShortest != null){
				return helper(nextShortest, destination);
			}
		}

		return false;
		
	}

	public GraphNode getNextShortestMinimumDistance(ArrayList<GraphNode> net){
		GraphNode node = new GraphNode('F');
		node.minimumDistance = Double.POSITIVE_INFINITY;

		for(int i = 0 ; i < net.size(); i++){
			if(node.minimumDistance > net.get(i).minimumDistance){
				if(!net.get(i).visited)
					node = net.get(i);
			}
		}
		if(node.minimumDistance == Double.POSITIVE_INFINITY)
			node = null;

		return node;
	}

}