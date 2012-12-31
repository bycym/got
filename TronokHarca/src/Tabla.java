import java.util.*;

public class Tabla {
	
	public static Vector<Tenger> teruletek = new Vector<Tenger>();
	public static Vector<Haz> vastron = new Vector<Haz>();
	public static Vector<Haz> kard  = new Vector<Haz>();
	public static Vector<Haz> hollo  = new Vector<Haz>();
	public static int vadakEreje = 0;
	
	
	//Gyuri,�ron
	public static Haz aktHaz;
	public static Tenger aktTer;
	public static void kovHaz() { };
	// /Gyuri,�ron
	
 	public static Haz getHaz(String nev)
	{
		Iterator<Haz> it = vastron.iterator();
		Haz aktHaz;
		while (it.hasNext())
		{
			
			aktHaz = it.next();
			String aktNev = aktHaz.getNev();
			
			if (aktNev.equals(nev)) return aktHaz;
		}
		
		return null;
	}
	
	public static String toString1()
	{
		String s = "";
		Iterator<Tenger> terIt = teruletek.iterator();
		s += "Teruletek:\n";
		while (terIt.hasNext())
		{
			Tenger aktTer = terIt.next();
			s += "    " + aktTer.toString();
			s += "\n";
		}
		
		s += "\n";
		
		Iterator<Haz> hazIt = vastron.iterator();
		s += "H�zak:\n";
		while (hazIt.hasNext())
		{
			Haz aktHaz = hazIt.next();
			s += "    " + aktHaz.getNev();
			s += "\n";
		}
		
		return s;
	}
	
	public static void setHordo()
	{
		Iterator<Haz> hazit = vastron.iterator();
		Iterator<Tenger> terit = teruletek.iterator();
		while (hazit.hasNext())
		{
			int hordo = 0;
			int db = 0;
			aktHaz = hazit.next();
			String aktNev = aktHaz.getNev();
			System.out.println(aktNev);
			
			while(terit.hasNext())
			{
				System.out.println(db);
				db++;
				aktTer = terit.next();
				if(aktTer.getHaz() != null)
				{
					String aktTulj = aktTer.getHaz().getNev();
					if (aktNev.equals(aktTulj) && !aktTer.getTipus())
					{
						System.out.println(aktTer.getNev()+" - "+aktTulj + ": "+hordo);
						hordo += aktTer.getHordo();
					}
				}
				
			}
			
		}
		
	}
}
