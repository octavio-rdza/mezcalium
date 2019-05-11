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
public class MezcaliumModel {

	private LoggerModel logger = new LoggerModel();

	private SiteModel site = new SiteModel();

	private WebDriverModel webDriver;

	private WebElementHighlightModel webElementHighlight;

	/**
	 * @return the logger
	 */
	public LoggerModel getLogger() {
		return logger;
	}

	/**
	 * @return the site
	 */
	public SiteModel getSite() {
		return site;
	}

	/**
	 * @return the webDriver
	 */
	public WebDriverModel getWebDriver() {
		return webDriver;
	}

	/**
	 * @return the webElementHighlight
	 */
	public WebElementHighlightModel getWebElementHighlight() {
		return webElementHighlight;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(LoggerModel logger) {
		this.logger = logger;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(SiteModel site) {
		this.site = site;
	}

	/**
	 * @param webDriver the webDriver to set
	 */
	public void setWebDriver(WebDriverModel webDriver) {
		this.webDriver = webDriver;
	}

	/**
	 * @param webElementHighlight the webElementHighlight to set
	 */
	public void setWebElementHighlight(WebElementHighlightModel webElementHighlight) {
		this.webElementHighlight = webElementHighlight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MezcaliumModel [logger=" + logger + ", site=" + site + ", webDriver=" + webDriver
				+ ", webElementHighlight=" + webElementHighlight + "]";
	}

}
