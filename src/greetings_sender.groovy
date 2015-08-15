def eb = vertx.eventBus()
i = 1;
vertx.setPeriodic(2000, { v ->
    eb.publish("greetings", "Happy birthday from Joker 2015! (" + i ++ + ")")
})
