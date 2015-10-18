package chapter_2.examples

object SynchonizedGuardedBlocks extends App with ThreadsApp {
  val lock = new AnyRef
  var message: Option[String] = None
  var greeter = thread {
    lock.synchronized {
      while (message == None) {
        log("waiting ...")
        lock.wait()
      }

      log(message.get)
    }
  }

  lock.synchronized {
    log("setting message")
    message = Some("Hello")
    lock.notify()
  }

  greeter.join
}
