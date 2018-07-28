import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int getMin(List<List<Integer>> triangle, int pos,int level){
        if(triangle.size() == level) return 0;
        else{
            return triangle.get(level).get(pos) + Math.min(getMin(triangle, pos, level+1), getMin(triangle, pos+1, level+1));
        } 
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
        // if(triangle.size() == 0) return 0;
        // else if(triangle.size() == 1){
        //     List<Integer> tmp = triangle.get(0);
        //     int min = tmp.get(0);
        //     // for(int i = 0 ;i < tmp.size(); i ++){
        //     //     min = Math.min(min, tmp.get(i));
        //     // }
        //     return min;
        // }
        // else{
        //     List<List<Integer>> lefttriangle = new ArrayList<List<Integer>>();
        //     List<List<Integer>> righttriangle = new ArrayList<List<Integer>>();
        //     for(int k = 1 ; k < triangle.size(); k ++){
        //         List<Integer> tmp = new ArrayList<Integer>();
        //         for(int i = 0; i < k ; i ++){
        //             tmp.add(triangle.get(k).get(i));
        //         }
        //         lefttriangle.add(tmp);
        //     }

        //     for(int k = 1 ; k < triangle.size(); k ++){
        //         List<Integer> tmp = new ArrayList<Integer>();
        //         for(int i = 0; i < k ; i ++){
        //             tmp.add(triangle.get(k).get(i+1));
        //         }
        //         righttriangle.add(tmp);
        //     }

        //     return triangle.get(0).get(0) + Math.min(minimumTotal(lefttriangle), minimumTotal(righttriangle));
        // }
    }
}