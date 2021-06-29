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

#P16  2021-06-29 Accessor
    1、fluent模式:可以将属性的名称作为属性设置和返回。不包含setter,getter方法
    2、chain模式：可以将属性的名称作为属性设置和返回。包含setter,getter方法
    
#P17  2021-06-29 理解建造者模式
    