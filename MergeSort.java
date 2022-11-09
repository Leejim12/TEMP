package Submit;

public class MergeSort {
	static int[] tmp;
//	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
//	static void merge(int[] a, int leftX, int rightX, int leftY, int rightY ) {


	// --- 병합 정렬 ---//
	static void MergeSort(int[] a, int left, int right) {
//		int[] tmp = new int[a.length];
	if(left<right) {
		int x = (left + right)/2;
		MergeSort(a,left,x);
		MergeSort(a,x+1,right);
		merge(a, left, x, x+1, right);
	}
}
	
//	static void merge(int [] a,int leftX,int rightX,int leftY,int rightY) {
//		int p = leftX; int q = rightX; int index = leftX;
////		int[] tmp = new int[a.length];
//		
//        while (p <= rightX && q <= rightY) {
//            if (a[p]<=a[q]) {
//            	tmp[index++] = a[p++];
//            } else if(a[p]>a[q]) {
//                tmp[index++] = a[q++];
//            }
//        }
//        // 남은거 다 넣기
//        if(p>rightX){
//        	for(int i = q;i<rightY;i++) {
//        		tmp[index++]=a[i];
//        	}
//        }
//        else {
//        	for(int i = p;i<rightX;i++) {
//        		tmp[index++]=a[i];
//        	}
//        }
//        
//        //
//        for(int j = leftX;j<=rightY;j++) {
//        	a[j]=tmp[j];
//        }
//	}
	
	   static void merge(int[] a, int leftX, int rightX, int leftY, int rightY) {
		      int i = leftX; // a의 인덱스
		      int j = leftY; // b의 인덱스
		      int index = leftX;

		      while (i <= rightX && j <= rightY) {

		         if (a[i] <= a[j]) { // 인덱스 값 비교
		        	 tmp[index++] = a[i++];

		         } else if (a[i] > a[j]) {
		        	 tmp[index++] = a[j++];

		         }
		      }

		      // 남아 있는 값들을 copy[]에 넣기
		      if (i > rightX) {
		         for (int k = j; k <= rightY; k++)
		            tmp[index++] = a[k];
		      }
		      else {
		         for (int k = i; k <= rightX; k++)
		            tmp[index++] = a[k];
		      }
		      
		      // a[]에 copy[] 복사
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
		MergeSort(x, 0, nx - 1); // 배열 x를 MergeSort

		System.out.println("[ Merge Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}

}
