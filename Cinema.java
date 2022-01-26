

import java.util.Date;


import java.util.ArrayList;

public class Cinema {
	private String Name;
	private String Address;
	private ArrayList<Screen> Screens = new ArrayList<Screen>();

	public Cinema(String name, String address) {
		Name = name;
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void AddScreen(Screen screen) {
		Screens.add(screen);
	}

	public void RemoveScreen(Screen screen) {
		Screens.remove(screen);
	}


	public ArrayList<String> ListShowsAtDate(Date date) {
		
		ArrayList<String> showDetails = new ArrayList<String>();
	
		for(var screen: Screens)
		{
			for(var show: screen.GetShows())
			{
				if(show.getDate().compareTo(date) == 0)
				{
					showDetails.add(show.getFilm().getName() +" with total duration of  "+ show.getFilm().getLength()+ " minutes at " + show.getShowTime() + " O'clock  in room " + show.getScreen().getRoomNumber());
				}
			}
		}
		 
		return showDetails;
	}

	public void CreateShowTime(Film film, Date date, int showTime, int intendedNumberSeats) {
		
		if(film == null || showTime < 0 || showTime > 24)
		{
			System.err.println("Could not create the show. Inputs are invalid.");
			return;
		}		
		
		// Film must start and end in a same day
		if(showTime + (int) Math.ceil((double) film.getLength()/ 60) > 24)
		{
			System.err.println("Could not create the show. Show must start and end in a same day.");
			return;
		}
			
		for(var screen: Screens)
		{
			if(screen.IsAvailable(date, showTime, film.getLength(), intendedNumberSeats))
			{
				Show show = new Show(film, screen, date, showTime);
				screen.AddShow(show);
				System.out.println("The show was successfully created in " +this.Name+ "cinema on screen :" + screen.getRoomNumber());
				return;
			}
		}
		
		System.out.println("No Screen could be found that could meet the requested show requirements.");
	}
}
