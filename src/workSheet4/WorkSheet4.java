package worksheet4;

public class WorkSheet4 {

	
	 public static void main(String[] args) {
		System.out.println(Palindrome("di obabo id"));
	 }
	 public static int power(int base, int exponent){
		if(exponent == 0)
				 return 1;
		else
				 return (base * power(base, exponent-1));
			 }
	
		 public static boolean Palindrome(String str){
		      if(str.length() == 0 || str.length() == 1)
		         return true; 
		      if(str.charAt(0) == str.charAt(str.length() - 1))
		         return Palindrome(str.substring(1, str.length() - 1));
		      return false;
		   }
		 
	 
}
