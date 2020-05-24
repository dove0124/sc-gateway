package cn.springcloud.book.dataservice.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.springcloud.book.common.context.UserContextHolder;
import cn.springcloud.book.dataservice.config.DataConfig;

public class DataInterceptor implements HandlerInterceptor {

    @Autowired
    private DataConfig dataConfig;

    private static final Logger log = LoggerFactory.getLogger(DataInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object handler, ModelAndView modelAndView)
        throws Exception {
//        modelAndView.addObject("ds port: ", dataConfig.getPort());
//        modelAndView.addObject("ds port: ", "8099");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
        throws Exception {
        UserContextHolder.shutdown();
    }
}
