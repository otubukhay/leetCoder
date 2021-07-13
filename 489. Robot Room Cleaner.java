 public void cleanRoom(Robot robot) {
        visited.add(0 + "->" + 0);
        startCleaning(0, 0, 0, robot);
    }

    void startCleaning(int x, int y, int d, Robot robot) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newDir = (d + i) % 4;
            int[] dir = dirs[newDir];
            int newR = x + dir[0];
            int newC = y + dir[1];
            String key = newR + "->" + newC;
            if (!visited.contains(key) && robot.move()) 
            {
                visited.add(key);
                startCleaning(newR, newC, newDir, robot);
                returnBack(robot);
            }
            robot.turnRight();
        }
    }

    void returnBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }