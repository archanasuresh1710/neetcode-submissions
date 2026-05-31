class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int h: hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        Arrays.sort(hand);
        // System.out.println("MAP: " + map);

        for(int i=0;i<hand.length;i++) {
            
            if(map.isEmpty()) return true;

            int x = hand[i];

            if(!map.containsKey(x)) continue;
            // System.out.println("BEFORE: x -> " + x + " | MAP: " + map);
            map.put(x, map.get(x) - 1);

            if(map.get(x) == 0) map.remove(x);

            for(int j=1;j<groupSize;j++) {
                int next = x + j;

                if(!map.containsKey(next)) return false;

                map.put(next, map.get(next) - 1);
                if(map.get(next) == 0) map.remove(next);
            }

            // System.out.println("AFTER: x -> " + x + " | MAP: " + map);
        }

        return true;
    }
}
