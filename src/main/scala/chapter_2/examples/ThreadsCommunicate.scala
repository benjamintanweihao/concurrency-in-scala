package chapter_2.examples

object ThreadsCommunicate extends App with ThreadsApp {
  var result: String = null
  var t = thread { result = "\nTitle\n" + "=" * 5 }

  t.join()
  log(result)
}
