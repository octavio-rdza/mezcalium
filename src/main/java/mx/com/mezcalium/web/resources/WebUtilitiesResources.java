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

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.mezcalium.aop.TestCaseAspect;
import mx.com.mezcalium.web.driver.configuration.WebDriverConfiguration;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class WebUtilitiesResources {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebUtilitiesResources.class);

	private static int counterScreenShot = 0;

	private static JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverConfiguration.getDriver();

	private static String setAttribute = "arguments[0].setAttribute('style', 'border: "
			+ WebDriverConfiguration.getWebElementHighlightModel().getSize() + " "
			+ WebDriverConfiguration.getWebElementHighlightModel().getType() + " "
			+ WebDriverConfiguration.getWebElementHighlightModel().getColor() + ";');";

	private static String removeAttribute = "arguments[0].removeAttribute('style');";

	/**
	 * @return the counterScreenShot
	 */
	public static int getCounterScreenShot() {
		return counterScreenShot;
	}

	/**
	 * @param counterScreenShot the counterScreenShot to set
	 */
	public static void setCounterScreenShot(int counterScreenShot) {
		WebUtilitiesResources.counterScreenShot = counterScreenShot;
	}

	public static void setStyleWebElement(WebElement element) {
		jsExecutor.executeScript(setAttribute, element);
	}

	public static void removeStyleWebElement(WebElement element) {
		jsExecutor.executeScript(removeAttribute, element);
	}

	public static void waitElementToBeClickable(WebElement element) {
		WebTimeoutsResources.pageLoadTimeout(WebDriverConfiguration.getWaitTimes().getPageLoadTimeout(),
				TimeUnit.MILLISECONDS);
		WebDriverConfiguration.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void takeScreenshot(boolean scrollScreenshot) {
		WebTimeoutsResources.pageLoadTimeout(WebDriverConfiguration.getWaitTimes().getPageLoadTimeout(),
				TimeUnit.MILLISECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LOGGER.info("{}", e);
		}
		String dirTestCaseScreenshots = String.format("%s%s/%s-%04d.png",
				WebDriverConfiguration.getDirScreenshots(),
				TestCaseAspect.testCase,
				TestCaseAspect.testCase,
				counterScreenShot++);
		File destinationFile = new File(dirTestCaseScreenshots);
		if (scrollScreenshot) {
			LOGGER.info("Take Full Page Screenshot");
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(WebDriverConfiguration.getDriver());
			try {
				ImageIO.write(screenshot.getImage(), "PNG", destinationFile);
				LOGGER.info("Take screenshot at: {}", dirTestCaseScreenshots);
			} catch (IOException e) {
				LOGGER.info("{}", e);
			}
		} else {
			TakesScreenshot scrShot = ((TakesScreenshot) WebDriverConfiguration.getDriver());
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, destinationFile);
				LOGGER.info("Take screenshot at: {}", dirTestCaseScreenshots);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
