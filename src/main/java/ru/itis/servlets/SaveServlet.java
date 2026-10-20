// ДЗ

package ru.itis.servlets;

import ru.itis.dto.DriverForm;
import ru.itis.services.DriversService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {
    private DriversService driversService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        driversService = (DriversService) config.getServletContext().getAttribute("driversService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer count;
        try {
            count = driversService.getCountForSave();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("countForJsp", count);
        req.getRequestDispatcher("/jsp/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] firstNames = req.getParameterValues("firstName");
        String[] lastNames = req.getParameterValues("lastName");
        String[] ages = req.getParameterValues("age");
        String[] cities = req.getParameterValues("city");
        String[] genders = req.getParameterValues("gender");
        String[] experiences = req.getParameterValues("experience");

        List<DriverForm> forms = new ArrayList<>();
        for (int i = 0; i < firstNames.length; i++) {
            DriverForm form = DriverForm.builder()
                    .firstName(firstNames[i])
                    .lastName(lastNames[i])
                    .age(Integer.parseInt(ages[i]))
                    .city(cities[i])
                    .gender(genders[i])
                    .experience(Integer.parseInt(experiences[i]))
                    .build();
            forms.add(form);
        }

        try {
            driversService.saveDrivers(forms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/html/usersAdded.html");
    }

}
