// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.


public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
        if (x2 > 0) {
            for(int i = 0 ; i < x2 ; i++) {
                x1++;
            }
        } else {
            for(int i = 0 ; i > x2 ; i--) {
                x1--;
            }
        }
        return x1;
    }
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
        if (x2 > 0) {
            for(int j = 0 ; j < x2 ; j++) {
                x1--;
            }
        } else {
            for(int j = 0 ; j > x2 ; j--) {
                x1++;
            }
        }
        return x1;
    }
    
	// Returns x1 * x2
	public static int times(int x1, int x2) {
        int temp = 0;
        if (x2 > 0) {
            for(int i = 0; i < x2; i++) {
                temp = plus(temp, x1);
            }
        } else {
            for(int i = 0; i > x2; i--) {
                temp = minus(temp, x1);
            }
        }
        return temp;
    }

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
        int sum = 1;
        if (n == 0) {
            return 1;
        }
        for(int i = 0 ; i < n ; i++) {
            sum = times(sum, x);
        }
        return sum;
    }

	public static int div(int x1, int x2) {
		if (x2 == 0) return -1;
		int absX1;
		if (x1 < 0) {
			absX1 = minus(0, x1);
		} else 
		{
			absX1 = x1;
		}
		int absX2;
		if (x2 < 0) {
			absX2 = minus(0, x2);
		} else {
			absX2 = x2;
		}
		int counter = 0;
		while (absX1 >= absX2) {
			absX1 = minus(absX1, absX2);
			counter++;
		}
			if (times(x1, x2) < 0) 
			{
			counter = minus(0, counter);
			}
		return counter;
		}
	public static int mod(int x1, int x2) {
		int x = div(x1,x2);
		return minus(x1, times(x, x2));
	}
	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		double epsilon = 0.01;
		double g = x;
		while (Math.abs(g * g - (double)x) > epsilon) {
			g = g - (g * g - x) / (2 * g);
		}
		return (int)g;
	}	  	  
}