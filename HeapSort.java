package Submit;


public class HeapSort {
	
	static void swap(int[] a,int idx1,int idx2) {
		int t = a[idx1]; a[idx1]=a[idx2];a[idx2]=t;
	}
	
	static void HeapSort(int[] a) {

		MaxHeap HP = new MaxHeap(a.length+2);
		for(int i=0;i<a.length;i++) {
		HP.Insert(a[i]);
		}
		for(int i=a.length-1;i>=0;i--) {
			a[i]=HP.DeleteMax();
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
		HeapSort(x); // 배열 x를 MergeSort

		System.out.println("[ Heap Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
