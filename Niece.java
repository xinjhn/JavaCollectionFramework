package TugasKelompokT;

import java.util.Set;
import java.util.TreeSet;

public class Niece extends Family{
	private String name;
	private int day, month;
	private Set<String> gifts = new TreeSet<>();
	
	public Niece(String name, int day, int month) {
		this.name = name;
		this.day = day;
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public Set<String> getGift() {
		return gifts;
	}
	
	public void setGift(String present) {
		gifts.add(present);
	}
	
	public int clearPresents() {
		int total = gifts.size();
		gifts.clear();
		return total;
	}
	
	public void listPresents(Set<Uncle> uncles) {
		boolean dapat;
		Set<String> hasil = new TreeSet<>(); 
		
		for(Uncle person : uncles) {
			dapat = false;
			for(String gift : gifts) {
				if(person.getPresent().contains(gift)) {
					hasil.add(person.getName() + " memberi hadiah " + gift + " ke " + name);
					dapat = true;
				}
			}
			if(!dapat) hasil.add(person.getName() + " tidak memberi hadiah ke " + name);
		}
		
		for(String tampilkan : hasil) {
			System.out.println(tampilkan);
		}
	}
}