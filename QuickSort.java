package Submit;

import java.util.Scanner;

//퀵 정렬
public class QuickSort {

	// [메소드1] a 배열에서 idx1 요소와 idx2 요소 바꿈.
	 static void swap(int[] a, int idx1, int idx2) {
		 int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
	 }
 
	 
	// 퀵정렬 (non-recursive)
	 static void quickSort(int[] a, int left, int right) {
		 PointStack stack = new PointStack(right - left + 1);
		 
		 Point p1 = new Point(left,right);
		 stack.push(p1);
	     
	     while (stack.isEmpty() != true) {
	         //정렬할 배열의 범위
	    	 Point p2 = stack.pop();
	         int pl = left  = p2.getX();        //왼쪽 커서
	         int pr = right = p2.getY();        //오른쪽 커서
	         int x = a[(left + right) / 2];        //피벗
	         
	         
	         //피벗을 기준으로 하위 그룹과 상위 그룹으로 나눈다
	         do {
	             while (a[pl] < x) pl++;
	             while (a[pr] > x) pr--;
	             
	             if (pl <= pr)
	                 swap(a, pl++, pr--);
	         } while (pl <= pr);
	         
	         if (left < pr) {
	        	 Point p3 = new Point(left,pr);
	        	 stack.push(p3);
	         }
	         if (pl < right) {
	        	 Point p4 = new Point(pl,right);
	        	 stack.push(p4);
	         }
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

		quickSort(x, 0, nx - 1); // 배열 x를 MergeSort
		
		System.out.println("[ Quick Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}

}

