package by.academy.it.web;

import by.academy.it.controller.PersonController;
import by.academy.it.pojo.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private PersonController personController;

    @Override
    public void init() throws ServletException {
        personController = new PersonController();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if(command != null && "new".equals(command)){
            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setSecondName(req.getParameter("second_name"));
            personController.saveNewPerson(person);
            List<String> errors = personController.saveNewPerson(person);

            if(errors.isEmpty()){
                req.getRequestDispatcher("/person.jsp").forward(req,resp);
            }else{
                req.setAttribute("errors",errors);
                req.getRequestDispatcher("/add-person.jsp");
            }
        }
    }
}
