package by.academy.it.web;

import by.academy.it.controller.User;
import by.academy.it.controller.UserAgentParser;
import by.academy.it.controller.UserFormValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "messageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {

    private List users = new ArrayList<User>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String info = req.getHeader("User-Agent");
        if (UserFormValidator.validate(name, phone, email)) {
            User us = new User(name, phone, email);
            if (!users.contains(us)) {
                out.println("Hello!!!\n");
                users.add(new User(name, phone, email));
            } else {
                out.println("Hello again!!!\n");
            }
            out.println(name + "\n" + phone + "\n" + email);
            out.println("You use "+ UserAgentParser.getBrowser(info));
        } else {
            out.println("<html>");
            out.println("<head>Data entered incorrectly.</head>");
            out.println("<body>" +
                    "<form action=\"/task10_11/\">\n" +
                    "<button type=\"submit\">Entered it again</button>\n" +
                    "</form>" +
                    "</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
