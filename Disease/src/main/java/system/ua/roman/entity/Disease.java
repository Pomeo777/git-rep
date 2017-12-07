package system.ua.roman.entity;

public class Disease implements Entity{

	private String diseas = "d";
	private String context = "c";
	
	public Disease() {	
		System.out.println("disease is create");
	}
	
	public Disease(String diseas, String context) {
		this.context = context;
		this.diseas = diseas;	
	}

	public String getDiseas() {
		return diseas;
	}

	public void setDiseas(String diseas) {
		this.diseas = diseas;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Disease [diseas=" + diseas + ", context=" + context + "]";
	}
	
	
	
}
