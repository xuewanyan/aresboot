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
#P89 ShedLock动态任务管理
#P90 自定义事件
    事件解耦    
#P91 自定义事件处理
    event->
#P92 @EventListener
    监听事件注解,定义一个config事件
    










