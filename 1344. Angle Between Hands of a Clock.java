    public double angleClock(int hour, int minutes)
    {
        double hourValue = (hour * 60  + minutes);
        double minValue = minutes * 1.0;
        
        double hourAngle = (hourValue * 0.5) % 360;
        double minAngle = (minValue * 6) % 360;
        
        double angle =  Math.abs(hourAngle - minAngle);
        return (angle > 180) ? 360.0 - angle : angle;        
    }
	

