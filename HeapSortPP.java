package Submit;

import java.util.Scanner;

class Element {
	public int key = 0;

	public Element() {
	}

	public Element(int key) {
		this.key = key;
	}
}

interface MaxPQ {

	public Element Insert(Element x);

	public Element DeleteMax(Element x);
}

class MaxHeap implements MaxPQ {
	public Element[] heap;
	public int n; // current size of HeapSortPP
	public int MaxSize; // Maximum allowable size of HeapSortPP	
	public MaxHeap(int sz)// = HeapSize
	{
		MaxSize = sz;
		this.n = 0;
		heap = new Element[MaxSize + 1]; // Don't want to use heap[0]
	}



	void HeapEmpty() {
		System.out.println("Heap Empty" + "\n");
	}

	void HeapFull() {
		System.out.println("Heap Full");
	}

	void display() {
		int i;
		System.out.println("HeapSortPP:: (i, heap[i].key): ");
		for (i = 1; i <= n; i++)
			System.out.println("(" + i + ", " + heap[i].key + ") ");
		System.out.println("\n");
	}

	@Override
	public Element Insert(Element x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return x;
		}
		n++;
		for (i = n; i >= 1; i++) {
			if (i == 1)
				break; // at root
			if (x.key <= heap[i / 2].key)
				break;
			// move from parent to i
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = x;
		return x;
	}

	@Override
	public Element DeleteMax(Element x) {
		int i, j;
		if (x.key != n) {
			HeapEmpty();
			x.key = 0;
			return x;
		}
		x = heap[1];
		Element k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if (heap[j].key < heap[j + 1].key)
					j++;
			// j points to the larger child
			if (k.key >= heap[j].key)
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;

	}
}

public class HeapSortPP {
	private static Element data = new Element(0);

	public static void main(String[] args) {
		int select = 0;

		data.key = 0;

//	MaxHeap heap = new MaxHeap[20];
//	heap = MaxHeap(20);
//	A = MaxHeap(20);
		MaxHeap A = new MaxHeap(20);
		Element[] heap = A.heap;

		Element ele = null;

		Element deletedEle = null;

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 delete, >=5 exit");
			Scanner sc = new Scanner(System.in);
			int select1 = sc.nextInt();
			switch (select1) {
			case 1:
				System.out.println("input value: ");
				select1 = sc.nextInt();
				A.Insert(data);
				A.display();
				break;
			case 2:
				A.display();
				break;
			case 3:

				deletedEle = A.n;
				A.DeleteMax(ele);
				if (deletedEle != null) {
					System.out.println("deleted element: " + deletedEle + "->key");// + endl
				}
				System.out.println("current max heap: ");// +endl
				A.display();
				break;
			case 5:
				// exit 구현
				break;

			}
		} while (select < 5);

//	return 0;
	}
}
