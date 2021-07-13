    class Node {

        public int value;
        public Node nextNode;

        public Node(int value) {
            value = value;
            nextNode = null;
        }
    }

    class MyCircularQueue {

        private Node head, tail;
        private int count;
        private int capacity;

        public MyCircularQueue(int k) 
		{
            capacity = k;
        }

        public boolean enQueue(int value) 
		{
            if (count == this.capacity) {
                return false;
            }

            Node newNode = new Node(value);
            if (count == 0) 
			{
                head = tail = newNode;
            } 
			else 
			{
                tail.nextNode = newNode;
                tail = newNode;
            }

            count += 1;
            return true;
        }

        public boolean deQueue() {
            if (count == 0) 
			{
                return false;
            }

            Node temp = head.nextNode;
            head.nextNode = null;
            head = temp;
            count -= 1;
            return true;
        }

        public int Front() 
		{
            return (count == 0) ? -1 : head.value;
        }

        public int Rear() 
		{
            return (count == 0) ? -1 : tail.value;

        }

        public boolean isEmpty() 
		{
            return (count == 0);
        }

        public boolean isFull() 
		 {
            return (count == capacity);
        }
    }