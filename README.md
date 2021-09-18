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
    @WebWebFilter 注解使用，但是记得配置扫描bean，spring
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

==============================2021-07-12============git分支 bt-20210712
#P54 JSR303数据验证规范
    JSR303由注解组成

==============================2021-07-14============git分支 bt-20210714
#P55 设置错误信息
    资源文件名称“ValidationMessages.properties”
#P56 自定义验证器
    在JSR303的规范里面提供丰富的验证器，
    扩展实现新的正则验证注解：
    @Constraint(validatedBy = HandlerRegexValidation.class)使用此注解
    @Inherited 加强注解: 用于当父类有自定义注解@Treat时候，子类继承之后也默认有其@Treat注解
#P57 Thymeleaf简介（了解）
    单应用，前后端不分离时候，springboot支持的使用。
#P58 Thymeleaf编程起步（了解） 
#P59 Thymeleaf环境配置（了解）
#P60 整合静态资源（了解）
#P61 路径访问支持（了解）
#P62 读取资源文件（了解）    
#P63 环境对象支持（了解）       
#P64 对象输出（了解）  
#P65 页面逻辑处理（了解）
#P66 数据迭代处理（了解）
...

==============================2021-07-15============git分支 bt-20210715
#P69 Actuator监控组件简介（掌握）
    springboot四大神器之首，
    {
    "_links": {
    "self": {
      "href": "http://localhost:8081/dev/actuator",
      "templated": false
    },
    "health": { // 健康信息（微服务的状态） 执行结果：{"status":"UP"} ：健康
      "href": "http://localhost:8081/dev/actuator/health",
      "templated": false
    },
    "health-path": { // 健康信息的监控路径
      "href": "http://localhost:8081/dev/actuator/health/{*path}",
      "templated": true
    }} }
#P70 Actuator接口访问（掌握）
#P71 heapdump(堆)（理解）
#P72 info服务信息（理解）
#P73 health服务信息（理解）
#P74 远程关闭（理解）
#P75 自定义Endpoint（理解）
#P76 Lombok日志注解（掌握）
#P77 springboot日志配置（掌握）

==============================2021-07-16============git分支 bt-20210716
#P78 整合Logback日志配置文件（掌握）
    文件名必须使用logback-spring.xml定义文件
#P79 动态修改日志级别（掌握）
#P80 MDC全链路跟踪（掌握）    
    添加MDC拦截器,注册config

==============================2021-07-19============git分支 bt-20210719    
#P81 Actuator可视化工具（掌握）  ----linux 基本集群环境搭建
    VMware Workstation集成虚拟机Linux，回家安装虚拟机先
    1、C:\Windows\System32\drivers\etc 修改windows houts配置文件
        192.168.59.128 aresboot-producer
        192.168.59.129 aresboot-prometheus
        192.168.59.130 aresboot-grafana
    2、vim /etc/hostname 修改主机名称
        aresboot-producer
    3、vim /etc/sysconfig/network-scripts/ifcfg-ens33 
        修改网卡ip（IPADDR=192.168.59.128）
        修改网卡ip（IPADDR=192.168.59.129）
        修改网卡ip（IPADDR=192.168.59.130）
    4、vim /etc/hosts 修改hosts主机配置文件 
        192.168.59.128 aresboot-producer
        192.168.59.129 aresboot-prometheus
        192.168.59.130 aresboot-grafana
    5、重启全部主机
        reboot
