package br.com.maratonajsf.filter;

import br.com.maratonajsf.bean.login.LoginBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

    @Inject
    private LoginBean loginBean;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        String url = req.getRequestURL().toString();
        System.out.println(url);
        if(url.contains("/restricted") && loginBean.getEstudante() == null){
            res.sendRedirect(req.getServletContext().getContextPath()+"/faces/login.xhtml");
        }else{
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
