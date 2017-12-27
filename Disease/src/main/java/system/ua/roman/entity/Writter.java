package system.ua.roman.entity;



/**
 * @author Pomeo
 *
 * interface some entities  which gives us do some actions like add, delete, etc.
 * it allows us to create many realization for changes  in different sources, like DB, file, etc.
 * 
 *           in the future will have different methods
 */


public interface  Writter {

	
	//method for add a Disease 
	void writte(String a);
}
