class RandomizedSet {

    private List<Integer> list;
    private Map<Integer,Integer> map; // val:index

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        map.remove(val);
        
        int lastIndex = list.size() - 1;
        if(index == lastIndex) list.remove(index);
        else {
            int lastElement = list.get(lastIndex);
            list.set(index, lastElement);
            list.remove(lastIndex);
            map.put(lastElement, index);
        }
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */