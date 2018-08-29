package com.mangold.bootstrap;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class BootStrap
 */

@Slf4j
@WebServlet(urlPatterns = "/BootStrap", loadOnStartup = 1)
public class BootStrap extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BootStrap() {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("Microservice BootStrap");
    }
}