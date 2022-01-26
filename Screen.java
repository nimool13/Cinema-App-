

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Screen {
	
    private int ScreenNumber; 
    private int NumberOfSeats; 
    private Cinema Cinema; 
	private ArrayList<Show> Shows = new ArrayList<Show>();
	private Map<Date, ScreenSchedule> schedule = new HashMap<Date, ScreenSchedule>();
	
    public Screen(int screenNumber, int numberOfSeats, Cinema cinema)
    {
    	ScreenNumber = screenNumber;
    	NumberOfSeats = numberOfSeats;
    	Cinema = cinema;
    }
  
    public int getRoomNumber()  
    { 
      return ScreenNumber; 
    } 
    
    public void setRoomNumber(int roomNumber) 
    { 
      ScreenNumber = roomNumber; 
    }    
    
    public int getNumberOfSeats()  
    { 
      return NumberOfSeats; 
    } 
    
    public void setNumberOfSeats(int numberOfSeats) 
    { 
      NumberOfSeats = numberOfSeats; 
    } 
    
    public Cinema getCinema()  
    { 
       return Cinema; 
    } 
  
    public void setCinema(Cinema cinema)  
    { 
      Cinema = cinema; 
      
    } 
    
    
	public void AddShow(Show show) {
		if (!schedule.containsKey(show.getDate()))
			schedule.put(show.getDate(), new ScreenSchedule());

		int hoursThatMustBeBooked = (int) Math.ceil((double) show.getFilm().getLength() / 60);
		int startIndex = show.getShowTime();

		for (int i = startIndex; i < startIndex + hoursThatMustBeBooked; i++) {
			schedule.get(show.getDate()).schedule[i] = true;
		}
		
		Shows.add(show);
	}
    
	
	public ArrayList<Show> GetShows()
	{
		return Shows;
	}
	
    public void RemoveShow(Show show)
    {
    	Shows.remove(show);  	
    }
    
	public boolean IsAvailable(Date date, int showTime, int filmDuration, int intendedNumberOfSeats) {
		if (intendedNumberOfSeats > NumberOfSeats)
			return false;

		int hoursThatMustBeBooked = (int) Math.ceil((double) filmDuration / 60);
		int startIndex = showTime;

		if (schedule.containsKey(date)) {
			var scheduleByDate = schedule.get(date);

			for (int i = startIndex; i < startIndex + hoursThatMustBeBooked; i++) {
				if (scheduleByDate.schedule[i] == true)
					return false;
			}

			return true;
		}

		else
			return true;
	}
}
