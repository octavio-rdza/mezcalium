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
package mx.com.mezcalium.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * This annotation can use if you want to tracker the execution a method.
 * 
 * <p>
 * For example:
 *
 * <pre class="code">
 * &#64;ExecutionTracker(id = "id of the execution")
 * void method() { ... }
 * </pre>
 * 
 * <p>
 * and you can rerun the method the times that you declare if throws any
 * exeption you specify.
 * 
 * <p>
 * For example:
 * 
 * <pre class="code">
 * &#64;ExecutionTracker(
 * 	id = "id of the execution",
 * 	retries = 5,
 * 	exceptions = { RuntimeException.class }
 * )
 * void method() { ... }
 * </pre>
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExecutionControl {

	final class DefaultExceptionsClass extends Throwable {

		private static final long serialVersionUID = 1L;

		private DefaultExceptionsClass() {
		}
	}

	String id();

	Class<? extends Throwable>[] exceptions() default { DefaultExceptionsClass.class };
}
