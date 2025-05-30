package task.firstTaskForSpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "task.firstTaskForSpringBoot.dao")
public class HibernateConfig {
    // Конфигурация теперь автоматически управляется Spring Boot
}