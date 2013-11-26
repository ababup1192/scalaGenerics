//AdvancedQueue.scala

trait Queue[+T] {
	def head: T
	def tail: Queue[T]
	def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
	def apply[T](xs: T*): Queue[T] =
	new QueueImpl[T](xs.toList, Nil)
	private class QueueImpl[T](
		private val leading: List[T],
		private val trailing: List[T]
		) extends Queue[T] {
		def mirror = {
			if(leading.isEmpty)
			new QueueImpl(trailing.reverse, Nil)
			else
			this
		}
		def head: T = mirror.leading.head
		def tail: QueueImpl[T] = {
			val q = mirror
			new QueueImpl(q.leading.tail, q.trailing)
		}
		def enqueue[U >: T](x: U) = new QueueImpl[U](leading, x :: trailing)
		private def getQueue():List[T] ={
			val q = mirror
			q.leading ::: q.trailing.reverse
		}
		override def toString():String = s"Queue(${getQueue().mkString(", ")})"
	}
}

abstract class Fruit{
	val name:String
	val taste:String
}

case class Apple(name:String, taste:String) extends Fruit

case class Orange(name:String, taste:String) extends Fruit

object QueueTest{
	def main(args: Array[String]): Unit = {
		val q = Queue(Apple("fuji", "very good"), Apple("blue", "good"), Apple("red","bad"))
		println(q)
		println(q.head)
		println(q.tail)
		println(q.enqueue(Orange("Natsu","sweet")))
	}
}

