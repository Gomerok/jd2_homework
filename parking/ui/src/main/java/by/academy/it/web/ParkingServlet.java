package by.academy.it.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "parkingServlet", urlPatterns = "/parking")
public class ParkingServlet extends HttpServlet {

    private Map<String, Date> map = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            Date currentDate = new Date();
            String number = req.getParameter("number");
            addParkingCookie(resp,number);
            if (map.containsKey(number)) {
                Date startDate = map.get(number);
                long seconds = (currentDate.getTime() - startDate.getTime()) / 1000;
                writer.println("You stayed n our parking:");
                writer.println(seconds + " seconds");
                writer.println("Car Number: " + number);
                map.remove(number);
            } else {
                map.put(number, currentDate);
                writer.println("Welcom to our Parking!");
                writer.println(currentDate);
                writer.println("Car Number: " + number);
            }

            session.setAttribute("number", number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addParkingCookie(HttpServletResponse resp, String number) {
        Cookie cookie = new Cookie("PLATENUMBER",number);
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }
}