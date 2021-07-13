 public double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        
        return pow(x, n);
    }
    
    double pow(double x, int n)
    {
        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;
        
        double half =  pow(x, n/2);
        return n % 2 == 0 ?   half * half : x * half * half;
    }