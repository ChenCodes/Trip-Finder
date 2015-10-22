package graph;



import java.util.LinkedList;
/* See restrictions in Graph.java. */

/** Implements a breadth-first traversal of a graph.  Generally, the
 *  client will extend this class, overriding the visit method as desired
 *  (by default, it does nothing).
 *  @author Yuxi Chen
 */
public class BreadthFirstTraversal extends Traversal {

    /** A depth-first Traversal of G, using FRINGE as the fringe. */
    protected BreadthFirstTraversal(Graph G) {
        super(G, new LinkedList<Integer>());
        _G = G;
    }

    @Override
    protected boolean isDFS() {
        return false;
    }

    @Override
    protected boolean visit(int v) {
        return super.visit(v);
    }


    /** This is a representation of the graph that we're working with. */
    private Graph _G;

    /** This holds our initial fringe items. */
    private LinkedList<Integer> fringeItems;

}
