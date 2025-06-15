package com.example.authService.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter1 inside");
        chain.doFilter(request, response);
        System.out.println("MyFilter1 completed");
    }

    @Override
    public void destroy() {
        System.out.println("Destorying filter1");
        Filter.super.destroy();
    }
}
