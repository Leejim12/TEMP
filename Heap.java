package Submit;

import java.util.Scanner;

//class Element {
//	public int key = 0;
//	public Element() {
//	}
//	public Element(int key) {
//		this.key = key;
//	}
//}

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
		if (n+1 == MaxSize) {
			HeapFull();
			return x;
		}
		heap[n] = x;
		for (int i = n; i>= 2; i = i / 2) {

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
		if ((n-1) == 1) {
			HeapEmpty();
			n--;
			return heap[1];
		}
		else {

		rt = heap[1];
		heap[1] = heap[n-1];heap[n-1] = -1; // n-1 : 현재 최대 위치. 이걸 1에다가 넣음. n-2 : delete시 최대 인덱스 (n-1은 지워짐 : -1)
		if(n>=3) {
		for (int i = 1; i * 2 <= (n-2); i = i * 2) {
			if (heap[i] < heap[i * 2]) {
				swap(heap, i, i * 2);
			}
			if (heap[1] < heap[2]) {
				swap(heap, 1, 2);
			}
			if (heap[1] < heap[3]) {
				swap(heap, 1, 3);
			}
		}
//			if(heap[2]<heap[4]) {
//				swap(heap,2,4);
//			}
//			if(heap[2]<heap[5]) {
//				swap(heap,2,5);
//			}
//			if(heap[3]<heap[6]) {
//				swap(heap,3,6);
//			}
//			if(heap[3]<heap[7]) {
//				swap(heap,3,7);
//			}
//			if(heap[(n-2)/2]<heap[n-2]) {
//				swap(heap,(n-2)/2,n-2);
//			}
//			if(heap[(n-3)/2]<heap[n-3]) {
//				swap(heap,(n-3)/2,n-3);
//			}
		n--;
		}
		return rt;
		}
	
	
	
	
	
	}
	
//	    @Override 
//	    public int DeleteMax() { 
//	         int i, j; // i parent, j child 
//	 		int k = 0;
//	         if (n == 0) { 
//	            heapEmpty(); return; 
//	         } 
//	         if (n == 1) {        // 마지막 1개만 남았으면 포인터를 -해서 0으로 주고 리턴 
//	                 n--; 
//	                 return; 
//	         } 
//	         int temp = heap[1]; 
//	         heap[1] = heap[n]; 
//	         heap[n] = temp; n--; 
//	  
//	         for (i = 1, j = 2; j <= n; ) { 
//	             if (j < n && heap[j].compareTo(heap[j + 1]) < 0) j++; 
//	             // j points to the larger child 
//	             if (j <= n && heap[i].compareTo(heap[j]) < 0) { 
//	                 temp = heap[j]; 
//	                 heap[j] = heap[i]; 
//	                 heap[i] = temp; 
//	             } 
//	             i = j; j *= 2; 
//	         } 
//	     }
	
	
	
	public int SizeHeap() {
		return n-1;
	}
}
public class Heap {
//	private static Element data = new Element(0);
//
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
//				int deletedEle = k;
					System.out.println("deleted element: " + k);// + endl
				heap.display();
				break;
			case 5:
				// exit 구현
				break;
			}
		} while (select < 5);

//	return 0;
	
	}
}
