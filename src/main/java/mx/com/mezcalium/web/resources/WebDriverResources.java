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
package mx.com.mezcalium.web.resources;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

import mx.com.mezcalium.annotations.ExecutionControl;
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
public class WebDriverResources {

//	private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverResources.class);

	@ExecutionControl(id = WebResourcesKeys.GET)
	public static void get(String url) {
		WebTimeoutsResources.pageLoadTimeout(WebDriverConfiguration.getWaitTimes().getPageLoadTimeout(), TimeUnit.MILLISECONDS);
		WebDriverConfiguration.getDriver().get(url);
	}

	String getCurrentUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return null;
	}

	String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	void close() {
		// TODO Auto-generated method stub

	}

	void quit() {
		// TODO Auto-generated method stub

	}

	Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
}
