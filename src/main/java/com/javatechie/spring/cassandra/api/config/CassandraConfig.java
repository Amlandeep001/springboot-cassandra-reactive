package com.javatechie.spring.cassandra.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration
{
	private final String keySpace;

	public CassandraConfig(@Value("${spring.cassandra.keyspace-name}") String keySpace)
	{
		this.keySpace = keySpace;
	}

	@Override
	protected String getKeyspaceName()
	{
		return keySpace;
	}
}
