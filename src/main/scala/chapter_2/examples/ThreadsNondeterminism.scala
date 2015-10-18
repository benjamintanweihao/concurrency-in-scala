package chapter_2.examples

object ThreadsNondeterminism extends App with ThreadsApp {
  val t = thread { log("New thread running.") }
  log("...")
  log("...")
  t.join()
  log("New thread joined.")
}
