
import java.util.EventObject;

public class FormEvent extends EventObject {
	private String name;
	private String occupation;

	public FormEvent(Object arg0) {
		super(arg0);
		
	}
	
	public FormEvent(Object arg0, String name, String occupation) {
		super(arg0);
		this.name = name;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	

}
