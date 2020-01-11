import java.io.*; 
public class Solution{
   public Solution(String email, String connections) throws IOException{
      emails(email);
      Digraph g= new Digraph(d);
      connections(connections);
      
   }
   private void emails(String email) throws IOException{
      FileReader fr1 =  new FileReader("D:\\OOP\\ADS-2_2019501017\\ADS-2 EXAM1\\ADS - 2 Exam - 1\\emails.txt"); 
      BufferedReader br = new BufferedReader(fr1);
      String i; 
      int x = 0;
      int d=0; 
      while ((j=br.readLine()) != null) {
          d++;  
      }
      while ((i=br.readLine()) != null) {
         String arr1[] =i.split(";");
         String emails[x] = arr1[1];
         x++; 
        // System.out.println(arr1[0]);
      }
   }

   private void connections(String connections) throws IOException{
      FileReader fr2 =  new FileReader( "D:\\OOP\\ADS-2_2019501017\\ADS-2 EXAM1\\ADS - 2 Exam - 1\\email-logs.txt"); 
      BufferedReader br = new BufferedReader(fr2);
      String j;
      int c=0; 
     while ((j=br.readLine()) != null) {
         c++;  
      }
      System.out.println(c);
      while ((j=br.readLine()) != null){
         String arr2[] =j.split(" ");
         Integer recieverid[]=Integer.parseInt(arr2[3]);
         g.addEdge(Integer.parseInt(arr2[1]),Integer.parseInt(arr2[3]));
      }
      
     
   }
   public static void main(String[] args) throws IOException{ 
    Solution Obj = new Solution("email", "connections");
    
   }
     
}