#P82 NodeExporter
        在整个微服务监控过程之中，除了需要针对于Springboot服务本身进行监控之外，最重要的一点就是需要及时的知道
    当前主机（节点）所对应的性能状态，这个就可以清楚的知道当前的主机资源能否够用。
        NodeExporter是由Prometheus所提供的开发组件，这个组件是一个独立的应用程序包，在需要的地方进行组件的导
    入即可（本质上可以理解为一个独立的应用进程）。登录Prometheus.io
    上传：node_exporter-1.1.2.linux-amd64.tar.gz到Linu系统之中
    解压文件：tar xzvf /var/ftp/node_exporter-1.1.2.linux-amd64.tar.gz -C /usr/local/
    解压文件：tar -xvf /var/ftp/node_exporter-1.1.2.linux-amd64.tar -C /usr/local/
    目录更名：mv /usr/local/node_exporter-1.1.2.linux-amd64/ /usr/local/node_exporter
    修改配置文件：vim /lib/systemd/system/node_exporter.service
        [Unit]
        Description=Node_Exporter Service
        
        [Service]
        User=root
        ExecStart=/usr/local/node_exporter/node_exporter
        TimeoutStopSec=10
        Restart=on-failure
        RestartSec=5
        
        [Install]
        WantedBy=multi-user.target
    重新加载当前新的配置文件：systemctl daemon-reload
    配置服务自动启动： systemctl enable node_exporter.service
    配置关闭自动启动： systemctl disable node_exporter.service
    手动启动：systemctl start node_exporter.service
    查看服务状态：systemctl status node_exporter.service
    查看端口占用情况：netstat -nptl
    防火墙：firewall-cmd --zone=public --add-port=9100/tcp --permanent
    重新加载防火墙配置：firewall-cmd --reload

==============================2021-07-20============git分支 bt-20210720    
#P83 Prometheus监控数据
    打包 gradle bootJar
    后台运行jar:nohup java -jar /var/ftp/ares-boot-1.0.0-lee.jar > /usr/local/yootk.log 2>&1 &
    添加防火墙端口：firewall-cmd --zone=public --add-port=8081/tcp --permanent
    重新加载防火墙配置：firewall-cmd --reload
#P84 Prometheus服务搭建
    1、下载https://prometheus.io/download/#prometheus（prometheus-2.28.1.linux-amd64.tar.gz）
    2、上传ftp
    3、解压 tar -xzvf /var/ftp/prometheus-2.28.1.linux-amd64.tar.gz -C /usr/local/
    4、将解压后的版本号取消 mv /usr/local/prometheus-2.28.1.linux-amd64/ /usr/local/prometheus
    5、修改 prometheus.yml配置文件
        scrape_configs:
          - job_name: 'prometheus'
            static_configs:
            - targets: ['aresboot-prometheus:9999']
          - job_name: 'node'
            static_configs:
            - targets: ['aresboot-producer:9100']
              labels:
                instance: aresboot-producer-node
          - job_name: 'aresboot'
            scrape_interval: 10s
            scrape_timeout: 5s
            metrics_path: '/actuator/prometheus'
            static_configs:
               - targets: ['aresboot-producer:8081']
    6、检查当前配置文件的定义是否正确（/usr/local/prometheus/promtool check config /usr/local/prometheus/prometheus.yml）
    7、配置服务自动启动（vim /usr/lib/systemd/system/prometheus.service）
        [Unit]
        Description=Node_Exporter Service
        
        [Service]
        User=root
        ExecStart=/usr/local/prometheus/prometheus \
        		--config.file=/usr/local/prometheus/prometheus.yml \
        		--storage.tsdb.path=/user/local/prometheus/data \
        		--web.listen-address=0.0.0.0:9999 --web.enable-lifecycle
        TimeoutStopSec=10
        Restart=on-failure
        RestartSec=5
        
        [Install]
        WantedBy=multi-user.target
    8、重新加载当前新的配置文件：systemctl daemon-reload
    9、配置服务自动启动： systemctl enable prometheus.service
    10、手动启动：systemctl start prometheus.service
    11、查看服务状态：systemctl status prometheus.service
    12、firewall-cmd --zone=public --add-port=9999/tcp --permanent
    13、重新加载防火墙配置：firewall-cmd --reload
    14、访问：http://aresboot-prometheus:9999
        - node_memory_Active_bytes(处理器cpu使用情况)
