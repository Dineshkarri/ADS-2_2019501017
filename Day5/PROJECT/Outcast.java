public class Outcast {
    private WordNet wn;

    public Outcast(WordNet wn) {
        check(wn);
        this.wn = wn;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        check(nouns);
        
        int[] distance =new int[nouns.length];
        for (int i = 0; i < nouns.length - 1; i++) {

            for (int j = i + 1; j < nouns.length; j++) {

                int dist = wn.distance(nouns[i],nouns[j]);
                if (i != j) distance[j] =distance[j]+ dist;
                            distance[i] =distance[i]+dist;
            }
        }

        int maxInd =0;
        int maxdist =0;
        
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] > maxdist) {
                maxdist =distance[i];
                maxInd =i;
            }
        }

        return nouns[maxInd];
    }

    private void check(Object obj) {
        if (obj == null) {

            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
    }
}
