

import java.util.Date;

public class Show {
	
	private Film Film;
	private Screen Screen;
    private Date Date;
    private int ShowTime;
    
    
    public Show(Film film,Screen screen, Date date, int showTime)
    {
    	Film = film;
    	Screen = screen;
    	Date = date;
    	ShowTime = showTime;
    }
    
    public Film getFilm()  
    { 
      return Film; 
    } 
    
    public void setFilm(Film film) 
    { 
      Film = film; 
    }  
    
    public Date getDate()  
    { 
      return Date; 
    } 
    
    public void setDate(Date date) 
    { 
      Date = date; 
    }    
    
    public int getShowTime()  
    { 
      return ShowTime; 
    } 
    
    public void setShowTime(int showTime) 
    { 
      ShowTime = showTime; 
    }   
    
    public Screen getScreen()  
    { 
      return Screen; 
    } 
    
    public void setScreen(Screen screen) 
    { 
      Screen = screen; 
    }  
}
