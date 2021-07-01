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
    