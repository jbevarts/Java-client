package connector;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import dao.CatsDao;
import feign.Feign;
import feign.FeignErrorDecoder;
import feign.Logger;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import lombok.extern.log4j.Log4j2;
import models.Facts;
import util.CommonUtil;

import java.util.Timer;
import java.util.TimerTask;

@Log4j2
public class CatsConnectorImpl implements CatsHttpConnector {
    private final CatsDao dao;


    @Inject
    CatsConnectorImpl(@Named("catsUrl") final String url) {
        dao = Feign.builder().logLevel(Logger.Level.FULL).encoder(new FormEncoder()).decoder(new GsonDecoder()).errorDecoder(new FeignErrorDecoder()).target(CatsDao.class, url);
        //new Timer().scheduleAtFixedRate(new TimedStuff(), 0, 3000000);
    }

    @Override
    public Facts[] fetchCatFacts(String catType, int qty) {
        System.out.println(CommonUtil.beautifyJson(dao.fetchCatFacts(catType, qty)));
        return CommonUtil.convertValue(dao.fetchCatFacts(catType, qty), Facts[].class);
    }

    /**
     * Timer task
     *
     */
    public class TimedStuff extends TimerTask {
        @Override
        public void run() {
            // periodic task
        }
    }


}
