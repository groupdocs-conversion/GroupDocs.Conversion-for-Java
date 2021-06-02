package com.groupdocs.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/download")
public class Download extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // It is assumed that we are redirected here by Conversion servlet
        
    	// so we already know path to result file
        Path result = (Path) request.getSession().getAttribute("result");
        if (result == null) {
            response.sendError(404);
            return;
        }

        // Let the user download conversion results
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename=" + result.getFileName());
        Files.copy(result, response.getOutputStream());
    }
}
