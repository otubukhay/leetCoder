/*
Basic Calculator II
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
*/

    public int calculate(String s) 
    {
        int tail = 0;
        int num = 0;

        char oper = '+';
        int res = 0;

        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i++)
        {
            char c = chars[i];
            if (c != ' ') 
            {
                if (Character.isDigit(c)) 
                {
                    num = c - '0';
                    while (i + 1 < n && Character.isDigit(chars[i + 1]))
                    {
                        num = 10 * num + (chars[i + 1] - '0');
                        i++;
                    }

                    switch (oper) 
                    {
                        case '+':
                            res += tail;
                            tail = num;
                            break;
                        case '-':
                            res += tail;
                            tail = -num;
                            break;
                        case '*':
                            tail *= num;
                            break;
                        case '/':
                            tail /= num;
                            break;
                    }
                }
                else 
                {
                    oper = c;
                }
            }

        }

        return res + tail;
    }
