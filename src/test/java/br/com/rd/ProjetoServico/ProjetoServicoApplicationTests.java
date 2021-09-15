package br.com.rd.ProjetoServico;

import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Model.DTO.MediaDTO;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@AutoConfigureMockMvc
@SpringBootTest(classes = ProjetoServicoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjetoServicoApplicationTests {

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	private HttpHeaders headers = new HttpHeaders();

	@Test
	void contextLoads() throws Exception{
		runPostCars();
		runGetCars("{id:1, brand:Fiat}");
		runGetCars("{id:1, brand:Mercedes}");
	}

	private void runGetCars(String expected) throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/cars/1"),
				HttpMethod.GET, entity, String.class);

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private MockMvc mvc;

	private void runPostCars() throws JSONException {
		MediaDTO media = new MediaDTO();
		media.setDescription("Aiwa");
		media.setTouch(true);

		CarDTO car = new CarDTO();
		car.setBrand("Polo");
		car.setTurbine(true);
		car.setModel("Volkswagen");
		car.setYear(2021);
		car.setMedia(media);

//		HttpEntity<CarDTO> entity = new HttpEntity<CarDTO>(car, headers);
//
//		ResponseEntity<String> response = restTemplate.exchange(
//				createURLWithPort("/cars"),
//				HttpMethod.POST, entity, String.class);
//		String actual = response.getBody();
////		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
//
//		assertTrue(actual.contains("/carService"));

//		MockHttpServletResponse response = mvc.perform(
//				post("/cars").contentType(MediaType.APPLICATION_JSON).content(
//						jsonSuperHero.write(car).getJson()
//				)).andReturn().getResponse();
//
//		// then
//		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
