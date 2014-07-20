
public class ReverseWordInAString {
    public String reverseWords(String s) {
        String outputString="";
       	String[] tempStrings = s.split(" ");
		int i = tempStrings.length;
		while (i>0)
		{
			i--;
			if (!tempStrings[i].isEmpty())
			{
				outputString = outputString + tempStrings[i] + " ";	
			}	
		}		
		outputString = outputString.trim();
		return outputString;
    }
}

