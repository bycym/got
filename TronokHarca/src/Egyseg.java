import java.awt.*;


public class Egyseg {
	
	private boolean vizi;
	private int ertek;
	private String tipus;
	private Image kep;
	
	public Egyseg(String tipus, Image kep)
	{
		this.tipus = tipus;
		this.kep = kep;
		
		if (tipus.equals("Haj�"))
		{
			
			this.vizi = true;
			this.ertek = 1;
			
		}
		
		else if (tipus.equals("Gyalogos"))
		{
			
			this.vizi = false;
			this.ertek = 1;
			
		}
		
		else if (tipus.equals("Lovag"))
		{
			
			this.vizi = false;
			this.ertek = 2;
			
		}
		
		else return;
		
	}
		public String toString()
		{
			String s = "";
			
			s += this.tipus;
			
			return s;
		}
		
		
	

}
