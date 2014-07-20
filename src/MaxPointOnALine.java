//test case: "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"

public class MaxPointOnALine {
	 public static class Point {
		    int x;
		    int y;
		    Point() { x = 0; y = 0; }
		    Point(int a, int b) { x = a; y = b; }
		}

		 static class Slope {
			int deltaX;
			int deltaY;
			int number;
			Slope () {deltaX=0; deltaY=0; number=2;}
			Slope (int a, int b) {deltaX = a; deltaY=b; number=2;}
		}

		///try to optimize this function///////////////
	    public static int maxPoints(Point[] points) 
	    {
	    	int pointNum = points.length;   	
	    	
	    	if (pointNum < 3) 
	    		return pointNum;
	   
	    	int max = 0;
	    	for (int i=0; i<pointNum; i++)
	    	{
	    		Slope[] slopes = new Slope [pointNum];
	    		int slopeNum = 0;    		
				
	    		int XlineNum = 1;
				int YlineNum = 1;
				int sameNum = 0;
				int maxi=0;
				
	    		for (int j=i+1; j<pointNum; j++)
	    		{
	    			int deltaX = 0;
	    			int deltaY = 0;
	    			int flag = 0;
	    			
	    			deltaX = points[i].x - points[j].x;
	    			deltaY = points[i].y - points[j].y;
	    			
	    			if ((deltaX ==0) && (deltaY ==0))
	    			{
	    				sameNum++;
	    				continue;
	    			}
	    			if (deltaX == 0) 
	    			{
	    				XlineNum++;
	    				continue;
	    			}
	    			if (deltaY == 0)
	    			{
	    				YlineNum++;
	    				continue;
	    			}
					
	    			for (int k=0; k<slopeNum; k++)
	    			{
	    				if (deltaX*slopes[k].deltaY == deltaY*slopes[k].deltaX) 
	    				{	
							slopes[k].number++;
							if (slopes[k].number > maxi)
								maxi = slopes[k].number;
							flag = 1;
							break;
						}	
	    				
	    			}
	    			if (flag == 0)
	    			{
	    				slopes[slopeNum] = new Slope(deltaX, deltaY);
	    				slopeNum ++;
	    				if (maxi == 0) 
	    					maxi = 2;
	    			}
	    		}
	    		if (XlineNum > maxi)
	        		maxi = XlineNum;
	        	if (YlineNum > maxi)
	        		maxi = YlineNum;
	        	maxi += sameNum;
	        	if (maxi > max)
	        		max = maxi;
	    	}    	    	
	        return max;
	    }

	    
	    ////O(n^3)    
	    public static String longestPalindrome(String s) {
	    	String maxString="";
	        String reverseStr = new StringBuilder(s).reverse().toString(); 
	    	int sLen = s.length();
	    	for (int i=1; i<=sLen; i++)
	    	{
	    		for (int j=0; i+j<=sLen; j++)
	    		{
	    			String s1 = s.substring(j, i+j);
	    			String s2 = reverseStr.substring(sLen-i-j, sLen-j);
	    			if (s1.matches(s2))
	    			{
	    				maxString = s1;
	    				break;
	    			}
	    		}
	    	}
	        return maxString;
	    }
	    
	    ////O(n)
	    public static String longestPalindrome2(String s) {
	    
	    	String s1="#";
	    	
	    	for (int i=0;i<s.length(); i++)
	    	{
	    		s1 += s.charAt(i) + "#";
	    	}
	    	
	    	int[] P= new int[2*s.length()+1];
	    	for (int i=0; i<=s.length()*2; i++)
	    	{
	    		int len=0;
	    		
	    		for(int j=1; ((i-j)>=0)&&(i+j)<=s.length()*2; j++)
	    		{
	    			if (s1.charAt(i-j) == s1.charAt(j+i))
	    			{ 
	    				len = j;
	    			}
	    			else break;
	    		}
	    		
	    		P[i] = len;
	    	}
	    	
	    	int maxLen=0, maxPos=0;
	    	for (int i=0; i<=s.length()*2; i++)
	    	{
	    		if (P[i]>maxLen)
	    		{
	    			maxLen = P[i];
	    			maxPos = i;
	    		}
	    	}
	    	
	    	String s2 = "";
	    	for(int i=1;i<2*maxLen; i++)
	    	{
	    		if (i%2 == 1) 
	    		{
	    			s2 += s1.charAt(maxPos-maxLen+i);
	    		}
	    		
	    	}
	    	
	    	return s2;
	    }

}
