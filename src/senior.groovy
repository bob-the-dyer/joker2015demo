import io.vertx.core.json.JsonObject

def eb = vertx.eventBus()
i = 1;
vertx.setPeriodic(5000, { v ->
    def map = [
            "from"    : "Senior",
            "greeting": "Happy birthday!",
            "counter" : i++
    ]
    def json = new JsonObject(map)
    println "senior sending: " + json
    eb.publish("topic.greetings", json)
})
