package fr.n7.fut.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.n7.fut.model.users.User;
import fr.n7.fut.service.UserService;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value={"/achat-pack"}, method = RequestMethod.GET)
    public ModelAndView achatpack(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("achat-pack");
        return modelAndView;
    }

    @RequestMapping(value={"/profil"}, method = RequestMethod.GET)
    public ModelAndView profil(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profil");
        return modelAndView;
    }

    @RequestMapping(value={"/joueur"}, method = RequestMethod.GET)
    public ModelAndView joueur(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("joueur");
        return modelAndView;
    }

    @RequestMapping(value={"/resultat-match"}, method = RequestMethod.GET)
    public ModelAndView resultatmatch(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resultat-match");
        return modelAndView;
    }

    @RequestMapping(value={"/preparation-match"}, method = RequestMethod.GET)
    public ModelAndView preparationmatch(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("preparation-match");
        return modelAndView;
    }

    @RequestMapping(value={"/gestion-equipe"}, method = RequestMethod.GET)
    public ModelAndView gestionequipe(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gestion-equipe");
        return modelAndView;
    }

    @RequestMapping(value={"/access-denied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome you " + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin FieldRole");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value="/dashboard", method= RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }


}
