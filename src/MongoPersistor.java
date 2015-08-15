import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;

public class MongoPersistor extends AbstractVerticle {

    MongoClient mongo;

    @Override
    public void start() throws Exception {
        mongo = MongoClient.createShared(vertx, new JsonObject().put("db_name", "joker2015demo"));
        vertx.eventBus().consumer("greetings", this::persistGreeting);
    }

    private void persistGreeting(Message<JsonObject> msg) {
        JsonObject greeting = msg.body();
        mongo.insert("greetings", greeting, res -> {
            if (res.succeeded()) {
                System.out.println(msg.body().getInteger("counter") + " persisted successfully");
            } else {
                System.out.println(res.cause().getMessage());
            }
        });
    }
}