#P85 Gragana可视化
    1、访问官网：https://grafana.com/grafana/download
    2、下载组件：wget https://dl.grafana.com/oss/release/grafana_8.0.6_amd64.deb
    3、解压 ：tar -xzvf /var/ftp/grafana-8.0.6.linux-amd64.tar.gz -C /usr/local
    4、改名去除文件夹版本号：mv /usr/local/grafana-8.0.6 /usr/local/grafana
    5、修改配置文件（vim /usr/lib/systemd/system/grafana.service）
    6、重新加载配置文件 systemctl daemon-reload
    7、配置自动启动：systemctl enable grafana.service
    8、启动服务：systemctl start grafana.service
    9、查看服务启动状态：systemctl status grafana.service
    10、查看端口占用情况：netstat -nptl
    11、开启防火墙：firewall-cmd --zone=public --add-port=3000/tcp --permanent
    12、重新加载防火墙：firewall-cmd --reload
    13:访问：http://aresboot-grafana:3000
#P86 监控警报 Gragana可视化    
#P87 警报测试

==============================2021-07-21============git分支 bt-20210721   
#P88 spring定时任务
    启动类添加：@EnableScheduling,定时类加:@Schedule()
    线程池：防止线程阻塞引起单线程跑批定时任务
#P89 ShedLock分布式定时任务
    1、使用redis。
       - 1、C:\Windows\System32\drivers\etc 修改windows houts配置文件
            192.168.59.131 redis-single
       - 2、vim /etc/hostname 修改主机名称
           redis-single
       - 3、vim /etc/sysconfig/network-scripts/ifcfg-ens33 
            修改网卡ip（IPADDR=192.168.59.131）
       - 4、vim /etc/hosts 修改hosts主机配置文件 
            192.168.59.128 aresboot-producer
            192.168.59.129 aresboot-prometheus
            192.168.59.130 aresboot-grafana
            192.168.59.131 redis-single
       - 5、重启全部主机
            reboot
    2、启动redis（src/redis-server /usr/local/redis/redis.conf）
    3、设置redis密码：vim /usr/local/redis/redis.conf 新增 requirepass 404044
    4、重启或者停止redis：src/redis-cli -> auth 404044 > shutdown 停止
#P90 ShedLock动态任务管理
#P91 自定义事件
    事件解耦    
#P92 自定义事件处理
    event->
#P93 @EventListener
    监听事件注解,定义一个config事件
    
==============================2021-08-03============git分支 bt-20210803
#P94 WebService简介
#P95 搭建WebService服务端  
#P96 搭建WebService客户端
#P97 WebSocket简介
    在程序开发过程中，WEB2.0最重要的代表就是AJAX（伪异步应用）
    WebSocket如果要使用肯定还是解决传统的Ajax轮询问题。
    在整个的处理机制里面可以清楚的发现，WebSocket客户端如果要连接到服务器端之后可以在一个连接之内
    进行多次的数据处理操作。    
    可以解决跨域问题。
#P98 开发WebSocket服务端
#P99 开发WebSocket客户端
#P100 Springboot异步   
    现在的JAVA届。只要说到异步，就会联想到（Thread,Runnable,Callable,J.U.C）,之所以采用异步处理原则，主要为了提高
    处理性能。还提供了WebAsyncTask、DeferredResult线程管理类。
#P101 Callable实现异步处理
    Callable是由J.U.C提供的一个线程接口，在使用Callable接口的时候可以方便的实现数据的返回处理，可以进行异步
    返回的操作功能处理，这一点要比传统的使用的Runnable更加简单（Spring对于Runnable没有放弃）。     
#P102 WebAsyncTask  
        WebAsyncTask是一个由Spring提供的异步任务管理类，开发者可以直接在此类中配置要执行的请求处理的异步线程，
    同时也可以配置一个与之相关的超时管理及处理线程，这样在程序出现超时问题后，可以启动另外一个线程进行处理。
        如果要在项目之中启动异步线程，目的就是为了解决超时执行的问题。
