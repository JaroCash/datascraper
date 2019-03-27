package com.jarek.datascraper.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class APIAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    private final String HEADER_NAME = "Authentication";

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {

        return httpServletRequest.getHeader(HEADER_NAME);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return "N/A";
    }
}
