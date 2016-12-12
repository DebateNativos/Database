/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podiumcr.podiumweb;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joss
 */
public class Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain)
        throws IOException, ServletException {
    System.out.println("Entered intop Login Filter");
    HttpServletRequest req = (HttpServletRequest) request;
    LoginAdmin login = (LoginAdmin) req.getSession().getAttribute("login");
    String path = req.getRequestURI().substring(req.getContextPath().length());
    System.out.println("path:" + path);

    if (path.contains("/Admin/") || path.contains("/Employee/")) {
        if (login != null) {
            if (login.getEmail() != null && !login.getPassword().equals("")) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect("/EMS2/faces/Html/Common/Login.xhtml");
            }
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("/debatesapp.azurewebsites.net/podiumwebapp/faces/home.xhtml");
        }


    } else {
        chain.doFilter(request, response);
    }
}
}
