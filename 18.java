// import java.util.List;

// import javax.xml.transform.TransformerConfigurationException;

// class Solution {
//     public static int partition(int[] array, int low, int high){
//         int key = array[low];
//         while(low < high){
//             while(array[high] >= key && high > low){
//                 high -- ;
//             }
//             array[low] = array[high];
//             while(array[low] <= key && high > low){
//                 low ++;
//             }
//             array[high] = array[low];
//         }
//         array[high] = key;
//         return high;
//     }

//     public static void quickSort(int[] array, int low, int high){
//         if(low >= high){
//             return;
//         }
//         int index = partition(array, low, high);
//         quickSort(array, low, index -1);
//         quickSort(array, index+1, high);
//     }

//     public static int indexSearch(int[] array, int target){
//         for(int i = 0; i < array.length-1; i ++){
//             if(array[i] <= target && array[i+1] >= target){
//                 return i;
//             }
//         }
//         return -1;
//     }

//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         quickSort(nums, 0, nums.length - 1);
//         List<List<Integer>> result = new ArrayList<List<Integer>>(); 
//         if(nums.length < 4){
//             return result;
//         }
//         // for(int i = 0; i < nums.length; i ++){
//         //     tmplist.add(i, nums[i]);
//         // }
//         // result.add(0, tmplist);
//         int tmpresult = 0;
//         // for(int i = 0; i < nums.length; i ++){
//         //     nums[i] = nums[i] - target;
//         // }
//         int index = indexSearch(nums, target);
//         for(int low = index; low >=0; low--){
//             for(int high = index + 1; high < nums.length; high ++ ){
//                 tmpresult = nums[low] + nums[high];
//                 if(tmpresult > target){
//                     for(int low2 = low -1; low2 >=0; low2 --){
//                         tmpresult = nums[low] + nums[high] + nums[low2];
//                         if(tmpresult > target){
//                             for(int low3 = low2 -1 ; low3 >=0; low3 --){
//                                 tmpresult = nums[low] + nums[high] + nums[low2] + nums[low3];
//                                 if(tmpresult == target){
//                                     List<Integer> tmplist=new ArrayList<Integer>();
//                                     tmplist.add(0, nums[low3] );
//                                     tmplist.add(1, nums[low2] );
//                                     tmplist.add(2, nums[low] );
//                                     tmplist.add(3, nums[high] );
//                                     result.add(0, tmplist);
//                                 }
//                                 else if(tmpresult < target){
//                                     break;
//                                 }
//                             }
//                         }
//                         else{   
//                             for(int high2 = high+1; high2 < nums.length; high2 ++){
//                                 tmpresult = nums[low]  + nums[low2] + nums[high] + nums[high2];
//                                 if(tmpresult==target){
//                                     List<Integer> tmplist=new ArrayList<Integer>();
//                                     tmplist.add(0, nums[low2] );
//                                     tmplist.add(1, nums[low] );
//                                     tmplist.add(2, nums[high] );
//                                     tmplist.add(3, nums[high2]);
//                                     result.add(0, tmplist);
//                                 }
//                                 else if(tmpresult > target){
//                                     break;
//                                 }
                                
//                             }
//                         }
//                     }
//                 }
//                 else{
//                     for(int high2= high+1; high2 < nums.length; high2 ++){
//                         tmpresult = nums[low] + nums[high] + nums[high2];
//                         if(tmpresult > target){
//                             for(int low2 = low -1 ; low2 >=0; low2 --){
//                                 tmpresult = nums[low] + nums[high] + nums[low2] + nums[high2];
//                                 if(tmpresult == target){
//                                     List<Integer> tmplist=new ArrayList<Integer>();
//                                     tmplist.add(0, nums[low2] );
//                                     tmplist.add(1, nums[low] );
//                                     tmplist.add(2, nums[high] );
//                                     tmplist.add(3, nums[high2] );
//                                     result.add(0, tmplist);
//                                 }
//                                 else if(tmpresult < target){
//                                     break;
//                                 }
//                             }
//                         }
//                         else{
//                             for(int high3 = high2 + 1; high3 < nums.length; high3 ++){
//                                 tmpresult = nums[low]  + nums[high3] + nums[high] + nums[high2];
//                                 if(tmpresult==target){
//                                     List<Integer> tmplist=new ArrayList<Integer>();
//                                     tmplist.add(0, nums[low]);
//                                     tmplist.add(1, nums[high] );
//                                     tmplist.add(2, nums[high2] );
//                                     tmplist.add(3, nums[high3] );
//                                     result.add(0, tmplist);
//                                 }
//                                 else if(tmpresult > target){
//                                     break;
//                                 }
                                
//                             }
//                         }      

//                     }
//                 }
//             }
//         }
        
//         return result;   
//     }
// }

class Solution {
    public static int partition(int[] array, int low, int high){
        int key = array[low];
        while(low < high){
            while(array[high] >= key && high > low){
                high -- ;
            }
            array[low] = array[high];
            while(array[low] <= key && high > low){
                low ++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    public static void quickSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int index = partition(array, low, high);
        quickSort(array, low, index -1);
        quickSort(array, index+1, high);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);
        for(int i=0; i<nums.length; i++) { 
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            else {
                for(int j=i+1; j<nums.length; j++) {
                    if(j > i+1 && nums[j] == nums[j-1])
                        continue;
                    else {
                        int l = j+1;
                        int r = nums.length-1;
                        while(l < r) {
                            if(l > j+1 && nums[l] == nums[l-1]) {
                                l++;
                                continue;
                            }
                            if( nums[i] + nums[j] + nums[l] + nums[r] == target) {
                                List<Integer> tmpList = new ArrayList<>();
                                tmpList.add(nums[i]);
                                tmpList.add(nums[j]);
                                tmpList.add(nums[l]);
                                tmpList.add(nums[r]);
                                result.add(tmpList);
                                r--;
                                l++;
                            } else if( nums[i] + nums[j] + nums[l] + nums[r] > target)
                                r--;
                            else 
                                l++;
                        }
                    }
                }
            }
        }
        return result;
    }
}