#P103 DeferredResult
    实现异步线程控制。基于Runnable  
#P104 Springboot异步任务
    1、异步任务并不参与响应
    2、异步任务的执行完成与否最终的响应没有什么关系
#P105 响应式编程简介
        如果要说到响应式编程，那么最初就是Servlet3.x所提供的异步处理支持（AsycContext），这是一个原始的响应编程，
    但是这种响应编程机制实现难度是较高的，而且代码也非常繁琐。
#P106 WebFlux终端响应
        WebFlux是基于Servlet3.x之后异步响应处理所提供的更简化的实现模式，其最终的实现依靠的也是Spring自己推广
    的一个开源项目：projectreactor.io。
#P107 Springboot整合WebFlux
#P108 Flux返回集合数据    
#P109 Websock支持
#P110 RSocket
        Rsocket是一个协议，是一个类似于HTTP上的通讯协议，之所以推出Springboot技术，主要是为了前后端设计分离，
    因为基于HTTP协议可以直接返回REST数据内容。
        目的是解决物联网的通讯协议。
        HTTP协议中的一切的数据都是以文本形式进行传输，所以在实际开发中就会存在数据传输过大y以及传输结构受限的问题。
        RSocket四种数据交互模式：
            1、Request - And - Response:请求/响应，类似于HTTP的通信特点，提供异步通信与多路复用支持。
            2、Request -Response - Stream:请求/流式响应，一个请求对应多个流式响应，；例如：获取视频列表或产品列表。
            3、Fire - And - Forget:异步触发，可以用于日志记录。
            4、Channel(bi - directional streams):双向异步通讯，消息流在服务端与客户端两个方向上异步流动。
#P111 RSocket基础开发
#P112 搭建RSocket服务端            
#P113 搭建RSocket客户端     
#P114 RSocket文件上传   
#P115 基于RSocket开发WebSocket        
#P116 自动装配简介
#P117 @EnableConfigurationProperties
        按照原始的讲解方式，如果一个bean类的定义上出现有“@EnableConfigurationProperties”，注解项，
    那么就表示该定义为一个组件，否则程序会出现错误，但是此时的配置的启用并不是通过这种“@Component”注解完成
    的，而是通过另外的注解实现的，所以此时即使有错误，也暂时不关注。
#P118 @Import注解
        此注解是将Bean加入到Spring实例管理之中，需要注意的是，如果需要使用@Import，本身却有三种不同的处理形式：
    类导入、ImportSelector导入、ImportBeanDefinitionRegistrar导入。
        方式一：直接进行指定Bean的导入。
        方式二：如果此时你需要注入的Bean有很多，那么按照以上的方式去编写的话就需要写上所有要注册Bean的名称。
                这样就可以使用ImportSelector导入。
        方式三：以上都是由Spring容器负责了Bean的注册，开发者自己定义处理，可以使用“ImportBeanDefinitionRegistrar”。

==============================2021-08-03============git分支 bt-20210803
#P119 application.yml提示
        引入org.springframework.boot:spring-boot-configuration-processor包。
#P120 自定义starter组件
        最重要的spring.factories文件。
#P121 springboot核心启动类
        如果想要去理解Springboot启动流程，实际上就需要分为两个阶段来进行理解，第一个阶段就是注解操作部分，第二个
    才是具体的程序的应用部分。
        在springboot程序启动注解之中就可以发现主要会存在两个子注解：
            - @SpringBootConfiguration：springBoot的启动代理模式配置
            - @EnableAutoConfiguration：启用自动装配
        此时重点观察的是“DeferredImportSelector”接口，因为该类主要用于“@import”注解之中，所以只需要观察其
    如何配置扫描Bean注册即可，观察核心的方法覆写。
        最终所有的扫描配置（包括所有排除的配置）实际上都是通过这个类来实现管理的，那么也就相当于，开发者只需要在
    启动类中配置了一个“SpringBootApplication”注解之后由具体的Selector来负责排除以及扫描包的定义。
