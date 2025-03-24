package ru.vad1mchk.webprogr.lab02.servlets;

import ru.vad1mchk.webprogr.lab02.entities.ShootRecord;
import ru.vad1mchk.webprogr.lab02.exceptions.DataInvalidException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "AreaCheckServlet", value = "/check")
public class AreaCheckServlet extends HttpServlet {
    private static final BigDecimal TWO = new BigDecimal("2");

    private static final BigDecimal HALF = new BigDecimal("0.5");

    private static final BigDecimal MIN_X = new BigDecimal("-3");
    private static final BigDecimal MAX_X = new BigDecimal("5");
    private static final BigDecimal MIN_Y = new BigDecimal("-3");
    private static final BigDecimal MAX_Y = new BigDecimal("5");

    private static final Set<BigDecimal> ALLOWED_X = Arrays
            .stream(new String[]{"-3", "-2", "-1", "0", "1", "2", "3", "4", "5"})
            .map(BigDecimal::new)
            .collect(Collectors.toSet());
    private static final Set<BigDecimal> ALLOWED_R = Arrays
            .stream(new String[]{"1", "2", "3", "4", "5"})
            .map(BigDecimal::new)
            .collect(Collectors.toSet());
    private static final int MAX_PRECISION = 4;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long startTime = System.nanoTime();
        String xAsString = req.getParameter("x");
        String yAsString = req.getParameter("y");
        String rAsString = req.getParameter("r");
        String strictAsString = req.getParameter("strict");
        BigDecimal x, y, r;
        boolean strict = false;
        try {
            if(xAsString == null || xAsString.trim().equals("")) {
                throw new DataInvalidException("Вы не установили X.");
            }
            if(yAsString == null || yAsString.trim().equals("")) {
                throw new DataInvalidException("Вы не установили Y.");
            }
            if(rAsString == null || rAsString.trim().equals("")) {
                throw new DataInvalidException("Вы не установили R.");
            }
            if (strictAsString != null) strict = Boolean.parseBoolean(strictAsString);

            xAsString = xAsString.trim();
            yAsString = yAsString.trim();
            rAsString = rAsString.trim();
            x = parseX(xAsString, strict);
            y = parseY(yAsString, strict);
            r = parseR(rAsString);

            boolean isInsideArea = checkIfInsideArea(x, y, r);
            String timeElapsed = String.format("%.9f", (System.nanoTime() - startTime) / 1_000_000_000.0);
            LocalDateTime timestamp = LocalDateTime.now();
            ShootRecord current = new ShootRecord(timestamp, x, y, r, isInsideArea, timeElapsed);
            LinkedList<ShootRecord> recordsList = (LinkedList<ShootRecord>)
                    req.getSession().getAttribute("recordsList");
            if (recordsList == null) recordsList = new LinkedList<>();
            recordsList.add(current);
            req.getSession().setAttribute("recordsList", recordsList);
            req.getSession().setAttribute("current", current);
            getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);
        } catch (DataInvalidException e) {
            req.setAttribute("errorMessage", e.getMessage());
            getServletContext().getRequestDispatcher("/data-invalid.jsp").forward(req, resp);
        }
    }

    private BigDecimal parseX(String xAsString, boolean strict) throws DataInvalidException {
        BigDecimal x;
        try {
            x = new BigDecimal(xAsString);
        } catch (NumberFormatException e) {
            throw new DataInvalidException("X - некорректное число ("+xAsString+").", e);
        }
        if (strict && !ALLOWED_X.contains(x)) throw new DataInvalidException("Недопустимое значение X: "+x+".");
        return x.round(new MathContext(MAX_PRECISION, RoundingMode.HALF_UP));
    }

    private BigDecimal parseY(String yAsString, boolean strict) throws DataInvalidException {
        BigDecimal y;
        try {
            y = new BigDecimal(yAsString);
        } catch (NumberFormatException e) {
            throw new DataInvalidException("Y - некорректное число ("+yAsString+").", e);
        }
        if (strict && (y.compareTo(MIN_Y) <= 0 || y.compareTo(MAX_Y) >= 0)) {
            throw new DataInvalidException("Недопустимое значение Y: "+y+".");
        }
        return y.round(new MathContext(MAX_PRECISION, RoundingMode.HALF_UP));
    }

    private BigDecimal parseR(String rAsString) throws DataInvalidException {
        BigDecimal r;
        try {
            r = new BigDecimal(rAsString);
        } catch (NumberFormatException e) {
            throw new DataInvalidException("R - некорректное число ("+rAsString+").", e);
        }
        if (!ALLOWED_R.contains(r)) throw new DataInvalidException("Недопустимое значение R: "+r+".");
        return r.round(new MathContext(MAX_PRECISION, RoundingMode.HALF_UP));
    }

    private boolean checkIfInsideArea(BigDecimal x, BigDecimal y, BigDecimal r) {
        if (x.compareTo(BigDecimal.ZERO) < 0 && y.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        if (
                x.compareTo(BigDecimal.ZERO) >= 0 && y.compareTo(BigDecimal.ZERO) <= 0 &&
                x.compareTo(r.multiply(HALF)) <= 0 && y.compareTo(r.negate()) >= 0
        ) return true;
        if (
                x.compareTo(BigDecimal.ZERO) <= 0 && y.compareTo(BigDecimal.ZERO) >= 0 &&
                        x.multiply(x).add(y.multiply(y)).compareTo(r.multiply(r)) <= 0
        ) return true;
        return x.compareTo(BigDecimal.ZERO) >= 0 && y.compareTo(BigDecimal.ZERO) >= 0 &&
                        y.add(x.multiply(TWO)).compareTo(r) <= 0;
    }
}
