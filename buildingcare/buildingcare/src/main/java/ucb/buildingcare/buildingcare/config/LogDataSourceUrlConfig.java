package ucb.buildingcare.buildingcare.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class LogDataSourceUrlConfig {

    private static final Logger log = LoggerFactory.getLogger(LogDataSourceUrlConfig.class);

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Bean
    CommandLineRunner logUrl() {
        return args -> log.info("DataSource URL: {}", datasourceUrl);
    }
}