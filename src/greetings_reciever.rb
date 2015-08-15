eb = $vertx.event_bus()

eb.consumer("greetings") { |message|
  puts "#{message.body()}"
}