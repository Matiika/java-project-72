package hexlet.code.controller;

import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlsController {

    public static void create(Context ctx) throws SQLException {

            var name = ctx.formParamAsClass("url", String.class)
                    .check(value -> !value.isEmpty(), "Название не должно быть пустым")
                    .get();

            var product = new Url(name);
            UrlRepository.save(product);
            ctx.sessionAttribute("flash", "Товар был успешно создан!");
            ctx.sessionAttribute("flash-type", "success");
            ctx.redirect(NamedRoutes.rootPath());
    }

    public static void index(Context ctx) throws SQLException {
        var urls = UrlRepository.getEntities();
        var page = new UrlsPage(urls);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/urls.jte", model("page", page));
    }

}
