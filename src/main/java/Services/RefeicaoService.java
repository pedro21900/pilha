package Services;


import Model.Refeicao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RefeicaoService {

        @Test
    public void cosumerApi() {
            RestTemplate template = new RestTemplate();
            UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("www.themealdb.com")
                    .path("api/json/v1/1")
                    .queryParam("search.php?s","")
                    .build();

            ResponseEntity<Refeicao> entity = template.getForEntity(uri.toUriString(),Refeicao.class);
            System.out.println(entity.getBody().getStrInstructions());
        }


}
