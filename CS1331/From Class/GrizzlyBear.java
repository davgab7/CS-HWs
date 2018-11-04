//********************************************************************
//  GrizzlyBear.java       Author: Stasko
//
//  Demonstrates the basic structure of a Java application.
//********************************************************************

public class GrizzlyBear
{
   protected String name;
	
   public GrizzlyBear(String n) {
      name = n;
   }
	
   public String toString() {
      return name;
   }
   
   public boolean equals(Object o ) {
      GrizzlyBear g;
      
      if (o == null) {
        return false;
      }
      
      if (o instanceof GrizzlyBear) {
         g = (GrizzlyBear)o;
         return name.equals(g.name);    
      }
      else 
         return false; 
   }
   
   
   public static void main (String[] args){
       String s = "gabe";

       GrizzlyBear gb1 = new GrizzlyBear("Gabe");
       System.out.println (gb1);
       GrizzlyBear gb2;
       gb2 = new GrizzlyBear("Gabe");
       if (gb1.equals(gb2))
          System.out.println("Same");
       else
          System.out.println("Different");
   }
}
