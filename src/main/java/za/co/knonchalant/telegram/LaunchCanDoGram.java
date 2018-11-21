package za.co.knonchalant.telegram;

import za.co.knonchalant.ServerConfig;
import za.co.knonchalant.candogram.IBot;
import za.co.knonchalant.telegram.bots.HelloBotAPIBuilder;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Collections;
import java.util.logging.Logger;

/**
 * This is the primary class that is launched at server site and instantiates the bot.
 */
@Startup
@Singleton
public class LaunchCanDoGram {
    private static final Logger LOGGER = Logger.getLogger(LaunchCanDoGram.class.getName());

    @EJB
    IBot bot;

    @PostConstruct
    public void start() {
        LOGGER.info("Launching bot...");

        boolean testMode = ServerConfig.isTest();

        HelloBotAPIBuilder helloBotAPIBuilder = new HelloBotAPIBuilder();
        bot.start(Collections.singletonList(helloBotAPIBuilder.buildHelloBot(testMode)));

        LOGGER.info("Bot launched.");
    }

}
