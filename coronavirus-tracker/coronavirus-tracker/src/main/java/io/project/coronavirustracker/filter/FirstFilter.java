package io.project.coronavirustracker.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        res.addHeader("X-FRAME-OPTIONS", "DENY");
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("Set-Cookie", "key=value; HttpOnly; SameSite=strict");
        chain.doFilter(req, res);
    }
}
