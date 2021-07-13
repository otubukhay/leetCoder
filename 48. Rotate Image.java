 public void rotate(int[][] matrix) {
          for(int i = 0; i<matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0 ; i < matrix.length; i++)
        {
            int first = 0, last = matrix[0].length - 1;
            while(first < last)
            {
                int temp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = temp;
                first++;
                last--;
            }
           
        }
    }
	
	When the Java program runs in a particular machine it is sent to java compiler, which converts this code into intermediate code called bytecode. 
	This bytecode is sent to Java virtual machine (JVM) which resides in the RAM of any operating system. 
	JVM recognizes the platform it is on and converts the bytecodes into native machine code. 
	Hence java is called platform independent language.