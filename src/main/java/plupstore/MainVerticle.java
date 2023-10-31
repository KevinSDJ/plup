package plupstore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import plupstore.web.WebVerticle;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    vertx.deployVerticle(
      WebVerticle.class,
      new DeploymentOptions(),
      (AsyncResult<String> rs)->{
      if(rs.succeeded()){
        System.out.println("verticle deploy: "+ rs.result());
        startPromise.complete();
      }else{
        rs.cause().printStackTrace();
        startPromise.fail(rs.cause());
      }
    });
  }
}
