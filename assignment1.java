import java.util.Scanner;
import java.util.Random;
import java.util.Date;

public class assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Create scanner
		Scanner input = new Scanner(System.in);
		
		int run = 1;
		String turn = "Quicksort";
		
		System.out.print("Enter the size for an array as a multiple of 500 (use -1 to exit program) :\n ");
		System.out.print("Array Size  \t\t Algorithm Used  \t\t Execution Time (In Milliseconds)  ");
		
		do {
			
		//prompt for array size
		//System.out.print("Enter the size for an array as a multiple of 500 (use -1 to exit program) : ");
		int arraySize = input.nextInt();
		
		if (arraySize == -1)
			break;
			
		while (arraySize < 10 || arraySize > 50000 || (arraySize % 5 != 0 && arraySize != -1) ){
			System.out.print("Invalid number - try again: ");
			arraySize = input.nextInt();
				}

		//System.out.print("The array has " + arraySize + " elements.");
		
		//make an array with (# of arraySize) elements
		int[] array = new int[arraySize];
		
		//fill array with random #s between 1 - 1000
		Random rand = new Random();
		
		for (int i = 0; i < arraySize; i++) 
			array[i] = rand.nextInt(1000) + 1;

			
		/*System.out.print("Printing unsorted array");
		for (int i = 0; i < arraySize; i++) 
			System.out.println(array[i] + " ");*/
		
		//set time at start of sorting algorithm
		Date startTime = new Date();
		
		//sort array with Heapsort/Quicksort alternatively
		if (turn == "Heapsort") {
		heapsort(array);
		turn = "Quicksort";
		} else {
		quicksort(array, 0, arraySize - 1);
		turn = "Heapsort";}
		
		//set time at end of sorting algorithm 
		Date endTime = new Date();
		
		/*System.out.print("Printing sorted array");
		for (int i = 0; i < arraySize; i++) 
			System.out.println(array[i] + " ");*/
		
		System.out.println("\t" + arraySize + " \t \t\t" + turn + " \t\t\t " + (endTime.getTime() - startTime.getTime()));
		
		} while (run != 0);
		
		System.out.println("Program has ended.");
}//end of main
	
static void heapsort(int array[]) {
		
	int n = array.length;
	 
    //build heap
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(array, n, i);

    for (int i = n - 1; i >= 0; i--) {
        
    	//move current root to end
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;

        //call heapify
        heapify(array, i, 0);
    }
	
}//end of heapsort

static void heapify(int array[], int n, int i) {
	
    int biggest = i;  // Initialize biggest as root
    int left = 2 * i + 1;
    int right = 2 * i + 2;  

    // If left child is larger than root
    if (left < n && array[left] > array[biggest])
        biggest = left;

    // If right child is larger than biggest so far
    if (right < n && array[right] > array[biggest])
        biggest = right;

    // If biggest is not root
    if (biggest != i) {
        int swap = array[i];
        array[i] = array[biggest];
        array[biggest] = swap;

        // Recursively heapify the affected sub-tree
        heapify(array, n, biggest);
    }
}//end of heapify

static void quicksort(int array[], int low, int high) { 
	
    if (low < high) {
        
        int part = partition(array, low, high);

        quicksort(array, low, part - 1);
        quicksort(array, part + 1, high);
    }
}//end of quicksort

static int partition(int array[], int low, int high) {
	
    int midpoint = array[high]; 
    int i = (low - 1); 
    
    for (int j = low; j < high; j++) {
    	
        if (array[j] <= midpoint) {
            i++;

            //swap elements
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    //swap elements
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
    
}//end of partition

} // end of program file
	



