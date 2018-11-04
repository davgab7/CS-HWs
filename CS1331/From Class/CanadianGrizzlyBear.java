//********************************************************************
//  CanadianGrizzlyBear.java       Author: Stasko
//
//  Demonstrates the basic structure of a Java application.
//********************************************************************

public class CanadianGrizzlyBear extends GrizzlyBear
{
   protected String province;
	
   public CanadianGrizzlyBear(String n, String p) {
      super(n);
      province = p;
   }
   
   public String toString() {
      return "Eh, I'm "+super.toString()+ " from " + province;
      }
      
   public boolean equals(Object o) {
     if (o == null)
        return false;
        
     if (this.getClass() != o.getClass())
        return false;
        
     if (o instanceof CanadianGrizzlyBear) {
        CanadianGrizzlyBear cgb = (CanadianGrizzlyBear) o;
        return (name.equals(cgb.name)) && (province.equals(cgb.province));
     }
     return false;
   }
	
   public static void main (String[] args){
      CanadianGrizzlyBear gb1 = new CanadianGrizzlyBear("Hoser","manitoba");
      System.out.println (gb1);
      CanadianGrizzlyBear gb2 = new CanadianGrizzlyBear("Hoser","alberta");
      GrizzlyBear gb = new GrizzlyBear("Hoser");
		
      if (gb1.equals(gb))
         System.out.println("Same");
      else
         System.out.println("Diff");
			
   }
}
