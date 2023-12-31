package plupstore.web;

import static plupstore.web.Controller.createRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class WebVerticle extends AbstractVerticle {
    
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.createHttpServer().requestHandler(createRouter(vertx))
          .listen(8080, http -> {
            if (http.succeeded()) {
              startPromise.complete();
              System.out.println("\n Server run in port: 8080\n");
            } else {
              startPromise.fail(http.cause());
            }
          });
    }
}
