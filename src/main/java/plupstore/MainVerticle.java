package plupstore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import plupstore.web.WebVerticle;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(){

    vertx.deployVerticle(new WebVerticle(),new DeploymentOptions().setWorker(true));
  }
}
