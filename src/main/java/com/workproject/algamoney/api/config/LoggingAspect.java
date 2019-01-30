package com.workproject.algamoney.api.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@AfterReturning(pointcut = "execution(* com.workproject.algamoney.api.resource.*.*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		log.info("logAfterReturning() is running!");
		log.info("hijacked : " + joinPoint.getSignature().getName());
		log.info("Method returned value is : " + result);
		log.info("******");

	}
	/*
	 * @Around("execution(* com.workproject.algamoney.api.resource.*.*(..))") public
	 * Object handleAccessToken(ProceedingJoinPoint thisJoinPoint) throws Throwable
	 * { System.out.println(thisJoinPoint); Object[] args = thisJoinPoint.getArgs();
	 * MethodSignature methodSignature = (MethodSignature)
	 * thisJoinPoint.getStaticPart().getSignature(); Method method =
	 * methodSignature.getMethod(); Parameter[] parameters = method.getParameters();
	 * 
	 * for (int index = 0; index < parameters.length; index++) {
	 * System.out.println(parameters[index].getClass().getSimpleName() +" "+
	 * args[index]); }
	 * 
	 * assert args.length == parameterAnnotations.length; for (int argIndex = 0;
	 * argIndex < args.length; argIndex++) { for (Annotation annotation :
	 * parameterAnnotations[argIndex]) { if (!(annotation instanceof RequestParam))
	 * continue; RequestParam requestParam = (RequestParam) annotation; if
	 * (!"accessToken".equals(requestParam.value())) continue;
	 * System.out.println("  " + requestParam.value() + " = " + args[argIndex]); } }
	 * return thisJoinPoint.proceed(); }
	 */

	@AfterThrowing(pointcut = "execution(* com.workproject.algamoney.api.resource.*.*(..))", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}

}
