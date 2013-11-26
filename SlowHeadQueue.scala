//SlowHeadQueue.scala
class SlowHeadQueue[T](smele :List[T]){
	// smeleはelemsの逆
	def head = smele.last
	def tail = new SlowHeadQueue(smele.init)
	def enqueue(x: T) = new SlowHeadQueue(x :: smele)
	override def toString():String = s"SlowHeadQueue(${smele.mkString(", ")})"
}

object QueueTest{
	def main(args: Array[String]): Unit = {
  		val q:SlowHeadQueue[Int] = new SlowHeadQueue(List(4,3,2,1))
  		println(q.head)
  		println(q.tail)
  		val q2 = q enqueue 5
  		println(q2)
	}
}