package Submit;

public class HeapSort {
	// 구현해야 할 메소드 : 1. Insert, 2. DeleteMax 3. MaxHeap
	// 주의 : Heap의 [0]은 사용하지 않음.
	static int[] heap = new int[21];
	static int HeapSize;
	
	// 1. Insert 
	static void Insert(int n) {
		int i = ++HeapSize;
		
		while(i!=1&& heap[i/2]<n) {
			heap[i]=heap[i/2];i=i/2;
		}
		heap[i]=n;
	}
	
	// 2. Delete
//    static int delete() {
//        int result = heap[1];
//        int n = heap[size--];
//        
//        int parent = 1;
//        int child = 2;
//        
//        while(child <=size) {
//            //자식중에 더큰값을 고른다.
//            if(child<size && heap[child] <heap[child+1]) {
//                child++;
//            }
//            //자식과 부모를 비교해서 부모가 더크다면 while 빠져나온다
//            if(item >= heap[child]) {
//                break;
//            }
//            
//            //그게아니라면 갱신한다
//            //parent의 위치에 child를 올린다.
//            
//            heap[parent] = heap[child];
//            parent = child;
//            child = child*2;
//        }
//        
//        
//        heap[parent] = item;
//        
//        return result;
//        
//    }	
	
	

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
//		HeapSort(x,nx); // 배열 x를 MergeSort

		System.out.println("[ Heap Sort 실행.] * Sorted by ASC");
		System.out.println();
		System.out.print("[정렬 후]");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}

}
