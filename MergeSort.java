package Submit;

public class MergeSort {
	static int[] tmp;
//	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
//	static void merge(int[] a, int leftX, int rightX, int leftY, int rightY ) {

	// --- 병합 정렬 ---//
	static void MergeSort(int[] a, int left, int right) {
	if(left<right) {
		int x = (left + right)/2;
		MergeSort(a,left,x);
		MergeSort(a,x+1,right);
		merge(a, left, x, x+1, right);
	}
}

	
	   static void merge(int[] a, int leftX, int rightX, int leftY, int rightY) {
		      int i = leftX; 
		      int j = leftY; 
		      int index = leftX;

		      while (i <= rightX && j <= rightY) {

		         if (a[i] <= a[j]) { 
		        	 tmp[index++] = a[i++];

		         } else if (a[i] > a[j]) {
		        	 tmp[index++] = a[j++];

		         }
		      }

		      if (i > rightX) {
		         for (int k = j; k <= rightY; k++)
		            tmp[index++] = a[k];
		      }
		      else {
		         for (int k = i; k <= rightX; k++)
		            tmp[index++] = a[k];
		      }
		      
		      for (int l = leftX; l <= rightY; l++) {
		         a[l] = tmp[l];
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
		tmp = new int[nx];
		MergeSort(x, 0, nx - 1);

		System.out.println("[ Merge Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}

}
