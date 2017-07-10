package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService service;

    @RequestMapping(value = { "/","home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
    @RequestMapping(value = { "/hr"}, method = RequestMethod.GET)
    public String ListPage(ModelMap model) {
    //	System.out.println(service.getUser("salkdm").getRole());
        return "hr";
    }
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
     model.addAttribute("user", new User());
        return "login";
    }
    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public String adminPage(Model model) {
     model.addAttribute("user", new User());
        return "admin";
    }
 
}
