package com.homework.InsuranceApp.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

@Slf4j
@Component
@Order(1)
@RequiredArgsConstructor
public class CertificateFilter implements Filter {
    private static long countGetRequests = 0;
    private static long countPostRequests = 0;
    private static long countDeleteRequests = 0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();

        switch (method){
            case "GET":
                countGetRequests++;
                method = String.format("[%d]",countGetRequests)+method;
                break;
            case"POST":
                countPostRequests++;
                method = String.format("[%d]",countPostRequests)+method;
                break;

            case "DELETE":
                countDeleteRequests++;
                method = String.format("[%d]",countDeleteRequests)+method;
                break;
            default:
                method = "[?]"+method;
        }
        log.info(method +"."+ request.getRemoteUser());

        filterChain.doFilter(servletRequest,servletResponse);

    }
}
