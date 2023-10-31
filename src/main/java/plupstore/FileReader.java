package plupstore;

import io.vertx.core.AsyncResult;
import io.vertx.core.Vertx;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.FileSystem;
import io.vertx.core.file.OpenOptions;

public class FileReader {
    private Vertx vertx;

    public FileReader(Vertx vertx){
        this.vertx=vertx;
    }

    void reader(String path,String filename,String ext){
        String file= new StringBuilder(filename).append(ext).toString();
        
        FileSystem fs= vertx.fileSystem();

        fs.open("./".concat(file),
        new OpenOptions().setWrite(false).setCreate(false),
        (AsyncResult<AsyncFile> result)->{
            if(result.succeeded()){
                result.result().setReadBufferSize(1000)
                .handler(data-> System.out.println((data.toString())))
                .endHandler(System.out::println);
            }else{
                result.cause().printStackTrace();
            }
        });
    }
}
