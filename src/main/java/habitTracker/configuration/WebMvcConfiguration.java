package habitTracker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	@Override 
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
//			.allowedHeaders("token")
			.allowedOrigins("*")		
			.allowedMethods("*");				
	}	

}
