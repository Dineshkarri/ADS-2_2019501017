
public class WordNet {
    private ST<String, Bag<Integer>> symbolTable = new ST<>();
    private Digraph dg;
    private ArrayList<String> nounList=new ArrayList<>();
    private SAP sap;

    public WordNet(String synsets, String hypernyms) {
        check(hypernyms);
        check(synsets);
        
        In synsetsIn = new In(synsets);
        int V = 0;
        while (synsetsIn.hasNextLine()) {

            String[] syns = synsetsIn.readLine().split(",");
            int id = Integer.parseInt(syns[0]);
            String[] nouns = syns[1].split(" ");
            for (String noun : nouns) {

                if (symbolTable.contains(noun)) {
                    symbolTable.get(noun).add(id);
                } else {
                    Bag<Integer> bag =new Bag<Integer>();
                    bag.add(id);
                    symbolTable.put(noun,bag);
                }
            }
            V++;

            nounList.add(syns[1]);
        }

        dg =new Digraph(V);

        In hypernymsIn =new In(hypernyms);

        while (hypernymsIn.hasNextLine()) {
            String[] hyp = hypernymsIn.readLine().split(",");
            int childId = Integer.parseInt(hyp[0]);

            for (int i = 1; i < hyp.length; i++) {
                int parentId = Integer.parseInt(hyp[i]);
                dg.addEdge(childId, parentId);
            }
        }

        sap =new SAP(dg);
    }

    public Iterable<String> nouns() {
        return symbolTable.keys();
    }

    public boolean isNoun(String word) {
        check(word);

        return symbolTable.contains(word);
    }

    public int distance(String nounA, String nounB) {
        check(nounA);check(nounB);
        Bag<Integer> end =symbolTable.get(nounB);
        Bag<Integer> start =symbolTable.get(nounA);
        
        return sap.length(start,end);
    }

    public String sap(String nounA, String nounB) {
        check(nounA);check(nounB);
        Bag<Integer> start =symbolTable.get(nounA);
        Bag<Integer> end =symbolTable.get(nounB);
        
        int ancestor =sap.ancestor(start, end);

        return nounList.get(ancestor);
    }

    private void check(Object obj) {
        if (obj == null) {

            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {    
    }
}
