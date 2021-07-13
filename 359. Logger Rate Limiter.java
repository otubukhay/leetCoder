class Logger {

        private int[] buckets;
        private Set[] sets;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            buckets = new int[10];
            sets = new Set[10];
            for (int i = 0; i < sets.length; ++i) {
                sets[i] = new HashSet<String>();
            }
        }

        /**
         * Returns true if the message should be printed in the given timestamp,
         * otherwise returns false. If this method returns false, the message
         * will not be printed. The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message)
        {
            int idx = timestamp % 10;
            if (timestamp != buckets[idx]) 
            {
                sets[idx].clear();
                buckets[idx] = timestamp;
            }
            
            for (int i = 0; i < buckets.length; ++i) //constant time bucket always size 10
            {
                if (timestamp - buckets[i] < 10) {
                    if (sets[i].contains(message)) {
                        return false;
                    }
                }
            }

            sets[idx].add(message);
            return true;
        }
    }