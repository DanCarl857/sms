package org.skylabase.sms.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by daniel on 2/6/17.
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401: " + authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("DANIEL_REALM");
        super.afterPropertiesSet();
    }
}
