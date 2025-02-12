package com.vinhnt.applicationservice.config.database;

import com.vinhnt.applicationservice.adapter.outbound.inventory.persistence.JPAProduct;
import com.vinhnt.common.config.database.DataSourceConfig;
import com.vinhnt.common.config.property.DataSourceProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

@EnableJpaRepositories(
        basePackages = "com.vinhnt.applicationservice.adapter.outbound.inventory",
        entityManagerFactoryRef = DatabaseInventoryConfig.ENTITY_MANAGER,
        transactionManagerRef = DatabaseInventoryConfig.TRANS_MANAGER
)
@Configuration
public class DatabaseInventoryConfig {
    public final static String ENTITY_MANAGER = "productEntityManager";
    public final static String TRANS_MANAGER = "productTransactionManager";
    public final static String DATASOURCE = "productDataSource";
    @Value("${datasource.product.host}")
    private String host;
    @Value("${datasource.product.database}")
    private String database;
    @Value("${datasource.product.username}")
    private String username;
    @Value("${datasource.product.password}")
    private String password;

    @Bean(ENTITY_MANAGER)
    public LocalContainerEntityManagerFactoryBean getEntityManager() {
        String packageName = JPAProduct.class.getPackageName();
        return DataSourceConfig.buildLocalContainerEntityManagerFactoryBean(getDataSource(), List.of(packageName), ENTITY_MANAGER);
    }


    @Bean(TRANS_MANAGER)
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManager().getObject());
        return transactionManager;
    }

    @Bean(name = DATASOURCE)
    public DataSource getDataSource() {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setDb(database);
        dataSourceProperties.setHost(host);
        dataSourceProperties.setUsername(username);
        dataSourceProperties.setPassword(password);
        return DataSourceConfig.buildDataSource(dataSourceProperties, DATASOURCE);
    }
}
