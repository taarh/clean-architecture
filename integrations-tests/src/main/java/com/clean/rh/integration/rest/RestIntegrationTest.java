package com.clean.rh.integration.rest;


import com.clean.rh.Application;
import com.clean.rh.configuration.DatabaseDataProviderConfiguration;
import com.clean.rh.configuration.DatasourceConfiguration;
import com.clean.rh.configuration.EndpointConfiguration;
import com.clean.rh.configuration.UseCaseConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={Application.class})
public class RestIntegrationTest {

}
