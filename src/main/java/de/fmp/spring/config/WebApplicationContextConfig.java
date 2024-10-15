package de.fmp.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("de.fmp.spring")
public class WebApplicationContextConfig implements WebMvcConfigurer {//WebMvcConfigurerAdapter {

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Hier sicherstellen, dass "/resources/**" vom Pfad bedient wird
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(3600); 
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		// resolver.setPrefix("/WEB-INF/views/");
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DriverManagerDataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/app_user");
		// dataSource.setSchema("user");
		dataSource.setUsername("root");
		dataSource.setPassword("fzsbew");
		return dataSource;
	}

	@Bean(name = "myJDBCBean")
	public JdbcTemplate jdbcTemplate() {
		if (myDataSource() == null) {
			System.out.println("DataSource is null!");
			throw new IllegalArgumentException("DataSource is null!");
		}
		return new JdbcTemplate(myDataSource());
	}

	
}

