data class Node<T>(var value: T, var next: Node<T>? = null)

class MyLinkedList<T> {
    private var head: Node<T>? = null

    fun add(value: T) {
        val newNode = Node(value)

        if(head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }
    fun printList() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
}

fun main() {
    val list = MyLinkedList<Int>()
    list.add(20)
    list.add(30)
    list.add(40)

    list.printList()
}