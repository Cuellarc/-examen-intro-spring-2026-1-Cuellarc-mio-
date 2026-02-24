package com.icesi.web;

import com.icesi.model.Measurement;
import com.icesi.service.IoTService;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import com.icesi.model.Measurement;

public class AddMeasurementServlet extends HttpServlet {

    private IoTService service;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        this.service = ctx.getBean(IoTService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h2>Agregar medida</h2>");
        out.println("<form method='post' action='" + req.getContextPath() + "/measurement/add'>");

        out.println("Timestamp: <input name='name'/><br/>");
        out.println("Device: <input name='serialNumber'/><br/>");
        out.println("Valor: <input name='ubicacion'/><br/>");

        out.println("<button type='submit'>Guardar</button>");
        out.println("</form>");

        out.println("<p><a href='" + req.getContextPath() + "/measurement'>Volver a lista</a></p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            Measurement d = new Measurement();

            service.registerMeasurement(d);

            resp.sendRedirect(req.getContextPath() + "/measurement");
        } catch (RuntimeException ex) {
            out.println("<html><body>");
            out.println("<h3>Error</h3>");
            out.println("<p>" + ex.getMessage() + "</p>");
            out.println("<p><a href='" + req.getContextPath() + "/measurement/add'>Intentar otra vez</a></p>");
            out.println("</body></html>");
        }
    }
}