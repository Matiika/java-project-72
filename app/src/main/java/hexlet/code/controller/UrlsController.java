package hexlet.code.controller;

import hexlet.code.dto.BasePage;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlsController {

    public static void build(Context ctx) {
        var page = new BasePage();
        ctx.render("urls/index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        try {
            var name = ctx.formParamAsClass("url", String.class)
                    .check(value -> !value.isEmpty(), "Название не должно быть пустым")
                    .get();
            var product = new Url(name);
            UrlRepository.save(product);
            ctx.sessionAttribute("flash", "Товар был успешно создан!");
            ctx.sessionAttribute("flash-type", "success");
            System.out.println("Flash message set: " + ctx.sessionAttribute("flash"));
            ctx.redirect(NamedRoutes.urlsPath());
        } catch (ValidationException e) {
            var name = ctx.formParamAsClass("name", String.class).getOrDefault("");
            var page = new UrlPage(name, e.getErrors());
            ctx.render("urls/index.jte", model("page", page)).status(422);
        }
    }

    public static void index(Context ctx) throws SQLException {
        var urls = UrlRepository.getEntities();
        var page = new UrlsPage(urls);
        String flash = ctx.consumeSessionAttribute("flash");
        String flashType = ctx.consumeSessionAttribute("flash-type");
        System.out.println("Flash message consumed in index: " + flash);
        page.setFlash(flash);
        page.setFlashType(flashType);
        ctx.render("urls/urls.jte", model("page", page));
    }


}
