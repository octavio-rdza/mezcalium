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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.mezcalium.annotations.TestCase;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class TestCaseAspectTest {
	
	private final Logger LOGGER = LoggerFactory.getLogger(TestCaseAspectTest.class);
	
	@Test
	@TestCase("Test Annotation:test01")
	public void test01() {
		for (int i = 0; i < 10; i++) {
			LOGGER.info("foo: {}", i);
			LOGGER.info("bar: {}", i);
			LOGGER.info("+++++++++++++");
		}
	}
	
	@Test
	@TestCase("Test Annotation:test02")
	public void test02() {
		for (int i = 0; i < 10; i++) {
			LOGGER.info("foo: {}", i);
			LOGGER.info("bar: {}", i);
			LOGGER.info("+++++++++++++");
		}
	}

}