#P122 SpringBootApplication构造方法
        面试题：linkedHashSet:主要用来将获取的对象按照顺序保存在一个集合之中。  
        结论：
            SpringApplication类中的构造方法主要完成了如下的几件事情：
                1、获取ResourceLoader接口实例，获取此接口实例的目的是为了便于类加载操作（获取类加载器）。
                2、获取所有的主类，只有一个是主类，所以还需要对主类的结构进行分析。
                3、会自动分析当前的运行模式是Servlet(传统模式)还是Reactive（响应式）。
                4、获取所有的类加载器（包括通过AutoConfiguration + Starter配置的类加载器）。
                5、初始化所有的Bean对象b并且自动进行Bean注册。
                6、设置所有的监听操作，包括时间监听等。
#P123 SpringBootApplication的run方法                
#P124 启动内置WEB容器
#P125 AbstractApplicationContext.refresh()方法    
#P126 springbootCLI配置
    CLI:命令行接口 
    如果要想知道CLI的作用
#P127 使用Groovy开发springboot应用
#P128 springbootCLI工具管理  
    1、使用CLI创建maven项目 
        spring init --dependencies=web,thymeleaf yooyt-boot
    2、使用CLI创建gradle项目
        spring init --build=gradle --java-version=1.8 --dependencies=web,thymeleaf --packaging=war muyan-boot
#P129 Druid基本配置
    推荐阿里的Druid数据库连接池来进行数据库连接。
    1、创建aresboot-database模块
    2、为模块添加依赖配置
#P130 基于Bean配置Druid   
#P131 Druid监控界面  （得露的）
#P133 SQL监控      
#P134 SQL防火墙   
#P135 Spring监控     
#P136 Druid日志记录   
#P137 整合mybatis
#P138 整合mybatisPlus           
#P139 基于Bean模式整合Mybatisplus组件     
#P140 AOP事物处理
    在springboot里面可以直接导入spring配置文件，      
#P141 多数据源操作简介    
#P142 动态数据应决策
    需要用到路由接口：AbstractRoutingDataSource
    DruidMultDataSource        
#P145 JTA分布式事物简介    
    一个项目中创建的若干个数据源一起实现的事物控制；
    为了便于事物处理的规范化配置，在JavaEE中提供了JTA(Java Transaction API、事物处理API)，服务支持，
    该服务允许程序执行分布式事物处理，可以在多个网络资源上访问并更新数据，这样极大增强了JDBC程序的处理能力，
    由于JTA仅仅是一个技术标准，所以在进行分布式事物处理时就需要引入Atomikos开源组件来实现具体的事物管理操作。
#P146 AutomikosDataSource   
    替换数据源：com.alibaba.druid.pool.DruidDataSource 替换为：com.alibaba.druid.pool.DruidDataSource
#P147 多数据源事物管理 
#P148 Mybatis整合分布式事物
     事物的概念：要么同生，要么同死。                             
#P149 SpringSecurity快速整合
    该框架是行业内最早的一款用于实现授权与认证检测的开发框架，那么随后在此框架之后又有了Shiro开发框架，但是
    这些开发框架在原始设计的时候并没有考虑到当今前后端分离的结构。
#P150 基于Bean配置SpringSecurity
#P151 HttpSecurity
#P152 返回Rest认证信息
#P153 UserDetailsService         
#P154 基于数据库实现认证授权操作 
#P155 OAuth2基本概念
    如果要想理解OAuth2，那么首先就应该清楚SSO的概念（单点登录技术），在一个大规模的集群环境之中，可以构建一个统一
    的认证服务器，而这个认证服务器可以为集群之中的所有服务节点提供认证处理
    单点登录的核心概念在于认证操作。
#P156 搭建OAuth2基础服务  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     