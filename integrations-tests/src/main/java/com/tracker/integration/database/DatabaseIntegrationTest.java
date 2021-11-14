package com.tracker.integration.database;


import com.tracker.configuration.DatabaseDataProviderConfiguration;
import com.tracker.configuration.DatasourceConfiguration;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={DatasourceConfiguration.class, DatabaseDataProviderConfiguration.class})
public class DatabaseIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    protected void cleanUpDatabase() {
        jdbcTemplate.update("DELETE FROM CLEAN_ARCHITECTURE.PERSONNE");
    }


}
