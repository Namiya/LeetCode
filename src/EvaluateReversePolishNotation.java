
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

/*
 * System.out.println(reverseWords("   a       b "));
 * System.out.print(evalRPN(s));
 * String[] s = {"4", "13", "5", "/", "+"};
 * 		int [][] p = new int[][] {{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691},{-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
		Point[] points = new Point [p.length];
		for (int i=0; i<p.length; i++)
			points[i] = new Point(p[i][0],p[i][1]);
		
		System.out.print(maxPoints(points));
 *
 *
 */
