package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlChecksRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import java.net.URI;
import java.net.URL;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static hexlet.code.util.Domain.getDomain;
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

            ctx.sessionAttribute("flash", "Страница успешно добавлена");
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
        var urlChecks = UrlChecksRepository.getLatestUrlChecksBySQL();
        var page = new UrlsPage(urls, urlChecks);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/urls.jte", model("page", page));
    }

//    public static void show(Context ctx) throws SQLException {
//        var id = ctx.pathParamAsClass("id", Long.class).get();
//        var product = UrlRepository.find(id)
//                .orElseThrow(() -> new NotFoundResponse("Сайт не найден"));
//        var page = new UrlPage(product);
//        ctx.render("urls/url.jte", model("page", page));
//    }



}