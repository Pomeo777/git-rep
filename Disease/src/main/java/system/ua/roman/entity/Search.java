package system.ua.roman.entity;



/**
 * @author Pomeo
 *   class which create object of request on client side.
 *   used to create ModelAndView
 *   have one private  field which is title searched Disease
 *   field have getters and setters
 */
public class Search {

	private String searchName;
	
	public Search() {
		
	}

	/*
	 * method for output to the console information about a  Disease during development
	 * 
	*/
	
	@Override
	public String toString() {
		return "Search [searchName=" + searchName + "]";
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	
	
	
	
}
