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

import java.io.File;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import mx.com.mezcalium.annotations.TestCase;
import mx.com.mezcalium.web.driver.configuration.WebDriverConfiguration;
import mx.com.mezcalium.web.resources.WebUtilitiesResources;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
@Aspect
public class TestCaseAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(TestCaseAspect.class);
	
	public static String testCase = "DefaultTestCaseName";

	@Pointcut("@annotation(testCase)")
	public void testCasePointcut(TestCase testCase) {
	}

	@Around("testCasePointcut(testCase) && execution(* * (..))")
	public Object testCaseAdvice(ProceedingJoinPoint joinPoint, TestCase testCase) throws Throwable {
		if (!testCase.value().isEmpty()) {
			TestCaseAspect.testCase = testCase.value();
		}
		String testCaseString = TestCaseAspect.testCase.trim().replaceAll("[^a-zA-Z0-9\\.\\-\\_]", "_");
		MDC.put(WebDriverConfiguration.getLoggerfilename(), String.format("%s/%s-%s", testCaseString, testCaseString, System.currentTimeMillis()));
		File dirTestCaseLog = new File(WebDriverConfiguration.getDirLog() + testCaseString);
		if (!dirTestCaseLog.exists()) {
			dirTestCaseLog.mkdirs();
		}
		LOGGER.info("[ START TEST CASE ] | [ {} ]", testCase.value());
		Object returnObject = joinPoint.proceed();
		LOGGER.info("[ END TEST CASE ] | [ {} ]", testCase.value());
		ExecutionControlAspect.step = 0;
		TestCaseAspect.testCase = "DefaultScreenshot";
		WebUtilitiesResources.setCounterScreenShot(0);
		return returnObject;
	}

}
