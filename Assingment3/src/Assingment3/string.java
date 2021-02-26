package Assingment3;

/**
 * A custom string class
 * @since 25-02-21
 * @author krishna.meghwal_meta*/
public class string {
	char[] rawString;
	int length ;
	
	public string(char[] str, int length){
		this.rawString =  new char[length];
		this.length = length;
		int index = 0;
		for(char c : str){
			rawString[index] = c;
			index++;
		}	
	}
	
	/**
	 * Return the reverse of any string
	 * @return char[]
	 */
	public char[] reverseString(){
		char[] reverse = new char[this.length];
		
		int k = 0;
		for(int index = this.length - 1; index >= 0; index--){
			reverse[k++] = this.rawString[index];
		}
		
		return reverse;
	}
	
	/**
	 * Compare two strings and return 1 if equals else 0 
	 * @param char[] char[] 
	 * @return int
	 */
	public static int equalString(char str1[], char[] str2){
		int lengthStr1 = str1.length;
		int lengthStr2 = str2.length;
				
		if(lengthStr1 == lengthStr2){
			for(int index = 0; index < lengthStr1; index++){
				if(str1[index] != str2[index]){
					return 0;
				}
			}
		}else{
			return 0;
		}
		return 1;
	}
	
	/**
	 *replace lowercase characters with uppercase and vice-versa
	 *@param char[]
	 *@return char[]
	 */
	public static char[] toggleCharacters(char[] str){
		char[] resultStr = new char[str.length];
		int k = 0;
		for(char c : str){
			if(c >= 65 && c <= 90){
				resultStr[k++] = (char)(c + 32);
			}else if(c >= 97 && c <= 122){
				resultStr[k++] = (char)(c - 32);
			}
		}
		return resultStr;
	}
	
	/**
	 * Return the largest word of a string. If two words are of same length then return last word
	 * @param char[]
	 * @return char[]
	 */
	public static char[] largestWord(char[] str){
		
		char[] longestWord = null;
		int length = str.length, maxLengthWord = 0, curLength = 0, startIndex = 0;
		for(int index = 0; index < length; index++){
			if(str[index] != ' '){
				curLength++;
			}else{
				if(maxLengthWord <= curLength){
					maxLengthWord = curLength;
					longestWord = new char[maxLengthWord];
					for(int i = startIndex; i < index; i++){
						longestWord[i - startIndex] = str[i];
					}
				}
				startIndex = index + 1;
				curLength = 0;
			}
		}
		
		if(maxLengthWord <= curLength){
			maxLengthWord = curLength;
			longestWord = new char[maxLengthWord];
			for(int i = startIndex; i < length; i++){
				longestWord[i - startIndex] = str[i];
			}
		}
		
		return longestWord;
	}
	
	

}
