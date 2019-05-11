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

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class RetryOnFailureModel {

	private int maxAttempts = 0;

	private long runEvery = 0L;

	/**
	 * @return the maxAttempts
	 */
	public int getMaxAttempts() {
		return maxAttempts;
	}

	/**
	 * @return the runEvery
	 */
	public long getRunEvery() {
		return runEvery;
	}

	/**
	 * @param maxAttempts the maxAttempts to set
	 */
	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	/**
	 * @param runEvery the runEvery to set
	 */
	public void setRunEvery(long runEvery) {
		this.runEvery = runEvery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetryOnFailureModel [maxAttempts=" + maxAttempts + ", runEvery=" + runEvery + "]";
	}
}
