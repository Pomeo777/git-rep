package system.ua.roman.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Pomeo
 *		Base entity which contains title and description a Disease
 *		have 2 field, which are private and respectively have getters and setters.
 */

@Component
@Scope("prototype")
public class Disease {
	
	//these initializations are only for debugging at design time
	private String disease = "NoN";
	private String context = "NoN";
	
	public Disease() {	
		System.out.println("disease is create");
	}
	
	public Disease(String diseas, String context) {
		this.context = context;
		this.disease = diseas;	
	}

	public String getDiseas() {
		return disease;
	}

	public void setDiseas(String diseas) {
		this.disease = diseas;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	
	/*
	 * method for output to the console information about a  Disease during development
	 * 
	*/
	@Override
	public String toString() {
		return "Disease [diseas=" + disease + ", context=" + context + "]";
	}
	
	
	
}
