package techscreening;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;


public class Communicator {
	/*
	 * communicates between the input and the database.
	 */
	Database database = new Database();

	public String Send(int customerId, String macAdress) {
		/*
		 * when input is provided send it to the database and 
		 * return a simplified output.
		 */
		Logger logger = Logger.getLogger("newLoggerName");
		String response = database.Add(customerId, macAdress);
		switch (response) {
		case "Response: 201 Created":
			logger.info("The terminal"+macAdress+" is activated for user" +customerId+".");
			return "ACTIVE";
		case "Response: 409 Conflict":
			logger.warning("The terminal is already activated by an other user.");
			return "INACTIVE";
		case "Response: 404 Not Found":
			logger.warning("The terminal is not known by the systeem, check the adress and try again.");
			return "INACTIVE";
		default:
			return "ACTIVE";
		}
	}
	
	public void start_database() {
		/*
		 * Start the database with a list of known mac adresses.
		 */
		Set<String> adresses = new HashSet<String>();
		adresses.add("AA:BB:CC:DD:EE:FF");
		database.register_mac_adress(adresses);
	}
}
