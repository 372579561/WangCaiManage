package com.wangcai.com.wangcai.filter;

import com.wangcai.com.wangcai.bean.User;
import com.wangcai.com.wangcai.constants.Constants;
import org.apache.catalina.connector.Request;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Order(1)
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER_LOGIN);
        List<String> noFilter = new ArrayList<>();
        String uri = request.getRequestURI();
        Boolean doFilter = true;
        if (uri.contains("/js/") || uri.contains("/images/")||uri.contains("/css/")) {
            doFilter = false;
        }
        noFilter.add("/login/loginPage");
        noFilter.add("/login/login");
        for (String noF : noFilter) {
            if (uri.equals(noF)) {
                doFilter = false;
                break;
            }
        }
        if (doFilter) {
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write("您还未登录");
                } else {
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    response.sendRedirect(request.getContextPath() + "/login/loginPage");
                }
                return;
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
