package Submit;


public class HeapSort_Pra {
	
	static void swap(int[] a,int idx1,int idx2) {
		int t = a[idx1]; a[idx1]=a[idx2];a[idx2]=t;
	}
	
	static void makeHeap(int[] a, int left, int right) {
		int temp = a[left];int child;int parent;
		
		for (parent = left; parent<(right+1)/2;parent = child) {
			int cl = parent * 2 + 1; int cr = cl + 1;
			child = (cr<=right && a[cr]>a[cl])?cr:cl;
			if (temp >= a[child]) break;
			a[parent] = a[child];
		}
		a[parent] = temp;
	}
	
	static void HeapSort(int[] a,int n) {
		for(int i = (n-1)/2;i>=0;i--) makeHeap(a,i,n-1);
		for(int i = n-1;i>0;i--) {
			swap(a,0,i);makeHeap(a,0,i-1);
		}
	}
	
	
	
	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20];
		System.out.print("[정렬 전]");
		
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();
		System.out.println();
		HeapSort(x,nx); // 배열 x를 MergeSort

		System.out.println("[ Heap Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
