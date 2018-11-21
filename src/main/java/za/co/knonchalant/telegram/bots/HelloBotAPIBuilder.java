package za.co.knonchalant.telegram.bots;

import za.co.knonchalant.candogram.Bots;
import za.co.knonchalant.candogram.IBotAPI;
import za.co.knonchalant.candogram.TelegramBotAPI;
import za.co.knonchalant.candogram.handlers.IMessageHandler;
import za.co.knonchalant.telegram.handlers.hello.DiceHandler;
import za.co.knonchalant.telegram.handlers.hello.HelloHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is not strictly necessary, but to clean up the code (especially if you're going to be hosting more
 * than one bot), it can be neater to have a small builder for each bot.
 *
 * This builder takes in a parameter specifying if we're running in test mode or not, then instantiates a bot with the
 * appropriate parameters - a Telegram bot in this case, because that's all we have at the moment.
 */
public class HelloBotAPIBuilder {
    private static final String NAME = "HelloCanDo";
    private static final String TEST_OPS_BOT = "<some test bot ID>";
    private static final String TEST_OPS_NAME = "HelloCanDoBot";
    private static final String OPS_BOT = "<some prod bot ID>";
    private static final String OPS_NAME = "ProddenBottenName";

    private List<IMessageHandler> handlers;

    /**
     * Setup the bot
     * @param test are we in test mode or not
     * @return the instantiated CanDoGram bot
     */
    public Bots buildHelloBot(boolean test) {
        handlers = new ArrayList<>();
        IBotAPI botAPI;
        if (!test) {
            botAPI = new TelegramBotAPI(NAME, OPS_BOT);
        } else {
            botAPI = new TelegramBotAPI(NAME, TEST_OPS_BOT);
        }
        String botName = test ? TEST_OPS_NAME : OPS_NAME;

        // handlers are conveniently easily interchangeable between bots
        addHandler(new HelloHandler(botName, botAPI));
        addHandler(new DiceHandler(botName, botAPI));

        return new Bots(NAME, Collections.singletonList(botAPI), handlers);
    }

    private void addHandler(IMessageHandler searchHandler) {
        this.handlers.add(searchHandler);
    }
}
