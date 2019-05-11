package mx.com.mezcalium.test.configuration;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import mx.com.mezcalium.web.configuration.model.MapperConfiguration;

public class TestMezcaliumIT {
	@Test
	public void test01() {
		try {
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			File file = new File("src/test/resources/mezcalium.yml");
			MapperConfiguration mapperConfiguration = mapper.readValue(file, MapperConfiguration.class);
			System.out.println(mapperConfiguration.toString());
			String selectBrowser = mapperConfiguration.getMezcalium().getWebDriver().getSelectBrowser();
			System.out.println(
					mapperConfiguration.getMezcalium().getWebDriver().getBrowsersConfigurations().get(selectBrowser));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
