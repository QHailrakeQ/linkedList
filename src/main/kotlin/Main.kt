data class Node<T>(var value: T, var next: Node<T>? = null)

class MyLinkedList<T> {
    private var head: Node<T>? = null
    private var size = 0

    fun addLast(value: T) {
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
        size++
    }

    fun addFirst(value: T) {
        val newNode = Node(value, head)
        head = newNode
        size++
    }

    fun addAt(value: T, index: Int) {
        if (index < 0 || index > size)
            throw IndexOutOfBoundsException()
        if (index == 0) {
            addFirst(value)
            return
        }
        val newNode = Node(value)
        var current = head
        for (i in 0 until index - 1) {
            current = current?.next
        }
        newNode.next = current?.next
        current?.next = newNode
        size++
    }

    fun removeFirst() {
        if (head != null) {
            head = head?.next
            size--
        }
    }

    fun removeLast() {
        if (head == null) return
        if (head?.next == null) {
            head = null
        } else {
            var current = head
            while (current?.next?.next != null) {
                current = current.next
                }
            current?.next = null
        }
        size--
    }

    fun removeValue(value: T) {
        if (head == null) return
        if (head?.value == value) {
            removeFirst()
            return
        }
        var current = head
        while (current?.next != null) {
            if (current.next?.value == value) {
                current.next = current.next?.next
                size--
                return
            }
            current = current.next
        }
    }

    fun contains(value: T): Boolean {
        var current = head
        while (current != null) {
            if (current.value == value) return true
            current = current.next
        }
        return false
    }

    fun printList() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
    fun getSize(): Int = size
}

fun main() {
    val list = MyLinkedList<Int>()
    list.addLast(20)
    list.addLast(30)
    list.addLast(40)
    list.addFirst(10)
    list.addAt(15, 1)

    list.printList()

    list.removeValue(15)

    list.printList()

    println("Is 15 in the list? ${list.contains(15)}")
    println("List size. ${list.getSize()}")

    list.removeFirst()
    list.removeLast()

    list.printList()
}