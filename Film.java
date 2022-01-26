

import java.util.ArrayList;

public class Film {
	
    private String Name; 
    private int ReleaseYear; 
    private int Length; 
    private ArrayList<Show> Shows = new ArrayList<Show>();
  
    public Film(String name, int releaseYear, int length)
    {
    	if(name == null || name == "" || releaseYear < 1900 || releaseYear > 2025 || length < 0 || length > 300)
    	{
    		System.err.println("Could not create the film. Inputs are invalid.");
    		return;
    	}
    	
    	Name = name;
    	ReleaseYear = releaseYear;
    	Length = length;
    }
    
    public String getName()  
    { 
      return Name; 
    } 
    
    public void setName(String name) 
    { 
      Name = name; 
    }    
    
    public int getReleaseYear()  
    { 
      return ReleaseYear; 
    } 
    
    public void setReleaseYear(int releaseYear) 
    { 
      ReleaseYear = releaseYear; 
    } 
    
    public int getLength()  
    { 
       return Length; 
    } 
  
    public void setLength(int length)  
    { 
      Length = length; 
    } 
    
    
    public void AddShow(Show show)
    {
    	Shows.add(show);
    }
    
}
