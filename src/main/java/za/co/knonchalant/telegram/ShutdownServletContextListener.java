package za.co.knonchalant.telegram;

import za.co.knonchalant.candogram.IBot;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * We need this to make sure the bot shuts down when the server shuts down and doesn't keep the server awake while it
 * eternally loops looking for commands.
 */
@WebListener
public class ShutdownServletContextListener implements ServletContextListener {

    @EJB
    IBot iBot;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        iBot.shutdown();
    }
}
