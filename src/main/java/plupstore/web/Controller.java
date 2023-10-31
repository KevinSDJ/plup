package plupstore.web;

import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.common.template.TemplateEngine;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;

public class Controller {
    private static String html = "text/html";

    public static Router createRouter(Vertx context) {

        Router route = Router.router(context);
        TemplateEngine engine = ThymeleafTemplateEngine.create(context);
        route.route().handler(BodyHandler.create());
        route.get("/").handler(ctx -> {
            ctx.response().putHeader("Content-Type", "text/plain");
            ctx.response().end("html");

        });
        return route;
    }
}
