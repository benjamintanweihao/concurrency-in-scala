package chapter_2.examples

object ThreadsMain extends App with ThreadsApp {

  val t = thread { log("New thread running") }
  t.join()
  val name = t.getName
  println(s"${Thread.currentThread().getName}: New thread joined")

}
