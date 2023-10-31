package plupstore.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class WebVerticle extends AbstractVerticle {
    
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.createHttpServer().requestHandler(req -> {
            String data=null;
            try {
                data= new ObjectMapper().writeValueAsString(new Person("kevin", "De jesus"));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            req.response()
              .putHeader("content-type", "application/json")
              .end(data);
          })
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
