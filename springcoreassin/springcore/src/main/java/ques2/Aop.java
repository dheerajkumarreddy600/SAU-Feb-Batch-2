package ques2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy

public class Aop {
	
    @After("pointBreak()")
    public static void afterannotation() {
        System.out.println("after");
    }
    @Pointcut("execution (public void getName())")
    public void pointBreak() {
    }
    @AfterReturning(pointcut = "execution(int getnumber())", returning = "number")
    public void afterreturningannotation(int number) {
        System.out.println("After returning annotation. Returned number = " + number);
    }
}
