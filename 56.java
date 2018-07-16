import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        
        if(intervals == null || intervals.size() == 0){
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        result.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval tmp = intervals.get(i);
            if(tmp.start > result.get(result.size() - 1).end ){
                result.add(intervals.get(i));
            }
            else if(tmp.start == result.get(result.size() - 1).end){
                // int max = Math.max(tmp.end, result.get(result.size()-1).end);
                // result.get(result.size()-1).end =  max;
                result.get(result.size()-1).end =  tmp.end;
            }
            else if(tmp.end < result.get(0).start){
                result.add(0,intervals.get(i));
            }
            else if(tmp.end == result.get(0).start){
                result.get(0).start = tmp.start;
            }
            else{
                int j = 0;
                for(j = 0; j < result.size(); j++ ){
                    if(tmp.start < result.get(0).start){
                        // if(result.get(j).end >= tmp.end && tmp.end >= result.get(j).start){
                        //     int min = Math.min(tmp.start, result.get(j).start);
                        //     result.get(j).start = min;
                        //     break;
                        // }
                        if(tmp.end >= result.get(0).start){
                            result.get(0).start = tmp.start;
                            int max = Math.max(tmp.end, result.get(0).end);
                            result.get(0).end = max;
                            // break;
                        }
                    }
                    else if(j + 1 < result.size()){
                        if(result.get(j).start <= tmp.start && result.get(j+1).start > tmp.start ){
                            if(tmp.start <= result.get(j).end ){
                                int max = Math.max(tmp.end, result.get(j).end);
                                result.get(j).end = max;
                                // break;
                            }
                        }
                        else if(tmp.start <= result.get(j).start && tmp.end >= result.get(j).end){
                            result.get(j).start = tmp.start;
                            result.get(j).end = tmp.end;
                            // break;
                        }
                        else if(result.get(j).end < tmp.start && result.get(j+ 1).start > tmp.end){
                            result.add(intervals.get(i));
                            // break;
                        }
                        
                        // else if(result.get(j).start <= tmp.start && tmp.start <= result.get(j).end ){
                        //     int max = Math.max(tmp.end, result.get(j).end);
                        //     result.get(j).end = max;
                        //     break;
                        // }
                    }
                    else{
                        if(result.get(j).start <= tmp.start && tmp.start <= result.get(j).end ){
                            int max = Math.max(tmp.end, result.get(j).end);
                            result.get(j).end = max;
                            // break;
                            
                        }
                        else if(result.get(j).end >= tmp.end && tmp.end >= result.get(j).start){
                            int min = Math.min(tmp.start, result.get(j).start);
                            result.get(j).start = min;
                            // break;
                        } 
                    }

                }

            }

        }
        return result;
    }
}
