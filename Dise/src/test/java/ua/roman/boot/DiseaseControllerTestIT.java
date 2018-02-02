package ua.roman.boot;



import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.MatcherAssertionErrors;
import org.springframework.web.client.RestTemplate;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.extensions;

import ua.roman.DiseApplication;
import ua.roman.model.Disease;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DiseaseControllerTestIT {

		TestRestTemplate resttemplate = new TestRestTemplate();


	@Test
	public void getListAllDiseasesTest() {
		ResponseEntity<List<Disease>> entity = resttemplate.exchange("http://localhost:8099/repository/alldisease", HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Disease>>() {});
		
		List<Disease> list = entity.getBody();
		
		assertThat(list.size(), is(2));
	}

}
