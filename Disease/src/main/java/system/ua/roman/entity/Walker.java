package system.ua.roman.entity;



/**
 * @author Pomeo
 * interface some entity which gives us object of Disease
 * it allows us to create many realization for search information in different sources, like DB, file, etc.

 */
public interface Walker {


	
	 public Disease  walk(String text) throws Exception;
	 
	 
	 
	 
}
