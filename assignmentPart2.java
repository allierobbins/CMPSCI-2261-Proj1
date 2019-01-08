import java.util.Random;
import java.util.Date;

public class assignmentPart2 {

	public static void main(String[] args) {
		
		//System.out.println("Sorting array of size 5000 with stdMergesort.");
		long stdMergeTime5000 = arraySize(5000, 1);
		
		//System.out.println("Sorting array of size 10,000 with stdMergesort.");
		long stdMergeTime10000 = arraySize(10000, 1);
		
		//System.out.println("Sorting array of size 20,000 with stdMergesort.");
		long stdMergeTime20000 = arraySize(20000, 1);
		
		System.out.println("Execution time for standard mergesort with 5,000 elements: " + stdMergeTime5000 + " milliseconds");
		System.out.println("Execution time for standard mergesort with 10,000 elements: " + stdMergeTime10000 + " milliseconds");
		System.out.println("Execution time for standard mergesort with 20,000 elements: " + stdMergeTime20000 + " milliseconds");
		
		//System.out.println("Sorting array of size 5000 with insertMergesort.");
		long insertMergeTime5000 = arraySize(5000, 2);
				
		//System.out.println("Sorting array of size 10,000 with insertMergesort.");
		long insertMergeTime10000 = arraySize(10000, 2);
				
		//System.out.println("Sorting array of size 20,000 with insertMergesort.");
		long insertMergeTime20000 = arraySize(20000, 2);
				
		System.out.println("Execution time for insert mergesort with 5,000 elements: " + insertMergeTime5000 + " milliseconds");
		System.out.println("Execution time for insert mergesort with 10,000 elements: " + insertMergeTime10000 + " milliseconds");
		System.out.println("Execution time for insert mergesort with 20,000 elements: " + insertMergeTime20000 + " milliseconds");
		
		
}//end of main
	
static long arraySize(int num, int type) {
	
	//create array 
	int[] array = new int[num];
			
	//fill array with random #s between 1 - 1000
	Random rand = new Random();
			
	for (int i = 0; i < num; i++) 
		array[i] = rand.nextInt(1000) + 1;
			
	/*System.out.print("Printing unsorted array");
	for (int i = 0; i < num; i++) 
		System.out.println(array[i] + " ");*/
		
	//set time at start of algorithm
	Date startTime = new Date();
	
	//send array to proper algorithm
	if (type == 1)
		stdMergeSort(array, 0, num - 1);
	
	if (type == 2)
		insertMergeSort(array, 0, num - 1);
	
	//set time at end of algorithm
	Date endTime = new Date();
			
	/*System.out.print("Printing sorted array");
	for (int i = 0; i < num; i++) 
		System.out.println(array[i] + " ");*/
	
	return (endTime.getTime() - startTime.getTime());
	
}//end of arraySize
	
static void stdMergeSort(int array[], int left, int right) {
		
        if (left < right) {
            
            int midpoint = (left + right) / 2;
 
            // Sort first and second halves
            stdMergeSort(array, left, midpoint);
            stdMergeSort(array, midpoint + 1, right);
 
            // Merge the sorted halves
            merge(array, left, midpoint, right);
        }
	
}//end of stdMergeSort
	
static void merge(int array[], int left, int midpoint, int right) {
	
        //get array length
        int size1 = midpoint - left + 1;
        int size2 = right - midpoint;
 
        //create left/right arrays
        int leftArray[] = new int [size1];
        int rightArray[] = new int [size2];
 
        //copy array elements
        for (int i = 0; i < size1; i++)
            leftArray[i] = array[left + i];
        
        for (int j = 0; j < size2; j++)
            rightArray[j] = array[midpoint + 1 + j];
 
        int i = 0;
        int j = 0;
 
        
        int k = left;
        while (i < size1 && j < size2) {
        	
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
 
        //copy elements
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
 
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        
}//end of merge

static void insertMergeSort(int array[], int left, int right) {
	
	int midpoint = (right + left) / 2; 

	 //w/ new midpoint
	 if((midpoint) > left)
	    insertMergeSort(array, left, midpoint);
	 if((right) > (midpoint + 1) )
	    insertMergeSort(array, midpoint + 1, right);

	  //merge 
	 insertMerge(array, left, midpoint + 1, right);
	
}//end of insertMergeSort

static void insertMerge(int array[], int left, int midpoint, int right) {
	
	int temp;
	
	//swap elements
	for (int i = midpoint; i <= right; i++) {
		int j = i;
		while (j > left && array[j - 1] > array[j]) {
			temp = array[j];
			array[j] = array[j - 1];
			array[j - 1] = temp;
			j--;
		}
		
	}
		
}//end of insertMerge
 
}//end of program file
