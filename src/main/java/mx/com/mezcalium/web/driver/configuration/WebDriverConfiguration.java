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
package mx.com.mezcalium.web.driver.configuration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import mx.com.mezcalium.web.configuration.model.BrowsersConfigurationsModel;
import mx.com.mezcalium.web.configuration.model.MapperConfiguration;
import mx.com.mezcalium.web.configuration.model.RetryOnFailureModel;
import mx.com.mezcalium.web.configuration.model.SiteModel;
import mx.com.mezcalium.web.configuration.model.WaitTimeModel;
import mx.com.mezcalium.web.configuration.model.WebDriverModel;
import mx.com.mezcalium.web.configuration.model.WebElementHighlightModel;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public final class WebDriverConfiguration {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	private WebDriverConfiguration() {
	}

	private static WebDriver driver;

	private static Wait<WebDriver> wait;

	private static MapperConfiguration mapperConfiguration;

	private static SiteModel site;

	private static String loggerLevel;

	private static WebElementHighlightModel webElementHighlightModel;

	private static WebDriverModel webDriverModel;

	private static WaitTimeModel waitTimes;

	private static RetryOnFailureModel retryOnFailure;

	private static BrowsersConfigurationsModel browsersConfigurations;

	private static String dirScreenshots = WebDriverConfigurationKeys.DIR_SCREENSHOTS;

	private static String dirLog = WebDriverConfigurationKeys.DIR_LOGS;

	private static String dirPropertiesFile = WebDriverConfigurationKeys.DIR_PROPERTIES_FILE;

	private static final String loggerFileName = "loggerFileName";

	public static String getLoggerfilename() {
		return loggerFileName;
	}

	public static String getDirScreenshots() {
		return dirScreenshots;
	}

	public static String getDirLog() {
		return dirLog;
	}

	public static String getDirPropertiesFile() {
		return dirPropertiesFile;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Wait<WebDriver> getWait() {
		return wait;
	}

	public static MapperConfiguration getMapperConfiguration() {
		return mapperConfiguration;
	}

	public static SiteModel getSite() {
		return site;
	}

	public static WebElementHighlightModel getWebElementHighlightModel() {
		return webElementHighlightModel;
	}

	public static WebDriverModel getWebDriverModel() {
		return webDriverModel;
	}

	public static WaitTimeModel getWaitTimes() {
		return waitTimes;
	}

	public static RetryOnFailureModel getRetryOnFailure() {
		return retryOnFailure;
	}

	public static BrowsersConfigurationsModel getBrowsersConfigurations() {
		return browsersConfigurations;
	}

	public static String getLoggerLevel() {
		return loggerLevel;
	}

	public static void setDriver(WebDriver driver) {
		if (driver != null) {
			WebDriverConfiguration.driver = driver;
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(waitTimes.getImplicitlyWait(), TimeUnit.MILLISECONDS);
			driver.manage().window().maximize();
			WebDriverConfiguration.wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofMillis(waitTimes.getImplicitlyWait()))
					.pollingEvery(Duration.ofMillis(waitTimes.getPoolingEvery()));
			if (site.getInitialUrl() != null) {
				driver.get(site.getInitialUrl());
			}
		} else {
			System.exit(0);
		}
	}

	static {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		File propetiesFile = new File(dirPropertiesFile);
		try {
			mapperConfiguration = mapper.readValue(propetiesFile, MapperConfiguration.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		loggerLevel = mapperConfiguration.getMezcalium().getLogger().getLevel();
		LOGGER.setLevel(Level.toLevel(loggerLevel));
		site = mapperConfiguration.getMezcalium().getSite();
		webElementHighlightModel = mapperConfiguration.getMezcalium().getWebElementHighlight();
		webDriverModel = mapperConfiguration.getMezcalium().getWebDriver();
		waitTimes = webDriverModel.getWaitTimes();
		retryOnFailure = webDriverModel.getRetryOnFailure();
		browsersConfigurations = webDriverModel.getBrowsersConfigurations().get(webDriverModel.getSelectBrowser());
		waitTimes = webDriverModel.getWaitTimes();
	}
}
