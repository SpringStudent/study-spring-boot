package ning.zhou.study.springboot.studyspringboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import io.github.springstudent.core.EnableDubboSwagger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableAsync
@EnableDubbo
@EnableDubboSwagger(classPackage = "ning.zhou.study.springboot.studyspringboot.web")
public class StudySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringBootApplication.class, args);
    }

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "firstDataSource")
    @Qualifier("firstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "firstJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("firstDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
