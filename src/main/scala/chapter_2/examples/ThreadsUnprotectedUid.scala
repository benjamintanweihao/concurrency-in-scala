package chapter_2.examples

object ThreadsUnprotectedUid extends App with ThreadsApp {
  var uidCount = 0L

  def getUniqueId() = {
    var freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }

  def printUniqueIds(n: Int): Unit = {
    var uids = for (i <- 0 until n) yield getUniqueId()
    log(s"Generated uids: $uids")
  }

  var t1 = thread { printUniqueIds(5) }
  var t2 = thread { printUniqueIds(5) }
  var t3 = thread { printUniqueIds(5) }
  printUniqueIds(5)
  t1.join()
  t2.join()
  t3.join()
}
