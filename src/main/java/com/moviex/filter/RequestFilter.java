package com.moviex.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.moviex.exception.SystemException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authen = request.getHeader("X-TOKEN-AUTH");

        try {
            if (StringUtils.isEmpty(authen) || !StringUtils.equals(authen, "test")) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "REST signature failed validation.");
                return;
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "The REST Security Server experienced an internal error.");
            return;
        }

        chain.doFilter(request, response);
    }
}