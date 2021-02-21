class Main 
{ 
    public static void main(String args[]) 
    { 
        Singleton S = Singleton.getInstance(); 
  
             S.st = (S.st).toUpperCase(); 
  
        System.out.println("String x is " + S.st); 
      
        
    } 
} 
class Singleton 
{ 
    
    public String st;
    private static Singleton single = null; 
    
     private Singleton() 
    { 
        st = "singleton_class"; 
    } 
  public static Singleton getInstance() 
    { 
      
        if (single == null) 
            single = new Singleton(); 
  
        return single; 
    } 
}