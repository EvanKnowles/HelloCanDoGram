package za.co.knonchalant.telegram;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Basic stream to pull from a URL and return the bytes of it.
 */
public class FileHandler {
    public static byte[] fetchRemoteFile(String location)  {
        URL url = null;
        try {
            url = new URL(location.replaceAll(" ", "%20"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new byte[0];
        }

        byte[] bytes = null;
        try(InputStream is = url.openStream ()) {
            bytes = IOUtils.toByteArray(is);
        } catch (IOException e) {
            //handle errors in a real bot
            e.printStackTrace();
        }

        return bytes;
    }

}
