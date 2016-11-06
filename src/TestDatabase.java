import model.Database;


public class TestDatabase {

	public static void main(String[] args) {
		System.out.println("Running database");
		Database db = new Database();
		
		try {
			db.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.disConnect();

	}

}
