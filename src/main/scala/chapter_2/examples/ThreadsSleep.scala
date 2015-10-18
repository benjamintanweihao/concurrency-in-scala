package chapter_2.examples

object ThreadsSleep extends App with ThreadsApp {

  val t = thread {
    Thread.sleep(1000)
    log("New thread running")
    Thread.sleep(1000)
    log("Still running")
    Thread.sleep(1000)
    log("Completed")
  }

  t.join()
  log("New thread joined")
}
