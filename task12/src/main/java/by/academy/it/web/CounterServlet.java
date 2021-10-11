package by.academy.it.web;

import by.academy.it.controller.Counter;
import by.academy.it.controller.FileCreator;
import by.academy.it.controller.ImageCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "counterServlet", urlPatterns = "/image_counter")
public class CounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        FileCreator.createFile();
        Counter.setCount(count);
        response.setContentType("image/jpeg");
        ImageCreator.createImage(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
