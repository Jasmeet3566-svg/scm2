package com.scm.scmController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.Entities.User;
import com.scm.forms.Userforms;
import com.scm.helper.message;
import com.scm.helper.messageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

//import ch.qos.logback.core.model.Model;

@Controller
public class pageControler {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){
       System.out.println("we are in");
        return "home";

    }

    //About Page
    @RequestMapping("/aboutPage")
    public String aboutPage() {

        return "aboutPage";
    }

    //Services
    @RequestMapping("/servicesPage")
    public String servicesPage() {
        
        return "servicesPage";
    }

    @RequestMapping("/base")
    public String base() {
        
        return "base";
    }

    @RequestMapping("/navbar")
    public String navbar() {
        
        return "navbar";
    }

    @RequestMapping("/Contact")
    public String Contact() {
        
        return "Contact";
    }
    @RequestMapping("/Login")
    public String Login() {
        
        return "Login";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        Userforms userforms = new Userforms();
        //userforms.setName("Jasmeet");
        model.addAttribute("userForm",userforms);
        

        
        return "register";
    }

    //register processing

    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processregister(@ModelAttribute Userforms userform, HttpSession session) {
        System.out.println("Pocessing Registration");
        System.out.println(userform);
        //fetch the form data
        //validate form data
        //save in db
        //userForm to user
        // User user = User.builder()
        // .name(userform.getName())
        // .email(userform.getEmail())
        // .password(userform.getPassword())
        // .about(userform.getAbout())
        // .phoneNumber(userform.getPhoneNumber())
        // .profilePic(null)
        // .build();

        User user = new User();
        user.setName(userform.getName());
        user.setEmail(userform.getEmail());
        user.setPassword(userform.getPassword());
        user.setAbout(userform.getAbout());
        user.setPhoneNumber(userform.getPhoneNumber());


        User savedUser = userService.saveUser(user);
        System.out.println("working");
        //message

        message messagType= message.builder().content("Registration Sussesfull").type(messageType.green).build();

        session.setAttribute("message", messagType);

        //redirect to login
        return "redirect:/register";
    }

    
}
