package graph;

import java.util.*;

public class CloneGraph {

	static class GraphNode {
		int val;
		Vector<GraphNode> neighbours;

		GraphNode(int val) {
			this.val = val;
			neighbours = new Vector<GraphNode>();
		}
	}

	public GraphNode cloneGraph(GraphNode source) {
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.add(source);

		HashMap<GraphNode, GraphNode> hm = new HashMap<GraphNode, GraphNode>();

		hm.put(source, new GraphNode(source.val));

		while (!q.isEmpty()) {
			GraphNode u = q.poll();
			GraphNode cloneNodeU = hm.get(u);

			if (u.neighbours != null) {
				Vector<GraphNode> v = u.neighbours;
				for (GraphNode graphNode : v) {
					GraphNode cloneNodeG = hm.get(graphNode);

					if (cloneNodeG == null) {
						q.add(graphNode);
						cloneNodeG = new GraphNode(graphNode.val);
						hm.put(graphNode, cloneNodeG);
					}

					cloneNodeU.neighbours.add(cloneNodeG);
				}
			}
		}
		return hm.get(source);
	}

}
