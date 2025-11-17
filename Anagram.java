public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  
	public static int count(String str, char c) {
    	int counter = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == c) {
					counter++;
				}
			}
			return counter;
	}
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			if (count(str1, str1.charAt(i)) != count(str2, str1.charAt(i))) {
				return false;
			}
		}
    return true;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String fix_str = "";
		for(int i = 0 ; i< str.length(); i++)
		{
			int value_of_char = (int)(str.charAt(i));
		if ((value_of_char >= 48 && value_of_char <= 57) || (value_of_char >= 65 && value_of_char <= 90) || (value_of_char >= 97 && value_of_char <= 122) || value_of_char == 32) {
			{
				fix_str = fix_str + str.charAt(i);
			}
		}
	}
		return fix_str.toLowerCase();
	} 
	 
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int randomNum = 0 ;
		String Anagram = "";
		while (str.length() !=0 )
		{
			randomNum = (int)(Math.random() * str.length());
			Anagram = Anagram + str.charAt(randomNum);
			String part1 = str.substring(0, randomNum);
			String part2 = str.substring(randomNum + 1);
			str = part1 + part2;
		}
		return Anagram;
	}
}
