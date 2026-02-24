package com.icesi.web;

import com.icesi.model.Device;
import com.icesi.service.IoTService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListDevicesServlet extends HttpServlet {

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

        List<Device> devices = service.getAllDevices();

        out.println("<html><body>");
        out.println("<h2>Dispositivos IoT</h2>");
        out.println("<p><a href='" + req.getContextPath() + "/devices/add'>Agregar nuevo</a></p>");

        out.println("<table border='1' cellpadding='6'>");
        out.println("<tr>");
        out.println("<th>ID</th><th>Nombre</th><th>Serial</th><th>Ubicación</th><th>Tipo</th><th>Estate</th><th>Acción</th>");
        out.println("</tr>");

        for (Device d : devices) {
            out.println("<tr>");
            out.println("<td>" + d.getId() + "</td>");
            out.println("<td>" + d.getName() + "</td>");
            out.println("<td>" + d.getSerialNumber() + "</td>");
            out.println("<td>" + d.getUbicacion() + "</td>");
            out.println("<td>" + d.getType() + "</td>");
            out.println("<td>" + d.getEstate() + "</td>");

            // Form para cambiar estado
            out.println("<td>");
            out.println("<form method='post' action='" + req.getContextPath() + "/devices/estate'>");
            out.println("<input type='hidden' name='id' value='" + d.getId() + "'/>");
            out.println("<select name='estate'>");
            out.println("<option value='ACTIVE'>ACTIVE</option>");
            out.println("<option value='INACTIVE'>INACTIVE</option>");
            out.println("</select>");
            out.println("<button type='submit'>Cambiar</button>");
            out.println("</form>");
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}