    class Leaderboard {
        Map<Integer, Integer> scores;
        TreeMap<Integer, Integer> sortedScores;
        public Leaderboard() {
            this.scores = new HashMap<Integer, Integer>();
            this.sortedScores = new TreeMap<>(Collections.reverseOrder());
        }
        public void addScore(int playerId, int score)
        {
            if (!this.scores.containsKey(playerId))
            {
                this.scores.put(playerId, score);
                this.sortedScores.put(score, this.sortedScores.getOrDefault(score, 0) + 1);
            }
            else
            {
                int preScore = this.scores.get(playerId);
                int playerCount = this.sortedScores.get(preScore);
                if (playerCount == 1)
                {
                    this.sortedScores.remove(preScore);
                }
                else
                {
                    this.sortedScores.put(preScore, playerCount - 1);
                }
// Updated score
                int newScore = preScore + score;
                this.scores.put(playerId, newScore);
                this.sortedScores.put(newScore, this.sortedScores.getOrDefault(newScore, 0) + 1);
            }
        }
        public int top(int K)
        {
            int count = 0;
            int sum = 0;
// In-order traversal over the scores in the TreeMap
            for (Map.Entry<Integer, Integer> entry: this.sortedScores.entrySet())
            {
                if(count + entry.getValue() <= K)
                {
                    sum += (entry.getValue() * entry.getKey());
                    count += entry.getValue();
                }
                else
                {
                    for(int i = 1; i <= K - count; i++)
                    {
                        sum +=entry.getKey();
                    }
                    break;
                }
            }
            return sum;
        }
        public void reset(int playerId) {
            int preScore = this.scores.get(playerId);
            this.sortedScores.put(preScore, this.sortedScores.get(preScore) - 1);
            if (this.sortedScores.get(preScore) == 0) {
                this.sortedScores.remove(preScore);
            }
            this.scores.remove(playerId);
        }
    }