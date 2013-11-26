//SlowAppendQueue.scala
class SlowAppendQueue[T](elems :List[T]){
	def head = elems.head
	def tail = new SlowAppendQueue(elems.tail)
	def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
	override def toString():String = s"SlowAppendQueue(${elems.mkString(", ")})"
}

object QueueTest{
	def main(args: Array[String]): Unit = {
  		val q:SlowAppendQueue[Int] = new SlowAppendQueue(List(1,2,3,4,5,6,7,8,9))
  		println(q.head)
  		println(q.tail)
  		val q2 = q enqueue 10
  		println(q2)
	}
}