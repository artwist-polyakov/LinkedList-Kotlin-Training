fun main() {
    class Element<T>(var value: T, var prev: Element<T>? = null, var next: Element<T>? = null) {
    }

    class LinkedList<T>(
        private var head: Element<T>? = null,
        private var tail: Element<T>? = null,
        private var size: Int = 0
    ) {
        fun isEmpty(): Boolean {
            return size == 0
        }

        fun size(): Int {
            return size
        }

        fun add(value: T) {
            if (!isEmpty()) {
                if (tail != null) { // если у массива уже есть хвост
                    tail?.next = Element<T>(value = value, prev = tail) // ставим в next последнего элемента массива ссылку на новый член
                    size++
                    tail = tail?.next /* заменяем хвост нашего массива ссыкой на действительно последний элемент */
                } else {
                    size++
                    tail = Element<T>(value = value, prev=head)
                    head?.next  = tail
                }
            } else { // Добавление в пустой массив
                size++
                head = Element(value = value) //next и prev указывают на null
            }
        }

        override fun toString(): String {
            if (!isEmpty()) {
                var returnedString: String = ""
                var current = head
                do {
                    if (current == head) {
                        returnedString += current?.value.toString()
                    } else {
                        returnedString += " ${current?.value.toString()}"
                    }
                    current = current?.next
                } while (current != null)
                return returnedString
            } else {
                return "Пустой массив"
            }
        }
    }

    var test = LinkedList<Int>()
    test.add(1)
    test.add(2)
    test.add(3)
    print(test)
}