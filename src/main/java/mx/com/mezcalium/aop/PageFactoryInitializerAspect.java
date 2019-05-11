/*
 * Copyright 2019 Mezcalium | Octavio Rodriguez
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mx.com.mezcalium.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.mezcalium.annotations.PageFactoryInitializer;
import mx.com.mezcalium.web.driver.configuration.WebDriverConfiguration;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
@Aspect
public class PageFactoryInitializerAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(PageFactoryInitializerAspect.class);

	@Pointcut("@annotation(pageFactoryInitialize)")
	public void pageFactoryInitializePointcut(PageFactoryInitializer pageFactoryInitialize) {
	}

	@Around("pageFactoryInitializePointcut(pageFactoryInitialize)")
	public void pageFactoryInitializeAdvice(ProceedingJoinPoint joinPoint, PageFactoryInitializer pageFactoryInitialize)
			throws Throwable {
		joinPoint.proceed();
		Class<?> classAnotatted = joinPoint.getSignature().getDeclaringType();
		PageFactory.initElements(WebDriverConfiguration.getDriver(), classAnotatted);
		LOGGER.info("[ INIT PAGE ] Iniciallizando {}", classAnotatted);
	}
}
