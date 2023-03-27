package TugasKelompokT;

import java.util.*;

public class Family {
	Set<Uncle> uncles;
	List<Niece> nieces;
	
	public Family() {
		this.uncles = new HashSet<>();
		this.nieces = new ArrayList<>();
	}
	
	public boolean addNiece(String name, int day, int month) {
		if(findNiece(name) == null) {
			Niece niece = new Niece(name, day, month);
			nieces.add(niece);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addUncle(String name) {
		if(findUncle(name) == null) {
			Uncle uncle = new Uncle(name);
			uncles.add(uncle);
			return true;
		} else {
			return false;
		}
	}
	
	public Niece findNiece(String name) {
		for(Niece person : nieces) {
			if(person.getName().equals(name)) return person;
		}
		
		return null;
	}
	
	public Uncle findUncle(String name) {
		for(Uncle person : uncles) {
			if(person.getName().equals(name)) return person;
		}
		
		return null; 
	}
	
	public void listNieces() {
		System.out.println("\n============ List of Nieces =============");
	    nieces.stream()
	          .sorted(Comparator.comparing(Niece::getMonth).thenComparing(Niece::getDay))
	          .forEach(niece -> System.out.println(niece.getName() + "\t" + niece.getDay() + "/" + niece.getMonth()));
	}
	
	public void listUncles() {
		Set<String> names = new TreeSet<>();
		int i = 1;
		
		for(Uncle person : uncles) {
			names.add(person.getName());
		}
		
		System.out.println("\n============ List of Uncles =============");
		for(String name : names) {
			System.out.println(i+ ". " + name);
			i += 1;
		}
	}
	
	public Set<Uncle> getUncles() {
		return uncles;
	}

	public List<Niece> getNieces() {
		return nieces;
	}
	
}
