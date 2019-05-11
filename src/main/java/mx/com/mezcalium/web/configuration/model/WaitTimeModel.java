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
package mx.com.mezcalium.web.configuration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WaitTimeModel {

	private long implicitlyWait = 0L;

	private long pageLoadTimeout = 0L;

	private long poolingEvery = 0L;

	/**
	 * @return the implicitlyWait
	 */
	public long getImplicitlyWait() {
		return implicitlyWait;
	}

	/**
	 * @return the pageLoadTimeout
	 */
	public long getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	/**
	 * @return the poolingEvery
	 */
	public long getPoolingEvery() {
		return poolingEvery;
	}

	/**
	 * @param implicitlyWait the implicitlyWait to set
	 */
	public void setImplicitlyWait(long implicitlyWait) {
		this.implicitlyWait = implicitlyWait;
	}

	/**
	 * @param pageLoadTimeout the pageLoadTimeout to set
	 */
	public void setPageLoadTimeout(long pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	/**
	 * @param poolingEvery the poolingEvery to set
	 */
	public void setPoolingEvery(long poolingEvery) {
		this.poolingEvery = poolingEvery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WaitTimeModel [implicitlyWait=" + implicitlyWait + ", pageLoadTimeout=" + pageLoadTimeout + ", poolingEvery="
				+ poolingEvery + "]";
	}
}
