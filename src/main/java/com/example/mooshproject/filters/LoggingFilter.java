package com.example.mooshproject.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Log the request details
        System.out.println("Incoming request: " + request.getMethod() + " " + request.getRequestURI());

        // Continue with the next filter in the chain
        filterChain.doFilter(request, response);

        // Log the response details
        System.out.println("Outgoing response: " + response.getStatus());
    }
}
