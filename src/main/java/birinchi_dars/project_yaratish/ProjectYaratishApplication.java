package birinchi_dars.project_yaratish;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectYaratishApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectYaratishApplication.class, args);
		//System.out.println("Proektimiz ishga tushdi!.");
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
