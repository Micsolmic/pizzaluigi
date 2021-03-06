package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import be.vdab.entities.Saus;

// enkele imports ...
public class SausRepository {
private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
static {
SAUZEN.put(3L, new Saus(3, "cocktail",
Arrays.asList("mayonaise", "ketchup", "cognac")));
SAUZEN.put(6L, new Saus(6, "mayonaise",
Arrays.asList("ei", "mosterd")));
SAUZEN.put(7L, new Saus(7, "mosterd",
Arrays.asList("mosterd", "azijn", "witte wijn")));
SAUZEN.put(12L, new Saus(12, "tartare",
Arrays.asList("mayonaise", "augurk", "tabasco")));
SAUZEN.put(44L, new Saus(44, "vinaigrette",
Arrays.asList("olijfolie", "mosterd", "azijn")));
}
public List<Saus> findAll() {
return new ArrayList(SAUZEN.values());
}
}