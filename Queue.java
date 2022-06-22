
/* Own Queue Class with generic type is created below. 
 * Queue works as last-in first-out (LIFO) datastructure .
 * Has several methods to ensure Queue-like behavior. 
 * Structure based on linked-list structure. 
 */
class Queue<T> {

	private T item;
	private Queue<T> next;

	/*
	 * Implemented two constructors. One constructor, if no parameters are
	 * passed in on initialization, and an other if at least a value is passed in.
	 */
	public Queue() {
		this.item = null;
		this.next = null;
	};

	public Queue(T item) {
		this.item = item;
		this.next = null;
	};

	/**
	 * Appends value to the end of the queue. Ensures LIFO behaviour
	 */
	public void addElement(final T valueToBeAdded) {

		/*
		 * * current "node" is null, means that the value can be added her
		 * * will be the case if object is initialized without a value passed in.
		 */
		if (this.item == null) {
			this.item = valueToBeAdded;
		}

		/*
		 * end of queue is reached. item will be added to the end.
		 */
		else if (this.next == null) {
			this.next = new Queue(valueToBeAdded);
		}

		/*
		 * * neither current item nor pointer are null. Thus, move on to the next
		 * item and check again.
		 */
		else {
			this.next.addElement(valueToBeAdded);
		}
		;
	};

	/**
	 * Removes the first element of the queue and returns it.
	 * First element is the element which was inserted earliest into the queue.
	 */
	public T removeFirstElement() {

		// If size of queue is one, it has to be set to null after removing first
		// element.
		if (this.getSize() == 1) {
			T tempItem = this.item;
			this.item = null;
			this.next = null;
			return tempItem;
		}

		else if (this.item.equals(null)) {
			return null;
		}

		// resetting pointers to remove the first element of the queue
		else {
			T tempItem = this.item;
			this.item = (T) this.next.item;
			this.next = this.next.next;
			return tempItem;
		}
	};

	/**
	 * just returns the first element without removing it.
	 */
	public T getFirstElement() {
		if (this.item.equals(null)) {
			return null;
		} else {
			return this.item;
		}
	};

	/**
	 * returns the amount of the queued items as integer.
	 */
	public int getSize() {

		if ((this.item == null) && (this.next == null)) {
			// empty queue
			return 0;
		}

		else if ((this.item != null) && (this.next == null)) {
			return 1;
		}

		else {
			// recursive-like function call to move on to the next item.
			return 1 + this.next.getSize();
		}
	};

	/**
	 * Checks whether the queue is empty or contains elements. Therefore, its
	 * enough to check whether the first element is 'null' or not.
	 */
	public boolean isEmpty() {
		if (this.item == null) {
			return true;
		}
		;
		return false;
	};

}
