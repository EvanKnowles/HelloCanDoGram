package za.co.knonchalant.telegram.handlers.hello;

import za.co.knonchalant.candogram.IBotAPI;
import za.co.knonchalant.candogram.domain.PendingResponse;
import za.co.knonchalant.candogram.handlers.BaseMessageHandler;
import za.co.knonchalant.candogram.handlers.IUpdate;
import za.co.knonchalant.telegram.FileHandler;

/**
 * The HelloHandler greets the user nicely, then sends them a picture of a cat for their troubles. So that's nice.
 * Created by evan on 2016/04/08.
 */
public class HelloHandler extends BaseMessageHandler {

    public HelloHandler(String botName, IBotAPI bot) {
        super(botName, "hello", bot, true);
    }

    @Override
    public PendingResponse handle(IUpdate update) {
        typing(update);

        sendMessage(update, "Hello, " + update.getUser().getUserName() + " - have a cat!");

        getBot().sendPhoto(String.valueOf(update.getChatId()), FileHandler.fetchRemoteFile("https://cataas.com/cat"));

        // we're not expecting any response messages, so return null
        return null;
    }
}
