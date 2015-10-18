package chapter_2.exercises

import java.util.Calendar


object Ex2 extends App with ThreadsApp {

  def periodically(duration: Long, b: () => Unit): Unit = {
    val worker = new Thread {
      while(true) {
        b()
        Thread.sleep(duration)
      }
    }

    worker.setName("Worker")
    worker.setDaemon(true)
    worker.start()
  }

  periodically(2000, () => log(s"${Calendar.getInstance().getTime}"))

}
