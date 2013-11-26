//QueueBase.scala
class Queue[T](
	private val leading: List[T],
	private val trailing: List[T]
){
	private def mirror():Queue[T] = {
		if (leading.isEmpty) new Queue(trailing.reverse, Nil)
		else this
	}
	private def getQueue():List[T] ={
	 val q = mirror
	 q.leading ::: q.trailing.reverse
	}
	override def toString():String = s"Queue(${getQueue().mkString(", ")})"
	def head = mirror.leading.head
	def tail = {
		val q = mirror
		new Queue(q.leading.tail, q.trailing)
	}
	def enqueue(x: T) = new Queue(leading, x:: trailing)
}

object QueueTest{
	def main(args: Array[String]): Unit = {
		val q = new Queue(List(1,2,3,4,5,6,7,8,9),Nil)
		println(q.head)
		println(q.tail)
		val q2 = q enqueue 10
		println(q2)
	}
}