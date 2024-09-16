package hexlet.code.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String urlsPath() {
        return "/urls";
    }

    public static String productPath(Long id) {
        return productPath(String.valueOf(id));
    }

    public static String productPath(String id) {
        return "/products/" + id;
    }
}
