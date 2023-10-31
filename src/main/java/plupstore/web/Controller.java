package plupstore.web;

import java.util.HashMap;
import java.util.Map;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.common.template.TemplateEngine;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;

public class Controller {

    public static Router createRouter(Vertx context) {

        Router route = Router.router(context);
        TemplateEngine engine = ThymeleafTemplateEngine.create(context);
        route.route().handler(BodyHandler.create());
        route.get("/").handler(ctx -> {
            Map<String,Object> object=new HashMap<String,Object>();
            engine.render(object, "static/html/index.html")
            .onSuccess(buffer-> ctx.end(buffer))
            .onFailure(error -> {
                error.printStackTrace();
            } );

        });
        return route;
    }
}
