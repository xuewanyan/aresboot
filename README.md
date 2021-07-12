#P11  2021-06-25 导入Spring配置文件
    1、@ImportResource(locations = {"classpath:META-INF/spring/spring-*.xml"})
    
#P12  2021-06-25 项目热部署
    1、spring-boot-devtools 导入依赖
    2、File -> Settings ->Build,Execution,Deployment -> Compiler 打开勾选 Build project automatically
    3、"Ctrl + Alt + Shift + /",选择Registry，找到compiler.automake.allow.when.app.running,打勾
    实际上所谓的热部署本质上是将整个的类加载器进行了拆分，在没有引入
    
#P13  2021-06-28 整个JUnit5进行测试
       
#P14  2021-06-28 Lombok
    
#P15  2021-06-28 生成类操作结构

==============================2021-06-29============git分支 bt-20210629
#P16 #Accessor(lombok)
    @Accessor(fluent = true)模式:可以将属性的名称作为属性设置和返回。不包含setter,getter方法
    @Accessor(chain = true) 模式：可以将属性的名称作为属性设置和返回。包含setter,getter方法
#P17 理解建造者模式(lombok)   
    @Builder // 建造者模式
    使用：Message message = Message.builder().title("建").content("造").pubdate(new Date()).build();
#P18 异常处理(lombok) 
    @SneakyThrows:会自动生成try...catch
#P19 IO流自动关闭(lombok) 
    @Cleanup:自动关闭流
#P20 同步方法(lombok) 
    @Synchronized

==============================2021-06-30============git分支 bt-20210630
#P21 对象转换处理
    在使用SpringMVC开发框架进行参数接收的时候，所有的请求参数都可以自动的转换为VO类型，同时在进行Action方法返回的
    时候也可以直接以Restful的形式返回JSON数据内容。Springboot也支持。
#P22 整合Fastjson组件

#P23 返回XML数据
     @PostMapping(value = "/echo",produces = MediaType.APPLICATION_XML_VALUE)
     
==============================2021-07-01============git分支 bt-20210701
#P24 返回PDF数据
    到现在目前为止所有的返回的数据实际上最为常见的类型就是Restful(JSON结构)类型。
#P25 返回excel数据
#P26 返回图像流
#P27 返回视频流
#P28 文件下载
#P29 属性定义与注入(.yml文件)
#P30 @ConfigurationProperties("muyan")(yml文件)
    yml文件，key值相同实现自动注入
#P31 注入对象数据(yml文件) 
    
==============================2021-07-02============git分支 bt-20210702
#P32 自定义注入配置文件
#P33 项目打包
 
==============================2021-07-05============git分支 bt-20210705
#P34 调整JVM运行参数
    所有的Springboot打包之后，肯定耀通过JVM来直接运行。
    Runtime
#P35 配置WEB环境
    当.yml跟.properties同时存在相同配置的时候，.properties的配置优先级更高。
#P36 profile环境配置
    application-dev.yml
    application-test.yml
    application-prod.yml
#P37 打包war文件
    如果要想打算以war文件的方式来运行当前项目，那么就需要修改当前项目的启动类，这个类就必须继承
    “org.springframework.boot.web.servlet.support.SpringBootServletInitializer”父类，
    如果你现在的代码只是自己去使用，那么就直接基于bootJar任务进行打包即可，如果你的项目最终是需要交
    给其他用户去使用，那么就使用bootWar任务进行打包。
#P38 整合Jetty容器    
        Tomcat和Jetty都支持标准的Servlet规范以及JakartaEE规范，相比较而言，Jetty的实现架构要比Tomcat更加简单。
        Tomcat架构是基于容器设计的，基于Service实现，每一个Service由一个Container和多个Connector组成，形成一个个
    独立且完整的处理单元。
        Jetty的核心是Server,里面包含有多个Handler以及一个Connector,Jetty的实现架构要比Tomcat更加简单，所有的
    扩展功能都可以基于Handler实现。
        提示：Tomcat跟Jetty的主要区别：
            在并发量小且处理生命周期较短（如果仅仅通过Tomcat获取到一些Restful数据，那么这样的处理周期是很短的），
            一般会推荐使用Tomcat，而如果说现在处理的周期较长，同时大部分的程序是以静态文件为主，则推荐Jetty。
#P39 整合Undertow容器
     Undertow是由红帽公司开发的一款基于NIO的高性能处理的WEB嵌入式服务器，在使用时不需要提供容器，只需要提供其
     内部的构建API即可快速搭建WEB服务，同时Undertow的生命周期完全由嵌入的应用程序进行控制，在Springboot依赖库
     中可以直接通过依赖管理实现整合Undertow容器。

==============================2021-07-06============git分支 bt-20210706
#P40 获取WEB内置对象
    HttpServletRequest,HttpServletResponse
#P41 读取资源文件
    国际化程序应用。
#P42 文件上传
#P43 整合WEB过滤器
    需要清楚的是，在整个的SpringBoot项目开发过程之中，过滤器是属于javaWeb的原生的开发组件，那么既然是原生的处理组件，
    是否使用还是需要根据大家的实际要求来进行处理。
    MessageFilter extends HttpFilter 
#P44 整合WEB监听器
    WebServletListener implements ServletContextListener
#P45 拦截器
    DefaultHandlerInterceptor implements HandlerInterceptor
#P46 AOP拦截器
    org.springframework.boot:spring-boot-starter-aop
    
==============================2021-07-07============git分支 bt-20210707
#P47 整合Email邮件服务
    implementation group: 'org.springframework.boot',name: 'spring-boot-starter-mail'
#P48 https安全访问
#P49 全局错误页   
    implements ErrorPageRegistrar
#P50 全局异常处理
    @ControllerAdvice
#P51 全局数据绑定
#P52 全局数据预处理
    所有的请求数据为了接收方便实际上都会通过HttpServletRequest中的getParameterValues()方法来接收，
    而接收到的内容全部都是数组，而在Spring里面把这个数组的内容自动调用了toString()实现了处理。
     
==============================2021-07-08============git分支 bt-20210708
#P53 数据验证简介
    拦截器进行处理





















