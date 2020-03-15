
### 基于Spring MVC Web项目日志记录功能实现Demo。
#### 1.需求分析

  有些系统需要审计日志功能，简单来说就是实现用户操作日志的记录。我们约定：一个接口功能足够单一只对应用户的一项功能。对于需要记录日志的接口能够根据配置做到日志的记录。将具体的需求总结如下：

 - 日志记录功能不能影响具体的业务逻辑，即对业务代码无侵入性。
 - 日志记录功能对业务开发者透明，即业务开发者无需知道日志记录的实现细节，就能使用。
 - 日志记录功能可插拔，即能够灵活配置接口记录日志的启用和禁用。
#### 2. 设计思想和实现思路
    主要用到的编程思想为AOP。

    借助Spring MVC已经实现的AOP功能来实现。

    用到的Spring相关功能有处理器拦截器（HandlerInterceptor）、@ControllerAdvice@RestControllerAdvice（用于全局异常处理）和org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice。

实现HandlerInterceptor的自定义拦截器，向request的属性列表中设置实际的请求处理器（HandlerMethod）。

借助@RestControllerAdvice的实现的全局异常处理器，对异常进行捕获并转换成统一pojo类。

实现org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice接口来实现具体的日志记录功能。

使用自定义的注解@RecordLog来标记那些接口需要记录日志。
<br>
————————————————
>详细说明，CSDN博客原文链接：https://blog.csdn.net/gybshen/article/details/104878366