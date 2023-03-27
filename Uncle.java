package TugasKelompokT;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Uncle extends Family{
	private String name;
	private Set<String> present;
	
	public Uncle(String name) {
		this.name = name;
		present = new TreeSet<>();
	}

	public String getName() {
		return name;
	}

	public Set<String> getPresent() {
		return present;
	}
	
	public boolean addPresent(Niece recipient, String description, List<Niece> nieces) {
		boolean ada = false;
		for(Niece gift : nieces) {
			if(gift.getGift().contains(description)) ada = true;
		}
		
		if(!ada) {
			present.add(description);
			recipient.setGift(description);
			return ada;
		} else {
			System.out.println("Hadiah Sudah Ada, pilih hadiah lainnnya");
			return ada;
		}
	}
	
	public void listPresents(List<Niece> nieces) {
		boolean dapat;
		Set<String> hasil = new TreeSet<>(); 
		
		for(Niece person : nieces) {
			dapat = false;
			for(String gift : present) {
				if(person.getGift().contains(gift)) {
					hasil.add(person.getName() + " mendapatkan hadiah " + gift + " dari " + name);
					dapat = true;
				}
			}
			if(!dapat) hasil.add(person.getName() + " tidak mendapat hadiah dari " + name);
		}
		
		for(String tampilkan : hasil) {
			System.out.println(tampilkan);
		}
	}	
}
