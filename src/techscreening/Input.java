package techscreening;

public class Input {

	  public static void main(String[] args) {
		  /*
		   * run from here.
		   * The input method provides the body of the call.
		   * This is passed through the communicator which in turn tells the database.
		   */
		  Communicator communicator = new Communicator();
		  communicator.start_database();
		  String status1 = communicator.Send(12345, "AA:BB:CC:DD:EE:FF");
		  System.out.println(status1);
		  String status2 = communicator.Send(12345, "AA:BB:CC:DD:EE:AA");
		  System.out.println(status2);
		  String status3 = communicator.Send(11111, "AA:BB:CC:DD:EE:FF");
		  System.out.println(status3);
	  }

}
