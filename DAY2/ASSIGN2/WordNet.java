import java.io.*; 
public class WordNet {
   int c = 0;
   int counte = 0;
   public WordNet(String synsets, String hypernyms) throws IOException{
      // parseSynset(synsets);
      parseHypernyms(hypernyms);
      
      
      
   }
   // private void parseSynset(String synsets) throws IOException{
   //    FileReader fr1 =  new FileReader(synsets + ".txt"); 
   //    BufferedReader br = new BufferedReader(fr1);
   //    String i; 
   //   while ((i=br.readLine()) != null) {
   //       String [] arr1 =i.split(","); 
   //       // System.out.println(arr1[0]);
   //       c++;
   //    }
   //    br.close();
   //    System.out.println(c);
   // }

   private void parseHypernyms(String hypernyms) throws IOException{
      FileReader fr2 =  new FileReader( hypernyms + ".txt"); 
      BufferedReader br = new BufferedReader(fr2);
      String j;
      while ((j=br.readLine()) != null) {
            c++;
      }
      //System.out.println("jkacbns");
      Digraph g = new Digraph(c); 
      while ((j=br.readLine()) != null) {
         System.out.println("ljaskn .cl");
         String arr2[] =j.split(",");
         System.out.println(arr2.length);
         for (int i = 1; i < arr2.length; i++){
            g.addEdge(Integer.parseInt(arr2[0]),Integer.parseInt(arr2[i]));
            
         }
      }
      // for(int i = 0; i < c; i++){
      //    for(int w : g.adj[i]){
      //       counte++;
      //    }
      // }
      System.out.println(c);
      System.out.println(counte);
      br.close();
   }
   public static void main(String[] args) throws IOException {
      WordNet object = new WordNet("synsets", "hypernyms");
      
   }      
}