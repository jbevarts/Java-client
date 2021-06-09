package config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

public class InjectionContext {
    private static InjectionContext context;

    public static synchronized InjectionContext get() {
        if (context == null) {
            context = new InjectionContext(Guice.createInjector(new Module()));
        }
        return context;
    }

    private static Injector injector;

    private InjectionContext(Injector inputInjector) {
        injector = inputInjector;
    }

    public static InjectionContext override(Injector inputInjector) {
        context = new InjectionContext(inputInjector);
        return context;
    }

    public <T> T instanceOf(Class<T> clazz) {
        return injector.getInstance(clazz);
    }

//    public static <T> T instanceOf(Class<T> clazz, String beanName) {
//        final Key<T> nameKey = Key.get(clazz, Names.named(beanName));
//        final Binding<T> binding = injector.getExistingBinding(nameKey);
//        if( binding != null ) {
//            return binding.getProvider().get();
//        }
//        return null;
//    }
}
