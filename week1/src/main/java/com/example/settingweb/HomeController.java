package com.example.settingweb;

import java.util.List;
import java.util.Locale;

import com.example.service.MovieService;
import com.example.vo.MovieVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MovieService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home(Locale locale, Model model) throws Exception {
		logger.info("home");
		List<MovieVO> movieVOList = service.selectMovie();
		model.addAttribute("movieList", movieVOList);
		return "home";
	}
	
}
