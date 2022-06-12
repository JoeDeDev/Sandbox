package de.joe.springboottrainer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author JoeDeDev
 */
@Component
public class AwareDemo implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       applicationContext.getBeansWithAnnotation(Component.class).forEach((s,o) -> System.out.println("Context-Bean:"+s));
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("My name is "+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set in AwareDemo");
    }

    @PostConstruct
    public void init(){
        System.out.println("init AwareDemo");
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("init PreDestroy");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy in Aware");
    }
    
}
