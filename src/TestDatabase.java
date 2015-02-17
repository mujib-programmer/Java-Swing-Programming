import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;


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
		
		db.add( new Person( "Joe", "lion tamer", AgeCategory.adult,  EmploymentCategory.employed,     "777", true,  Gender.male ) );
		db.add( new Person( "Sue", "artist" , AgeCategory.adult, EmploymentCategory.selfEmployed, null,  false, Gender.female ) );
		
		db.save();
		
		db.loadDatabase();
		
		db.disconnect();

	}

}
