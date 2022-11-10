package Submit;

import java.util.Scanner;

interface MaxPQ {
	public int Insert(int x);

	public int DeleteMax();
}

class MaxHeap implements MaxPQ {
	public int[] heap;
	public int n; // current size of HeapSortPP
	public int MaxSize; // Maximum allowable size of HeapSortPP

	public MaxHeap(int sz)// = HeapSize
	{
		MaxSize = sz;
		this.n = 1;
		heap = new int[MaxSize + 1]; // Don't want to use heap[0]
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	void HeapEmpty() {
//		System.out.println("Heap Empty" + "\n");
	}

	void HeapFull() {
		System.out.println("Heap Full");
	}

	void display() {
		System.out.println("HeapSortPP:: (i, heap[i]): ");
		for (int i = 1; i <= n-1; i++)
			System.out.println("(" + i + ", " + heap[i] + ") ");
		System.out.println("\n");
	}

	@Override
	public int Insert(int x) {
//		int rt;
		if (n == MaxSize) {
			HeapFull();
			return x;
		}
		heap[n] = x;
		
		for (int i = n; i>= 1; i = i / 2) {			
			if (heap[i] > (heap[i/2])) {
				swap(heap, i, i / 2);
			}
		}
		n++;
		return x;
	}

	@Override
	public int DeleteMax() {
		int rt = 0;
		if (n <= 2) { // Heap에 하나도 안들어갔을때의 n -> 1.
			n--;
			return heap[1];
		}
		else {

		rt = heap[1];
		heap[1] = heap[n-1];heap[n-1] = -1; // n-1 : 현재 최대 위치. 이걸 1에다가 넣음. n-2 : delete시 최대 인덱스 (n-1은 지워짐 : -1)
		if(n>=3) {

			for(int i = 1,j=2;j<=n;) {
				if(j<n && heap[j]<heap[j+1])j++;
				if(j<=n&&heap[i]<heap[j]) {
					swap(heap,i,j);
				}
				i=j;j=j*2;
			}
		n--;
		}
		return rt;
		}
	}
	
	public int SizeHeap() {
		return n-1;
	}
}
public class Heap {

	private static MaxHeap heap = new MaxHeap(30);
	public static void main(String[] args) {

		int select = 0;
		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 delete, >=5 exit");
			Scanner sc = new Scanner(System.in);
			select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("input value: ");
				int x = sc.nextInt();
				heap.Insert(x);
				heap.display();
				break;
			case 2:
				heap.display();
				break;
			case 3:
				int k = heap.DeleteMax();

					System.out.println("deleted element: " + k);
				heap.display();
				break;
			case 5:
				break;
			}
		} while (select < 5);
	}
}
