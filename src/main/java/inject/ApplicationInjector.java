package inject;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import connector.CatsHttpConnector;
import connector.CatsConnectorImpl;
import lombok.extern.log4j.Log4j2;
import service.ClientService;
import service.ClientServiceImpl;

import java.io.IOException;
import java.util.Properties;

/***
 * Guice Injector Class for loading configuration properties and binding
 * services to implementations.
 *
 */
@Log4j2
public class ApplicationInjector extends AbstractModule {

    /**
     * Configures the Guice Bindings.
     */
    @Override
    protected void configure() {
        Names.bindProperties(binder(), loadProperties());
        bind(CatsHttpConnector.class).to(CatsConnectorImpl.class).in(Scopes.SINGLETON);
        bind(ClientService.class).to(ClientServiceImpl.class).in(Scopes.SINGLETON);

    }

    /***
     * Loads the Environment specific properties file.
     * 
     * @return Properties Properties Object
     */
    private Properties loadProperties() {
        final Properties props = new Properties();

        try {
            props.load(ApplicationInjector.class.getResourceAsStream("/application-common.properties"));
        } catch (IOException e) {
            log.info("Could not load applicaton properties configuration: {}", e);
        }

        return props;

    }

}
