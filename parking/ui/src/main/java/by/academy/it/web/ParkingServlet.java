package by.academy.it.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "parkingServlet", urlPatterns = "/parking")
public class ParkingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String number =  req.getParameter("number");
            req.getParameter("number");
            final PrintWriter writer = resp.getWriter();
            writer.println("Welcom to our Parking!");
            writer.println(new Date());
            writer.println("Car Number: " + number);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
