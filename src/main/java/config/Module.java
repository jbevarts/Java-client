package config;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.io.IOException;

public class Module extends AbstractModule {

//    private final static Logger logger = Logger.get(Module.class);

//    @Override
//    protected void configure() {
//        try {
//            bindCommon();
//        } catch (Exception e) {
//            logger.error("*** Unable to load Module *** {}", CommonUtils.getExceptionAsString(e));
//        }
//    }
//
//    protected void bindCommon() {
//        bind(HttpTransport.class).toInstance(getTransport());
//
////        bind(CustomerProfileConnectorService.class).in(Scopes.SINGLETON);
////
////        bind(new TypeLiteral<IDataAccess<RestaurantReservationEntity, String>>() {
////        }).to(RestaurantDataAccess.class).in(Scopes.SINGLETON);
////
////        bind(ReservationTransformer.class).in(Scopes.SINGLETON);
////        bind(TokenValidator.class).in(Scopes.SINGLETON);
////
////        bind(String.class).annotatedWith(Names.named("databaseName"))
////                .toInstance(AppConfigs.get().getConfiguration("databaseName"));
//    }

//    private HttpTransport getTransport() {
//
//
//        HttpTransport transport = new HttpTransport() {
//            @Override
//            protected LowLevelHttpRequest buildRequest(String s, String s1) throws IOException {
//                return new LowLevelHttpRequest() {
//                    @Override
//                    public void addHeader(String s, String s1) throws IOException {
//
//                    }
//
//                    @Override
//                    public LowLevelHttpResponse execute() throws IOException {
//                        return null;
//                    }
//                };
//            }
//        };
//        transport.createRequestFactory();
//    }
}
