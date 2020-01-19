

public class SAP {
    
    private int len;
    private int ancestor;
    private BreadthFirstDirectedPaths bfs;
    private BreadthFirstDirectedPaths bfs1;
    private Digraph G;

    public SAP(Digraph G) {             //CONSTRUCTOR
        check(G);
        ancestor = -1;
        len = G.V()+1;
        this.G =G;
    }

    // method to find length of shortest ancestral path between v and w,
    // returns -1 if no path
    public int length(int v, int w) {

        if (v < 0 || v > G.V() || w < 0 || w > G.V()) {
            throw new IllegalArgumentException();

        }

        len = G.V()+1;
        bfs = new BreadthFirstDirectedPaths(G, v);
        bfs1 = new BreadthFirstDirectedPaths(G, w);

        for (int i = 0; i < G.V(); i++) {
            if (bfs.hasPathTo(i) && bfs1.hasPathTo(i)) {
                int temp = bfs.distTo(i) +bfs1.distTo(i);

                if (temp < len) {
                    ancestor = i;
                    len = temp;
                }
            }

        }
        if (len!= G.V()+ 1) {
            return len;
        }
        return -1;
    }

    // method to find common ancestor of v and w 
    public int ancestor(int v, int w) {
        if (v < 0 || v >G.V() || w < 0 || w >G.V()) {

            throw new IllegalArgumentException();
        }

        length(v,w);
        return ancestor;
    }

    // method to find length of shortest ancestral path between any vertex in v and any vertex in w
    //returns -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        check(v);check(w);

        int tempLen = G.V()+1;
        int len = G.V()+1;
        int s =-1;
        int e =-1;

        for (int start: v) {
            for (int end: w) {
                len = length(start, end);
                if (len < tempLen) {
                    s = start;
                    e = end;
                    tempLen = len;
                }
            }
        }
        if (s != -1 || e != -1) {
            return length(s,e);
        }
        return-1;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        check(v);
        check(w);
        length(v, w);

        return ancestor;
    }

    private void check(Object obj) {
        if (obj == null) {

            throw new IllegalArgumentException();
        
        }
    }

    public static void main(String[] args) {
       
    }
    
}


