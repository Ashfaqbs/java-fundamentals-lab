package ChatGpt;
import java.util.ArrayList;
import java.util.List;

public class Graph1 {
	


	  private final int numVertices;
	  private final List<Integer>[] adjacencyList;

	  public Graph1(int numVertices) {
	    this.numVertices = numVertices;
	    this.adjacencyList = new List[numVertices];
	    for (int i = 0; i < numVertices; i++) {
	      adjacencyList[i] = new ArrayList<>();
	    }
	  }

	  public void addEdge(int u, int v) {
	    adjacencyList[u].add(v);
	    adjacencyList[v].add(u);
	  }

	  public List<Integer> getAdjacencyList(int vertex) {
	    return adjacencyList[vertex];
	  }
	}


