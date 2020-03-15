package org.gyb.ssh.config;

import org.gyb.ssh.pojo.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class LogRecorder implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //只支持处理json数据
        return converterType.getName().equals("org.springframework.http.converter.json.MappingJackson2HttpMessageConverter");
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //如果body被统一包装成ResponseResult，则进行下面的处理
        if(body instanceof ResponseResult && request instanceof ServletServerHttpRequest){
            ResponseResult respData = (ResponseResult) body;
            ServletServerHttpRequest req = (ServletServerHttpRequest)request;
            HttpServletRequest servletRequest = req.getServletRequest();
            //获取处理该请求对应的处理器方法，即Controller的具体Method
            Object handler = servletRequest.getAttribute("handler");
            HandlerMethod method = (HandlerMethod) handler;
            RecordLog recordLog = method.getMethodAnnotation(RecordLog.class);
            if(recordLog !=null){
                String content = recordLog.content();
                int code = respData.getCode();
                if(code != 200){
                    System.out.println(content+"失败了！");
                }else{
                    System.out.println(content+"成功！");
                }
            }
        }
        return body;
    }
}
