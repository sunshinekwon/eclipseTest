package com.example.hojinToyProj.main;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MysqlRunner implements ApplicationRunner {

	private DataSource datasource;
	
	public MysqlRunner(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try(Connection connection = datasource.getConnection()){
			log.info("[MysqlRunner] - datasource : "+datasource.getClass());
			log.info("[MysqlRunner] - url : "+connection.getMetaData().getURL());
			log.info("[MysqlRunner] - username : "+connection.getMetaData().getUserName());
		}
		
	}
	
}
