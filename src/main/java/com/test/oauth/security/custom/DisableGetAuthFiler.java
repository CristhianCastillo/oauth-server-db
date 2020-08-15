package com.test.oauth.security.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisableGetAuthFiler extends OncePerRequestFilter {

    public static final Logger LOGGER = LogManager.getLogger(DisableGetAuthFiler.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().equals("/oauth/token")) {
//            LOGGER.info("ContentType: {}", request.getContentType());
//            LOGGER.info("Body Request");
//            LOGGER.info("username: {}", request.getParameter("username"));
//            LOGGER.info("password: {}", request.getParameter("password"));
//            LOGGER.info("grant_type: {}", request.getParameter("grant_type"));
//            LOGGER.info("client_id: {}", request.getParameter("client_id"));
//            LOGGER.info("client_secret: {}", request.getParameter("client_secret"));
            if (request.getContentType() != null && request.getContentType().equals("application/x-www-form-urlencoded")) {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }


}
