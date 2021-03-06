package graph;

import java.util.HashMap;
/** import trip.Location; */

/* See restrictions in Graph.java. */

/** A partial implementation of ShortestPaths that contains the weights of
 *  the vertices and the predecessor edges.   The client needs to
 *  supply only the two-argument getWeight method.
 *  @author Yuxi Chen
 */
public abstract class SimpleShortestPaths extends ShortestPaths {

    /** The shortest paths in G from SOURCE. */
    public SimpleShortestPaths(Graph G, int source) {
        this(G, source, 0);
    }

    /** A shortest path in G from SOURCE to DEST. */
    public SimpleShortestPaths(Graph G, int source, int dest) {
        super(G, source, dest);
        _weights = new HashMap<Integer, Double>();

    }

    /** This gets us the weight of a node v.
        @return
        @param v This is the node.
        */
    @Override
    public double getWeight(int v) {
        if (!_weights.keySet().contains(v)) {
            return Double.POSITIVE_INFINITY;
        }
        return _weights.get(v);
    }

    @Override
    protected abstract double getWeight(int u, int v);

    @Override
    /** This allows us to add labels to the graph. */
    protected void setWeight(int v, double w) {
        super.getBestWeight().put(v, w);
        _weights.put(v, w);
    }

    @Override
    public int getPredecessor(int v) {
        if (!super.getBestPredecessor().keySet().contains(v)) {
            return 0;
        }
        return super.getBestPredecessor().get(v);
    }


    @Override
    protected void setPredecessor(int v, int u) {
        super.getBestPredecessor().put(v, u);

    }

    /** This holds my weights for a given vertex. */
    private HashMap<Integer, Double> _weights;

}
