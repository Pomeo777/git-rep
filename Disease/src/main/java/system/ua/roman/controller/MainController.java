package system.ua.roman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.ua.roman.dao_change.DAOWritter;
import system.ua.roman.entity.Disease;
import system.ua.roman.entity.NoInformationException;
import system.ua.roman.entity.Search;



/**
 * @author Pomeo
 *
 *   Spring MVC controller
 *   
 *
 */
@Controller 
@RequestMapping(value="/hello")
public class MainController {
	
	@Autowired
	DBWalker walker;
	@Autowired
	DAOWritter daoWritter;
	@Autowired
	Disease dis;
	
	// method for elementary test 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Disease test() {
		return new Disease();
	}
	
	// method return ModelAndView, which contains searched information from user side, used object of class of Searched
	// for  display the search form is used  searched.jsp
    @RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView info(){
   	 ModelAndView modview = new ModelAndView();
   	 modview.addObject("search", new Search());
   	 modview.setViewName("searched");
		return modview;	
	} 
	
    /* 
	*  parameter search - the object of Search class from searched.jsp which contains searched information from user side
	*  method gets information from table  "disease" in DB and return it in ResponseBody
	* 
	*  
	*   when there isn't information in table method return mail about it
	*/
	@RequestMapping(value="/ask", method=RequestMethod.POST)
	public @ResponseBody Disease takeInform(@ModelAttribute("search") Search search) {
		System.out.println(search.toString());
		try {
		dis = walker.walk(search.getSearchName());
		//walker.close();
		return  dis;
		
		}catch(NoInformationException e){
			return new Disease("Mistake", e.print());
		}
	}
	
	
	// method return ModelAndView, which contains searched information from user side, used object of class of Searched
	// for  display the search form is used  choose.jsp
	// in this form user can choose the Disease from list
	@RequestMapping(value="choice", method = RequestMethod.GET)
	public ModelAndView choice() {
		List<String> list = walker.allDisease();
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.addObject("allDisease", list);
		modelAndView.addObject("search", new Search());
		modelAndView.setViewName("choose");
		return modelAndView;
	}
	
	// method return ModelAndView, with path to file that contains information about new disease
	// for  display the add form is used  add.jsp
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView adminUpdate(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("filePath", new Search());
		modelAndView.setViewName("add");
		return modelAndView;
	}
	 /* 
		*  parameter search - the object of Search class from add.jsp which contains path to file 
		*  method add new  information to table  "disease" in DB and return change result   in ResponseBody
		* 
		*  
		*   when there isn't information in table method return mail about it
		*/
		@RequestMapping(value="/addDisease", method=RequestMethod.POST)
		public @ResponseBody String takeDisease(@ModelAttribute("filePath") Search search) {
			System.out.println(search.toString());
			try {
			daoWritter.writte(search.getSearchName());
			//walker.close();
			return  "Succes";
			
			}catch(Exception e){
				return "Failure";
			}
		}
	 
}
