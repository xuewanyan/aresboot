package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.repository.Repository;

@Target(ElementType.TYPE)   // 常规的annotation配置
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
@Documented // 
@Inherited  // 允许被继承
@SpringBootConfiguration // springBoot配置注解
@EnableAutoConfiguration // 启用自动配置

// 配置扫描包
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
		
		
public @interface SpringBootApplication {

	// 定义一个别名
	@AliasFor(annotation = EnableAutoConfiguration.class)
	Class<?>[] exclude() default {};

    // 定义别名
	@AliasFor(annotation = EnableAutoConfiguration.class)
	String[] excludeName() default {};

	// 定义扫描包
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};

    // 扫描类
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasePackageClasses() default {};

	@AliasFor(annotation = ComponentScan.class, attribute = "nameGenerator")
	Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

	// 扫描模式
	@AliasFor(annotation = Configuration.class)
	boolean proxyBeanMethods() default true;

}
