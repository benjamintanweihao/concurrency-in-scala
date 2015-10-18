package chapter_2.exercises

object Ex1 extends ThreadsApp with App {

  def parallel[A, B](a: =>A, b: => B): (A, B) = {
    var aVar: A = null.asInstanceOf[A]
    var bVar: B = null.asInstanceOf[B]

    val t1 = thread { aVar = a }
    val t2 = thread { bVar = b }

    t1.join()
    t2.join()

    (aVar, bVar)
  }

  log(s"${parallel(2+3, 10+9)}")

}
