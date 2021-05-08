package net.bendi.dateandtime.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class LocaleConfig {

    Logger logger = LoggerFactory.getLogger(LocaleConfig.class);

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        logger.info("Locale is set to: " + Locale.getDefault().toString());
        logger.info("Timezone is set to: " + TimeZone.getDefault().getID());

    }
}
