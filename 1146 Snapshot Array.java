
    TreeMap<Integer, Integer>[] treeMaps; // TreeMap is used because if there is no record for a snapId, we should get //highest snapId record
    int snapId = 0;

    public Solutionsrray(int length) {
        treeMaps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            treeMaps[i] = new TreeMap<Integer, Integer>();
            treeMaps[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        treeMaps[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
// TreeMap is used because if there is no record for a snapId, we should get //highest snapId record[FloorEntry]
        return treeMaps[index].floorEntry(snapId).getValue();
    }
	
	
		//["SnapshotArray","set","snap","set","get"], [[3],[0,5],[],[0,6],[0,0]], Output: null,null,0,null,5] Explanation: SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3 snapshotArr.set(0,5); // Set array[0] = 5 snapshotArr.snap(); // Take a snapshot, return snap_id = 0 snapshotArr.set(0,6); snapshotArr.get(0,0); // Get the value of array[0] with snap_id = 0, return 5 //Store a treemap for each entry in array to record changes to that entry
//index = entry, treemapkey = snapshotid, value = entry value
