import model.Database;


public class TestDatabase {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Running database test ...");
		
		Database db = new Database();
		db.connect();
		db.disconnect();

	}

}
