package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.net.URI;
import java.net.URL;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlsController {

    public static void build(Context ctx) {
        var page = new BasePage();
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        try {
            var name = ctx.formParamAsClass("url", String.class).get();
            URI uri = new URI(getDomain(name));

            if (!uri.isAbsolute()) {
                throw new URISyntaxException(name, "URI is not absolute");
            }

            URL url = uri.toURL();

            if (UrlRepository.entityExistsByName(url.toString())) {
                throw new SQLException();
            }

            UrlRepository.save(new Url(url.toString()));

            ctx.sessionAttribute("flash", "Товар был успешно создан!");
            ctx.sessionAttribute("flash-type", "success");
            ctx.redirect(NamedRoutes.urlsPath());
        } catch (URISyntaxException | MalformedURLException e) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("flash-type", "danger");
            ctx.redirect(NamedRoutes.rootPath());
        } catch (SQLException e) {
            ctx.sessionAttribute("flash", "Страница уже существует");
            ctx.sessionAttribute("flash-type", "danger");
            ctx.redirect(NamedRoutes.urlsPath());
        }
    }

    public static void index(Context ctx) throws SQLException {
        var urls = UrlRepository.getEntities();
        var page = new UrlsPage(urls);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/urls.jte", model("page", page));
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var product = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Сайт не найден"));
        var page = new UrlPage(product);
        ctx.render("urls/url.jte", model("page", page));
    }


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
