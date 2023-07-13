package techscreening;
import java.util.*;

public class Database {
	/*
	 * Fake database that keeps track of the registered terminals
	 */
    Set<String> registerdMacAdresses = new HashSet<String>();
    Map<String, Integer> activeTerminal = new HashMap<String, Integer>();

    private boolean check_mac(String macAdress) {
    	/*
    	 * test if the mac adress is in the list of known terminals.
    	 */
    	return registerdMacAdresses.contains(macAdress);
    }
    
    private boolean check_available(int customerId, String macAdress) {
    	/*
    	 * check if the terminal is already registered.
    	 * If not register it to the give customer.
    	 */
    	boolean activated = activeTerminal.containsKey(macAdress);
    	if (!activated) {
    		activeTerminal.put(macAdress,customerId);
    		return true;
    	}else if(activeTerminal.get(macAdress)==customerId) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public String Add(int customerId, String macAdress) {
    	/*
    	 * Check if the id mac adress combination is valid and
    	 * add it to the database if so. 
    	 * If not return a negative response.
    	 */
    	if (!check_mac(macAdress)) {
    		return "Response: 404 Not Found";
    	}else if (!check_available(customerId, macAdress)){
    		return "Response: 409 Conflict";
    	}else {
    		return "Response: 201 Created";
    	}
    }
    
    public void register_mac_adress(Set<String> macAdresses) {
    	/*
    	 * Make the set of known mac adresses.
    	 */
    	registerdMacAdresses = macAdresses;
    }
}
