

import java.util.Date;
import java.text.SimpleDateFormat;


public class CinemaMain {

	public static void main(String[] args) {


		
		Film film = new Film("Matrix", 2000, 129);
		Film film2 = new Film("Interstellar", 2014, 165);
		Film film3 = new Film("Gladiator", 2002, 185);
		
		Cinema cinema1 = new Cinema("Filmstaden ", "Testgatan 12");
		
		Screen screen1 = new Screen(1, 250, cinema1);
		Screen screen2 = new Screen(2, 120, cinema1);
		Screen screen3 = new Screen(3, 180, cinema1);
		
		cinema1.AddScreen(screen1);
		cinema1.AddScreen(screen2);
		cinema1.AddScreen(screen3);
		
		Film movie = new Film("No time to die", 2020, 149);
		Film movie2 = new Film("Jumanji", 2020, 100);
		Film movie3 = new Film("Star Wars Jedi", 2020, 135);
	
		
		Cinema cinema2 = new Cinema ("Bioplatset ","Centrum ");
		Screen screenA = new Screen(1 , 150, cinema2);
		Screen screenB = new Screen(2 , 70 , cinema2);
		Screen screenC = new Screen(3 , 50 , cinema2);
		cinema2.AddScreen(screenA);
		cinema2.AddScreen(screenB);
		cinema2.AddScreen(screenC);
		
		
		Date date = CreateDate("2020-04-12");
		cinema1.CreateShowTime(film, date, 10, 150);
	
		date = CreateDate("2020-04-12");
		cinema1.CreateShowTime(film2, date, 17, 110);
		
		date = CreateDate("2020-04-12");
		cinema1.CreateShowTime(film3, date, 18, 50);
		
					
		cinema2.CreateShowTime(movie , date , 12 , 40);
		cinema2.CreateShowTime(movie2 , date , 18 , 35);
		cinema2.CreateShowTime(movie3, date , 14 , 30);
		
		
		var shows = cinema1.ListShowsAtDate(date);
		var shows1 = cinema2.ListShowsAtDate(date);
		System.out.println("Movies in Filmstaden cinema :");
		for(var show: shows)
		{
			System.out.println(show);
		}
		System.out.println("Movies in Bioplatset cinema :");
		for (var show1 : shows1) {
			System.out.println(show1);
		}
	}

	public static Date CreateDate(String strDate) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			Date date = simpleDateFormat.parse(strDate);
			return date;
		} catch (Exception ex) {
			System.err.println("Date is invalid");
			return null;
		}
	}
}