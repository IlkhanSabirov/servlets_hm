// ДЗ

package ru.itis.servlets;

import ru.itis.models.Driver;
import ru.itis.services.DriversService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {
    private DriversService driversService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        driversService = (DriversService) config.getServletContext().getAttribute("driversService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/html/filter.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String city = req.getParameter("city");
        String gender = req.getParameter("gender");
        String experience = req.getParameter("experience");

        try {
            List<Driver> driversByCity = driversService.getAllByCity(city);
            System.out.println("Drivers where city = " + city + ":");
            for (Driver driver : driversByCity) {
                System.out.println(driver);
            }

            List<Driver> driversByGender = driversService.getAllByGender(gender);
            System.out.println("Drivers where gender = " + gender + ":");
            for (Driver driver : driversByGender) {
                System.out.println(driver);
            }

            List<Driver> driversByExperience = driversService.getAllByExperience(Integer.parseInt(experience));
            System.out.println("Drivers where experience = " + experience + ":");
            for (Driver driver : driversByExperience) {
                System.out.println(driver);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/filter");
    }

}
