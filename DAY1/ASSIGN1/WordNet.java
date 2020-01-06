import java.io.*; 
public class WordNet {
   public WordNet(String synsets, String hypernyms) throws IOException{
      parseSynset(synsets);
      parseHypernyms(hypernyms);
      
   }
   private void parseSynset(String synsets) throws IOException{
      FileReader fr1 =  new FileReader(synsets + ".txt"); 
      BufferedReader br = new BufferedReader(fr1);
      String i; 
     while ((i=br.readLine()) != null) {
         String arr1[] =i.split(","); 
         System.out.println(arr1);
      }
   }

   private void parseHypernyms(String hypernyms) throws IOException{
      FileReader fr2 =  new FileReader( hypernyms + ".txt"); 
      BufferedReader br = new BufferedReader(fr2);
      String j; 
     while ((j=br.readLine()) != null) {
         String arr2[] =j.split(","); 
         System.out.println(arr2);
      }
   }
   public static void main(String[] args) throws IOException{ 
      WordNet Obj = new WordNet("synsets", "hypernyms");
      
     }
       
}