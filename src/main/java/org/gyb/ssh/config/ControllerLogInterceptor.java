package org.gyb.ssh.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ControllerLogInterceptor implements HandlerInterceptor {

    /**
     * 将实际的处理器（HandlerMethod）设置到request的属性列表中，
     * 用于后续的日志记录器获取处理器方法的注解，以此来判断是否需要记录日志
     * @see LogRecorder
     */
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) {
        request.setAttribute("handler", handler);
        return true;
    }

    /**
     * 经过全局的{@link GlobalExceptionHandler}异常处理器处理之后这里的入参ex
     * 总是null，所以不要在该方法中试图通过ex来捕获和处理程序的错误
     * @param ex 处理器抛出的异常，总是null。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        if (ex != null) {
            System.out.println("失败！");
        }
        System.out.println(request);
        Enumeration<String> attributeNames = request.getAttributeNames();
    }
}
