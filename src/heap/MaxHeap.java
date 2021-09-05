package heap;

public class MaxHeap {
	private int Heap[];
	private int size;
	@SuppressWarnings("unused")
	private int maxsize;

	public MaxHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[maxsize + 1];
		Heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swap(int fpos, int spos) {
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	private void maxHeapify(int pos) {
		if (isLeaf(pos)) {
			return;
		}
		if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	public void insert(int element) {
		Heap[++size] = element;
		int current = size;
		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.println("Parent : " + Heap[i] + " left child : " + Heap[2 * i] + " right child : " + Heap[2 * i + 1]);
		}
	}

	public int extractMax() {
		int popped = Heap[1];
		Heap[1] = Heap[size--];
		maxHeapify(1);
		return popped;
	}

	public static void main(String[] args) {
		MaxHeap h = new MaxHeap(15);

		h.insert(5);
		h.insert(3);
		h.insert(17);
		h.insert(10);
		h.insert(84);
		h.insert(19);
		h.insert(6);
		h.insert(22);
		h.insert(9);

		h.print();
		System.out.println(h.extractMax());
	}
}
