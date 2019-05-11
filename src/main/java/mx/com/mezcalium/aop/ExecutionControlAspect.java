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
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import mx.com.mezcalium.annotations.ExecutionControl;
import mx.com.mezcalium.web.configuration.model.RetryOnFailureModel;
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
public class ExecutionControlAspect {

	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ExecutionControlAspect.class);

	public static int step = 0;

	@Pointcut("@annotation(executionTracker)")
	public void executionTrackerPointcut(ExecutionControl executionTracker) {
	}

	@Around("executionTrackerPointcut(executionTracker) && execution(* * (..))")
	public Object executionTrackerAdvice(ProceedingJoinPoint joinPoint, ExecutionControl executionTracker) throws Throwable {
		RetryOnFailureModel retryOnFailureModel = WebDriverConfiguration.getRetryOnFailure();
		LOGGER.info("[ STEP {} ]", ++step);
		int attempt = 0;
		while (true) {
			try {
				LOGGER.info("[ START ] | [ {} ]", executionTracker.id());
				Object returnObject = joinPoint.proceed();
				LOGGER.info("[  END  ] | [ {} ]", executionTracker.id());
				return returnObject;
			} catch (Throwable e) {
				boolean retry = isExistMatches(e.getClass(), executionTracker.exceptions());
				if (retry && ++attempt <= retryOnFailureModel.getMaxAttempts()) {
					Thread.sleep(retryOnFailureModel.getRunEvery());
					LOGGER.debug("[ ATTEMPT {}] Retrying to run the process after to {} miliseconds.", attempt,
							retryOnFailureModel.getRunEvery());
				} else {
					LOGGER.error("An Exception ocurred: ", e);
					throw e;
				}
			}
		}
	}

	private boolean isExistMatches(Class<? extends Throwable> catchException, Class<? extends Throwable>[] annotationExceptions) {
		for (Class<? extends Throwable> exception : annotationExceptions) {
			if (catchException.isAssignableFrom(exception)) {
				return true;
			}
		}
		return false;
	}
}
