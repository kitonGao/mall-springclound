
###spring-boot-starter-actuator（健康监控）配置和使用


在生产环境中，需要实时或定期监控服务的可用性。Spring Boot的actuator（健康监控）功能提供了很多监控所需的接口，可以对应用系统进行配置查看、相关功能统计等。

-集成：

    <dependency> 
    
        <groupId>org.springframework.boot</groupId> 
    
        <artifactId>spring-boot-starter-actuator</artifactId> 
    
    </dependency> 
    
    如果使用HTTP调用的方式，还需要这个依赖：
    
    <dependency> 
    
        <groupId>org.springframework.boot</groupId> 
    
        <artifactId>spring-boot-starter-web</artifactId> 
    
    </dependency> 

- 配置：


    application.yml中指定监控的HTTP端口（如果不指定，则使用和Server相同的端口）；指定去掉某项的检查（比如不监控health.mail）：
    
    server: 
    
      port: 8082 
    
    management: 
    
      port: 54001 
    
      health: 
    
        mail: 
    
          enabled: false 

- 使用：
   - HTTP方法 路径 描述 鉴权
   - GET /autoconfig 查看自动配置的使用情况 true    
   - GET /configprops 查看配置属性，包括默认配置 true    
   - GET /beans 查看bean及其关系列表 true    
   - GET /dump 打印线程栈 true    
   - GET /env 查看所有环境变量 true    
   - GET /env/{name} 查看具体变量值 true    
   - GET /health 查看应用健康指标 false    
   - GET /info 查看应用信息（需要自己在application.properties里头添加信息，比如info.contact.email=easonjim@163.com） false    
   - GET /mappings 查看所有url映射 true    
   - GET /metrics 查看应用基本指标 true    
   - GET /metrics/{name} 查看具体指标 true    
   - POST /shutdown 关闭应用（要真正生效，得配置文件开启endpoints.shutdown.enabled: true） true    
   - GET /trace 查看基本追踪信息 true

作者：黑客不黑撒
链接：https://www.jianshu.com/p/d57dc9f2e0d9
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。