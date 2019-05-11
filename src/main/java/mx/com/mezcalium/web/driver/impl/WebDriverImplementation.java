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
package mx.com.mezcalium.web.driver.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.mezcalium.web.configuration.model.BrowsersConfigurationsModel;
import mx.com.mezcalium.web.configuration.model.MapperConfiguration;
import mx.com.mezcalium.web.configuration.model.WebDriverModel;
import mx.com.mezcalium.web.driver.CustomWebDriverImplementation;
import mx.com.mezcalium.web.driver.configuration.WebDriverConfiguration;
import mx.com.mezcalium.web.resources.model.WebResourcesKeys;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public final class WebDriverImplementation implements CustomWebDriverImplementation {

	private final Logger LOGGER = LoggerFactory.getLogger(WebDriverImplementation.class);

	@Override
	public WebDriver webDriverImplementation() {
		MapperConfiguration mapperConfiguration = WebDriverConfiguration.getMapperConfiguration();
		WebDriverModel webDriver = mapperConfiguration.getMezcalium().getWebDriver();
		String selectBrowser = webDriver.getSelectBrowser();
		BrowsersConfigurationsModel browsersConfigurations = webDriver.getBrowsersConfigurations().get(selectBrowser);
		String driverPathFile = browsersConfigurations.getDriverPathFile();
		String logDriver = "{} driver initializing...";
		if (selectBrowser.equalsIgnoreCase(WebResourcesKeys.FIREFOX)) {
			LOGGER.info(logDriver, WebResourcesKeys.FIREFOX);
			System.setProperty("webdriver.gecko.driver", driverPathFile);
			FirefoxOptions options = new FirefoxOptions();
			options.setLogLevel(FirefoxDriverLogLevel.fromString(WebDriverConfiguration.getLoggerLevel()));
			return new FirefoxDriver(options);
		}
		if (selectBrowser.equalsIgnoreCase(WebResourcesKeys.CHROME)) {
			LOGGER.info(logDriver, WebResourcesKeys.CHROME);
			System.setProperty("webdriver.chrome.driver", driverPathFile);
			ChromeOptions options = new ChromeOptions();
			return new ChromeDriver(options);
		}
		if (selectBrowser.equalsIgnoreCase(WebResourcesKeys.EDGE)) {
			LOGGER.info(logDriver, WebResourcesKeys.EDGE);
			System.setProperty("webdriver.edge.driver", driverPathFile);
			EdgeOptions options = new EdgeOptions();
			return new EdgeDriver(options);
		}
		if (selectBrowser.equalsIgnoreCase(WebResourcesKeys.IE)) {
			LOGGER.info(logDriver, WebResourcesKeys.IE);
			System.setProperty("webdriver.ie.driver", driverPathFile);
			InternetExplorerOptions options = new InternetExplorerOptions();
			return new InternetExplorerDriver(options);
		}
		return null;
	}

}
