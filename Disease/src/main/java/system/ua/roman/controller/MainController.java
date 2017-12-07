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
import system.ua.roman.entity.Search;


@Controller 
@RequestMapping(value="/hello")
public class MainController {
	
	@Autowired
	DBWalker walker;
	@Autowired
	DAOWritter daoWritter;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody Disease test() {
		return new Disease();
	}
	
    @RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView info(){
   	 ModelAndView modview = new ModelAndView();
   	 modview.addObject("search", new Search());
   	 modview.setViewName("searched");
		return modview;	
	} 
	
	@RequestMapping(value="/ask", method=RequestMethod.POST)
	public @ResponseBody Disease takeInform(@ModelAttribute("search") Search search) {
		System.out.println(search.toString());
		try {
		Disease di = walker.walk(search.getSearchName());
		//walker.close();
		return  di;
		
		}catch(Exception e){
			return new Disease("Mistake", "There is not that Diases in BD");
		}
	}
	@RequestMapping(value="choice", method = RequestMethod.GET)
	public ModelAndView choice() {
		List<String> list = walker.allDisease();
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.addObject("allDisease", list);
		modelAndView.addObject("search", new Search());
		modelAndView.setViewName("choose");
		return modelAndView;
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView adminUpdate(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("filePath", new Search());
		modelAndView.setViewName("add");
		return modelAndView;
	}
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
