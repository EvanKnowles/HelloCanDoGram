package za.co.knonchalant.telegram.handlers.hello;

import za.co.knonchalant.candogram.IBotAPI;
import za.co.knonchalant.candogram.domain.PendingResponse;
import za.co.knonchalant.candogram.handlers.BaseMessageHandler;
import za.co.knonchalant.candogram.handlers.IUpdate;
import za.co.knonchalant.telegram.FileHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Basic handler that takes in a parameter, being how many dice to roll, and returns the results of the roll.
 * Created by evan on 2016/04/08.
 */
public class DiceHandler extends BaseMessageHandler {
    private static final String COMMAND = "dice";
    private static final Pattern DICE_PATTERN = Pattern.compile("^(\\d+)d(\\d+)$");
    private static final String EXPLANATORY_TEXT = "Input should be of a form similar to 3d6. Max 20 dice.";

    public DiceHandler(String botName, IBotAPI bot) {
        super(botName, COMMAND, bot);
    }

    @Override
    public PendingResponse handle(IUpdate update) {
        String text = update.getText();
        String keyword = getKeywords(text, COMMAND);

        Matcher matcher = DICE_PATTERN.matcher(keyword);
        if (matcher.find()) {
            try {
                long diceCount = Long.parseLong(matcher.group(1));

                if (diceCount > 20) {
                    sendMessage(update, "Too many dice. I'd be rolling all day.");
                    return null;
                }

                double diceSides = Double.parseDouble(matcher.group(2));

                StringBuilder diceResults = new StringBuilder("Dice: ");
                long total = 0;
                for (long i = 0; i < diceCount; i++) {
                    long value = (long) Math.ceil(Math.random() * (double)diceSides);
                    total += value;
                    diceResults.append(value).append(" ");
                }

                sendMessage(update, diceResults.toString());
                sendMessage(update, "Total: " + total);
            } catch (Exception ex) {
                // they could have overflowed the long, but let's not encourage such hooliganism by acknowledging it
                sendMessage(update, EXPLANATORY_TEXT);
            }
        } else {
            sendMessage(update, EXPLANATORY_TEXT);
        }

        // we're not expecting any response messages, so return null
        return null;
    }
}
