
public class EvaluateReversePolishNotation {
	public static  int evalRPN(String[] tokens) 
	{
		int sLen = tokens.length;
		int token[] = new int[sLen];
		int l=0;
		for (int i=0; i<sLen; i++)
		{
			if (tokens[i].length() > 1)
			{
				token[l] = Integer.parseInt(tokens[i]);
				l++;
			}
			else
			{
				char ch = tokens[i].charAt(0);
				if (('0'<=ch) && (ch <='9'))
				{
					token[l] = Integer.parseInt(tokens[i]);
					l++;
				}
				else 
				{
					int r = 0;
					switch (ch){
					case '+': r = token[l-2]+token[l-1]; break;
					case '-': r = token[l-2]-token[l-1]; break;
					case '*': r = token[l-2]*token[l-1]; break;
					case '/': r = token[l-2]/token[l-1]; break;
					
					default: return -1;
					}
					token[l-2] = r;
					l--;
				}
			}
		}
        return token[0];
    }

}
