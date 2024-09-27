package hexlet.code.util;

import java.net.URI;
import java.net.URISyntaxException;

public class Domain {
    public static String getDomain(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getScheme() + "://" + uri.getHost();
        int port = uri.getPort();
        if (port != -1) {
            domain += ":" + port;
        }
        return domain;
    }
}
