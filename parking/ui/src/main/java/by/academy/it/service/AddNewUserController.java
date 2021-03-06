package by.academy.it.service;

import by.academy.it.dto.AddNewUserCommand;
import by.academy.it.parking.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("currentPerson")
public class AddNewUserController {

    @Autowired
    private PersonService personService;

    @GetMapping("/add-new-user.html")
    public ModelAndView addNewUserView() {
        return new ModelAndView("add-person")
                .addObject("addNewUserCommand", new AddNewUserCommand());
    }

    @PostMapping("/add-new-person.do")
    @Secured(value = "ROLE_ADMIN")
    public ModelAndView addNewUser(@ModelAttribute("addNewUserCommand") AddNewUserCommand addNewUserCommand,
                                   BindingResult result) {
        System.out.println(addNewUserCommand);
        System.out.println(addNewUserCommand.getPassword());
        final List<String> errors = personService.addNewUser(addNewUserCommand);
        if (addNewUserCommand.getPassword().isEmpty()) {
            result.addError(new ObjectError("password", "Password is empty"));
        }
        System.out.println("asdadadadasda");
        if (!errors.isEmpty()) {

            errors.forEach(s -> result.addError(new ObjectError("addNewUserCommand", s)));
            return new ModelAndView("add-person");
        }
        Person person = personService.findPerson(addNewUserCommand.getName(), addNewUserCommand.getSecondName());
        System.out.println(person);
        System.out.println(person.getName());
        return new ModelAndView("redirect:/index.html")
                .addObject("currentPerson", person);
    }

}