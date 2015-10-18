package chapter_2.exercises

object Ex3 extends App with ThreadsApp {

  class SyncVar[T] {
    var theVal: Option[T] = None
    var isEmpty: Boolean = true

    def get(): T = this.synchronized {
      theVal match {
        case Some(x) => {
          isEmpty = true
          theVal = None
          x
        }
        case None => throw new Exception
      }
    }

    def put(x: T): Unit = this.synchronized {
      theVal match {
        case None => {
          theVal = Some(x)
          isEmpty = false
        }
        case Some(_) => throw new Exception
      }
    }
  }

}
