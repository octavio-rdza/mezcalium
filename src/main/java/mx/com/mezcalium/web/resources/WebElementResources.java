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

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import mx.com.mezcalium.annotations.ExecutionControl;
import mx.com.mezcalium.web.resources.model.WebResourcesKeys;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class WebElementResources {

	<X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void click(WebElement element) {
		click(element, false, false);
	}

	public static void click(WebElement element, boolean takeScreenshot) {
		click(element, takeScreenshot, false);
	}

	@ExecutionControl(id = WebResourcesKeys.CLICK, exceptions = { NoSuchElementException.class, ElementClickInterceptedException.class })
	public static void click(WebElement element, boolean takeScreenshot, boolean scrollScreenshot) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		WebUtilitiesResources.setStyleWebElement(element);
		if (takeScreenshot) {
			WebUtilitiesResources.takeScreenshot(scrollScreenshot);
		}
		WebUtilitiesResources.removeStyleWebElement(element);
		element.click();
	}

	void submit() {
		// TODO Auto-generated method stub

	}

	public static void sendKeys(WebElement element, CharSequence... keysToSend) {
		sendKeys(element, false, keysToSend);
	}

	public static void sendKeys(WebElement element, boolean clearText, CharSequence... keysToSend) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		if (clearText) {
			clear(element);
		}
		WebUtilitiesResources.setStyleWebElement(element);
		element.sendKeys(keysToSend);
		WebUtilitiesResources.removeStyleWebElement(element);
	}

	public static void clear(WebElement element) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		WebUtilitiesResources.setStyleWebElement(element);
		element.clear();
		WebUtilitiesResources.removeStyleWebElement(element);
	}

	String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	@ExecutionControl(id = WebResourcesKeys.GET_ATTRIBUTE, exceptions = { NoSuchElementException.class })
	public static String getAttribute(WebElement element, String name) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		WebUtilitiesResources.setStyleWebElement(element);
		String attributeValue = element.getAttribute(name);
		WebUtilitiesResources.removeStyleWebElement(element);
		return attributeValue;
	}

	boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	String getText() {
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

	boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
