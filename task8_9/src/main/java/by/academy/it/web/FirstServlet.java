package by.academy.it.web;

import by.academy.it.controller.Counter;
import by.academy.it.controller.FileCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        FileCreator.createFile();
        Counter.setCount(count);

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>FirstServlet</title></head>");
        out.println("<h1>This is First Servlet</h1>");
        out.println("Session counter:" + Counter.getCount());
        //out.println("Session counter:" + count);

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
