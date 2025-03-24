package ru.vad1mchk.webprogr.lab02.servlets;

import ru.vad1mchk.webprogr.lab02.entities.ShootRecord;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/control")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("x: "+ req.getParameter("x"));
        System.out.println("y: "+ req.getParameter("y"));
        System.out.println("r: "+ req.getParameter("r"));
        if(req.getParameter("x") != null && req.getParameter("y") != null &&
        req.getParameter("r") != null) {
            getServletContext().getNamedDispatcher("AreaCheckServlet").forward(req, resp);
        } else if (req.getParameter("clear") != null) {
            LinkedList<ShootRecord> recordsList = (LinkedList<ShootRecord>)
                    req.getSession().getAttribute("recordsList");
            if (recordsList == null) recordsList = new LinkedList<>();
            recordsList.clear();
            req.getSession().setAttribute("recordsList", recordsList);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
