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
package mx.com.mezcalium.test.aop;

import org.junit.Assert;
import org.junit.Test;

import mx.com.mezcalium.annotations.ExecutionControl;
import mx.com.mezcalium.web.driver.configuration.WebDriverConfiguration;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class ExecutionControlAspectTest {

	private static int retries = 0;
	
	@Test
	public void testMethodAnnotated() {
		try {
			methodAnnotated();
		} catch (Exception e) {
			Assert.assertEquals(true, retries == WebDriverConfiguration.getRetryOnFailure().getMaxAttempts() + 1);
		}
	}

	@ExecutionControl(id = "TestReply", exceptions = { Exception.class })
	private void methodAnnotated() throws Exception {
		retries++;
		throw new Exception("Intentional exception");
	}
}
