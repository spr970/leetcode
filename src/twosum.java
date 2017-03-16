import java.util.Arrays;

public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            for (int j=nums.length-1; j>i; j--) {
                if (nums[i]+nums[j] == target) {
                    result[0]=i;
                    result[1]=j;
                    return result;
                } 
            }
        }
        return result;
    }
    
    public static int partition(int[] arr, int beg, int end) {
    	int i=beg, j=end;
    	int pivot = arr[(i+j)/2];
    	int tmp;
    	
    	while (i<=j) {
    		while (arr[i]<pivot) {
    			i++;
    		}
    		while (arr[j]>pivot) {
    			j--;
    		}
    		if (i<=j) {
    			tmp=arr[i];
    			arr[i]=arr[j];
    			arr[j]=tmp;
    			i++;
    			j--;
    		}
    	}
    	return i;
    }
    
    public static void quickSort(int[] arr, int beg, int end) {
        int index = partition(arr, beg, end);
        if (beg < index - 1)
        	quickSort(arr, beg, index - 1);
        if (index < end)
            quickSort(arr, index, end);
    }
    
    public static void main(String[] args) {
    	int[] input={150,24,79,50,88,345,3};
//    	System.out.println(Arrays.toString(input));
    	System.out.print(Arrays.toString(twoSum(input,200)));
    }
}