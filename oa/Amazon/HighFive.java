class Solution {
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        HashMap<Integer, PriorityQueue<Record>> map = new HashMap<Integer, PriorityQueue<Record>>();
        
        int k = 5;
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                PriorityQueue<Record> pq = new PriorityQueue<Record>(k, new Comparator<Record>() {
                   public int compare(Record a, Record b) {
                       return a.score - b.score; // min-heap
                   } 
                });
                map.put(r.id, pq);
            }
            
            map.get(r.id).add(r);
            if (map.get(r.id).size() > k) {
                map.get(r.id).poll();
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            result.put(id, average);
        }
        
        return result;
    }
}