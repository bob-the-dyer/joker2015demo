
eb = $vertx.event_bus()

eb.consumer("topic.greetings") { |message|
  puts "junior recieves: #{message.body()}"
}