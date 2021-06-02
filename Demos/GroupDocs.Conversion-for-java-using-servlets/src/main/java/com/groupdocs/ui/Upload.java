package com.groupdocs.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@WebServlet("/upload")
@MultipartConfig
public class Upload extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	HttpSession session = request.getSession(true);

        // Save source file to temporary folder and keep the path remembered.
        Part source = request.getPart("source");
        if (source != null) {
            Path path = Files.createTempFile("groupdocs-conversion-source-", source.getSubmittedFileName());
            Files.copy(source.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("source", path);
        }

     // Save the value of Conversion Type for later use.
        int conversionType = 5;
        try {
            conversionType = Integer.parseInt(request.getParameter("conversion-type"));
        } catch (Exception x) {
            // Ignore
        }
        request.getSession().setAttribute("conversion-type", conversionType);

        // Redirect to Conversion servlet
        response.sendRedirect("convert");
    }
}

