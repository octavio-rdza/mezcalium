package mx.com.mezcalium.web.resources;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * TODO Auto-generated
 * 
 * @author <a href="https://github.com/octavio-rdza/mezcalium-web">Mezcalium</a>
 * @author <a href="https://github.com/octavio-rdza">Octavio Rodriguez</a>
 * 
 * @since 0.0.1
 */
public class WebSelectResources {

	boolean isMultiple() {
		// TODO Auto-generated method stub
		return false;
	}

	List<WebElement> getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	List<WebElement> getAllSelectedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	WebElement getFirstSelectedOption() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void selectByVisibleText(WebElement element, String text) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		WebUtilitiesResources.setStyleWebElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebUtilitiesResources.removeStyleWebElement(element);
	}

	public static void selectByIndex(WebElement element, int index) {
		WebUtilitiesResources.waitElementToBeClickable(element);
		WebUtilitiesResources.setStyleWebElement(element);
		Select select = new Select(element);
		select.selectByIndex(index);
		WebUtilitiesResources.removeStyleWebElement(element);
	}

	void selectByValue(String value) {
		// TODO Auto-generated method stub

	}

	void deselectAll() {
		// TODO Auto-generated method stub

	}

	void deselectByValue(String value) {
		// TODO Auto-generated method stub

	}

	void deselectByIndex(int index) {
		// TODO Auto-generated method stub

	}

	void deselectByVisibleText(String text) {
		// TODO Auto-generated method stub

	}

}
