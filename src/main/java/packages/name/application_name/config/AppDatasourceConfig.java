package packages.name.application_name.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"packages.name.application_name.dao.repository"},
        entityManagerFactoryRef = "appEntityManager",
        transactionManagerRef = "appTransactionManager"
)
public class AppDatasourceConfig {
    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @FlywayDataSource
    public DataSource appDataSource(){
        DataSourceProperties appDataSourceProperties = appDataSourceProperties();
        return DataSourceBuilder.create()
                .driverClassName(appDataSourceProperties.getDriverClassName())
                .url(appDataSourceProperties.getUrl())
                .username(appDataSourceProperties.getUsername())
                .password(appDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager appTransactionManager() {
        EntityManagerFactory factory = appEntityManager().getObject();
        return new JpaTransactionManager(Objects.requireNonNull(factory));
    }

    @Bean(name = "appEntityManager")
    public LocalContainerEntityManagerFactoryBean appEntityManager(){
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(appDataSource());
        em.setPackagesToScan(
                "packages.name.application_name.dao.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("app.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql",
                env.getProperty("app.jpa.show-sql"));
        em.setJpaProperties(properties);

        return em;
    }
}