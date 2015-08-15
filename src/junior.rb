
eb = $vertx.event_bus()

eb.consumer("topic.greetings") { |message|
  puts "junior recieved: #{message.body()}"
}