package br.com.shelfpix.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	//Exemplo de como usar mais de um DB no Spring
	
	/*
	@Bean(name = "mysqlDb")
	@Primary
	@ConfigurationProperties(prefix = "spring.db_mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "mysql")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("mysqlDb") DataSource mysqlDb) { 
        return new JdbcTemplate(mysqlDb); 
    }
    */

	@Bean(name = "sqliteDb")
	@ConfigurationProperties(prefix = "spring.db_sqlite")
	public DataSource sqliteDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sqlite")
	public JdbcTemplate sqliteJdbcTemplate(
			@Qualifier("sqliteDb") DataSource sqliteDb) {
		return new JdbcTemplate(sqliteDb);
	}
}
