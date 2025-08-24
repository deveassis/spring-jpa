package io.github.cursojava.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		// DESLIGA O BANNER DO PROMPT
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");

		//builder.lazyInitialization(true);
		builder.run(args);

		//Contexto da aplicacao ja iniciada:
		ConfigurableApplicationContext applicationContext = builder.context();

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicacao: " + applicationName);


		ExemploValue value = applicationContext.getBean(ExemploValue.class);
		value.imprimirVariavel();


		AppProperties properties = applicationContext.getBean(AppProperties.class);
		System.out.println(properties.getValor1());
	}
}
