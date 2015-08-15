import io.vertx.core.json.JsonObject

def eb = vertx.eventBus()
i = 1;
vertx.setPeriodic(2000, { v ->
    def map = [
            "from"    : "Joker 2015",
            "greeting": "Happy birthday!",
            "counter" : i++
    ]
    def json = new JsonObject(map)
    eb.publish("greetings", json)
})
