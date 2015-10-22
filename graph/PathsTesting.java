package graph;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;



/** Unit tests for the Traversal class.
 *  @author Yuxi Chen
 */
public class PathsTesting {
    private class SSPTester extends SimpleShortestPaths {
        /** The shortest paths in G from SOURCE. */
        public SSPTester(Graph G, int source, int destination) {
            super(G, source, destination);
            _G = G;
            _calledEst = false;
        }


        @Override
        protected double getWeight(int u, int v) {
            LabeledGraph h = ((LabeledGraph) _G);
            return ((double) h.getLabel(u, v));
        }

        @Override
        /** Returns an estimated heuristic weight of the shortest path
        from vertex V to the destination vertex (if any).  This is
        assumed to be less than the actual weight, and is 0 by default.
        */
        protected double estimatedDistance(int v) {
            _calledEst = true;
            if (v == 1) {
                return 2;
            } else if (v == 2) {
                return 4;
            } else if (v == 3) {
                return 4;
            } else if (v == 4) {
                return 102;
            } else if (v == 5) {
                return 5.1;
            } else if (v == 6) {
                return 40;
            } else if (v == 8) {
                return 9;
            } else if (v == 9) {
                return 10;
            } else if (v == 10) {
                return 11;
            }
            return 0.0;
        }

        /** This holds the information about my weights. */


        /** This holds a copy of the current graph I'm working with. */
        private Graph _G;

        private int _source;

        private boolean _calledEst;

    }

    @Test
    public void test2() {
        DirectedGraph g = new DirectedGraph();
        LabeledGraph<Integer, Double> h = new LabeledGraph<Integer, Double>(g);
        h.add();
        h.add();
        h.add();
        h.add();
        h.add();
        h.add();
        h.add();
        h.remove(1);
        h.add(4, 5, 11.2);
        h.add(4, 2, 12.2);
        h.add(4, 3, 102.0);
        h.add(2, 3, 6.5);
        h.add(5, 3, 9.1);
        h.add(5, 6, 30.0);
        h.add(6, 7, 35.0);
        SSPTester t = new SSPTester(h, 4, 3);
        t.setPaths();
        List<Integer> returnedList = t.pathTo(3);
        assertEquals(0, t.getPredecessor(7));
        assertEquals(0, t.getPredecessor(4));
        assertEquals(4, t.getPredecessor(2));
        assertEquals(5, t.getPredecessor(6));
        assertEquals(4, t.getPredecessor(5));
        assertEquals(2, t.getPredecessor(3));
    }


    @Test
    public void test10() {
        UndirectedGraph g = new UndirectedGraph();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add(1, 3);
        g.add(1, 4);
        g.add(1, 5);
        g.add(2, 6);
        g.add(5, 9);
        g.add(1, 8);
        g.add(5, 7);
    }


    @Test
    public void test3() {
        DirectedGraph g = new DirectedGraph();
        LabeledGraph<Integer, Double> l = new LabeledGraph<Integer, Double>(g);
        l.add();
        l.add();
        l.add();
        l.add();
        l.add(1, 2, 4.0);
        l.add(1, 3, 1.0);
        l.add(3, 2, 2.0);
        l.add(2, 4, 3.0);
        l.add(3, 4, 7.0);
        SSPTester t = new SSPTester(l, 1, 4);
        t.setPaths();
        List<Integer> returnedList = t.pathTo(4);
    }

}
