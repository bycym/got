import java.awt.*;
import java.util.*;

public class Haz {
	
	private String nev;
	private Color szin;
	private Image kep;
	private Vector<Parancsjelzo> parancsjelzok;
	private Vector<Hazjelzo> hazjelzok;
	private int hordo;
	
	public Haz(String nev, Image kep)
	{
		this.hordo = 0;
		this.nev = nev;
		this.kep = kep;
		this.parancsjelzok = new Vector<Parancsjelzo>();
		this.hazjelzok = new Vector<Hazjelzo>();
		
		//ezt belerakhatjuk egy f�jlba mint a ter�leteket, h�zakat
		parancsjelzok.add(new Parancsjelzo("támadás", false, 0, null));
		parancsjelzok.add(new Parancsjelzo("támadás", false, -1, null));
		parancsjelzok.add(new Parancsjelzo("támadás", true, +1, null));
		
		parancsjelzok.add(new Parancsjelzo("védekezés", false, +0, null));
		parancsjelzok.add(new Parancsjelzo("védekezés", false, +0, null));
		parancsjelzok.add(new Parancsjelzo("védekezés", true, +1, null));
		
		parancsjelzok.add(new Parancsjelzo("támogatás", false, +0, null));
		parancsjelzok.add(new Parancsjelzo("támogatás", false, +0, null));
		parancsjelzok.add(new Parancsjelzo("támogatás", true, +1, null));
		
		parancsjelzok.add(new Parancsjelzo("korona", false, +1, null));
		parancsjelzok.add(new Parancsjelzo("korona", false, +1, null));
		parancsjelzok.add(new Parancsjelzo("korona", true, +1, null));
		
		parancsjelzok.add(new Parancsjelzo("portya", false, +1, null));
		parancsjelzok.add(new Parancsjelzo("portya", false, +1, null));
		parancsjelzok.add(new Parancsjelzo("portya", true, +2, null));
		//kezdeti hazjelzok
		for(int i=0; i<5; i++){
			hazjelzok.add(new Hazjelzo(null,this));
		}
		
		if (nev.equals("Lennister"))
		{
			this.szin = Color.red;
		}
		
		else if (nev.equals("Stark"))
		{
			this.szin = Color.gray;
		}
		
		else if (nev.equals("Greyjoy"))
		{
			this.szin = Color.black;
		}
		
		else if (nev.equals("Tyrell"))
		{
			this.szin = Color.green;
		}
		
		else if (nev.equals("Baratheon"))
		{
			this.szin = Color.yellow;
		}
		
		else return;
	}
	
	
	public String getNev() { return this.nev; }
	public Color getColor() { return this.szin; }
	public int getHordo() { return this.hordo; }
	public Image getKep() { return this.kep; }
	public Parancsjelzo getParancsjelzo(int i)
	{
		return this.parancsjelzok.get(i);
	}
	public void removeParancs(Parancsjelzo parancs)
	{
		parancsjelzok.remove(parancs);	
	}
	public void addParancs(Parancsjelzo parancs)
	{
		parancsjelzok.add(parancs);
	}
	//hazjelzo
	public void setHordo(int h){ this.hordo = h; }
	
	public String toString()
	{
		String s = this.nev + "\n";
		Iterator<Parancsjelzo> pIt = parancsjelzok.iterator();
		s += "Parancsjelzok: ";
		while (pIt.hasNext()) s+=pIt.next().toString() + " ";
		
		s+= "\nHazjelzok: " + hazjelzok.size() + "\n";
		
		s += "Hordok: " + this.hordo + "\n";
		return s;
	}
	//Gyuri,Aron
	
	
	//unatkoztam ugyhogy kivertem, és megfogant az ötlet:
	
	
	//szal eltávolítja a bekapott házjelző, elvileg azt fogja dobni amit bekér
	public void removeHazjelzo(Hazjelzo h)
	{
		this.hazjelzok.remove(h);
	}
	
	//hazjelzo ~= pénz
	public void addHazjelzo()
	{
		//nekem itt rossz érzésem van
		hazjelzok.add(new Hazjelzo(this.kep, this));
	}
	
	public int DBHazjelzo()
	{
		return this.hazjelzok.size();
	}
	
	// /Gyuri,Aron
}
