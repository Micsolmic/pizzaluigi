package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

public class SausRepository {
	
	
	
	private static Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
	
	
	static {		
		SAUZEN.put(51L, new Saus(51, "cocktail", Arrays.asList("ei, zout, tomaatextract")));
		SAUZEN.put(52L, new Saus(52, "mayonnaise", Arrays.asList("ei, zout, mayo")));
		SAUZEN.put(53L, new Saus(53, "mosterd", Arrays.asList("mosterd, zout, azijn")));		
	}
	
	
	public static List<Saus> findAll(){
		
		return new ArrayList<>(SAUZEN.values());		
		
	}

}
