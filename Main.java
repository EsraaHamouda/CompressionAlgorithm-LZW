import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Main {
	public static void main(String[] args) throws IOException {

		//String originalText = "abaababbaabaabaaaababbbbbbbb";
		String originalText = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(originalText.length());
		Vector<Integer> res = new Vector<Integer>();
		
		 res = compress(originalText);
		 System.out.println("res "+ res.toString());
		 String h = decompress(res);
		 System.out.println("decom "+h);
		 System.out.println("equals : "+ h.equals(originalText));
	}
	public static Vector<Integer> compress(String originalText) {
		Vector<Integer> results = new Vector<Integer>();
		//int lastCode = 
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		boolean bool = false;
		for (int i = 0; i < originalText.length(); i++) {
			String x = String.valueOf(originalText.charAt(i));
			char c = originalText.charAt(i);
			if (!myMap.containsKey(x)) {
				myMap.put(x, (int) c);
			}
		}
		String ss = "", tempChar = "";
		int asc = 127;
		int boolSize = 0;
		String lastIteration="";
		boolean jCondition = false;
		boolean isReachtheize = false;
		for (int i = 0; i < originalText.length(); i++) {

			String x = String.valueOf(originalText.charAt(i));
			ss = x;
			lastIteration = ss;
			int j = i;
			if (myMap.containsKey(x)) {
				if (j + 1 >= originalText.length())
				{
					//System.out.println("lastIteration = ss "+lastIteration);
					boolSize = j;
					jCondition = true;
					break;
				}					
				j++;
				tempChar = String.valueOf(originalText.charAt(j));
				ss += tempChar;
				lastIteration = ss;
				while (myMap.containsKey(ss)) {
					if (j + 1 >= originalText.length()) {
						bool = true;
						break;
					}
					j++;
					tempChar = String.valueOf(originalText.charAt(j));
					ss += tempChar;
					lastIteration = ss;					
				}
				String strResult = "";
				if (bool) {
					strResult = ss;
				} else if (ss.length() >= 2)
					strResult = ss.substring(0, ss.length() - 1);
				else
					strResult = ss;
				int compCode = myMap.get(strResult);
				results.add(compCode);
				i += (ss.length() - 2);
				asc++;
				myMap.put(ss, asc);
				ss = "";
			}
		}
		System.out.println("jCondition "+jCondition);
		if(jCondition&&!bool)
		{
			String v = lastIteration.substring(lastIteration.length()-1);
			int compCode = myMap.get(v);
			results.add(compCode);
			
			System.out.println("lase catg  "+ v); 
		}
		/*if(myMap.containsKey(lastIteration))
		{
			return results;
		}
		else
		{
			String xxx = lastIteration.substring(0, lastIteration.length()-1);
			String lastchar = String.valueOf(lastIteration.charAt(lastIteration.length()-1));
			int code = myMap.get(xxx);
			
			results.add(code);
			code = myMap.get(lastchar);
			results.add(code);
			return results;
		}*/
//		if(jCondition)
//		{
//			System.out.println("boolSize : "+boolSize);
//			tempChar = String.valueOf(originalText.substring(boolSize));
//			if(myMap.containsKey(tempChar))
//			{
//				int compCode = myMap.get(tempChar);
//				results.add(compCode);
//			}
//		}
		
		System.out.println("lastIteration = "+lastIteration);
		
		return results;
	}

	public static String decompress(Vector<Integer> tags) {

		Map<Integer, String> myMap = new HashMap<Integer, String>();
		int x;
		char c;
		int asc = 127;
		String finalResult = "", firstCharOfSecond = "", res = "";
		Vector<String> dic = new Vector<String>();
		for (int i = 0; i < tags.size(); i++) {
			if ((tags.get(i) >= 65 && tags.get(i) <= 90)
					|| (tags.get(i) >= 97 && tags.get(i) <= 122)) {
				x = tags.get(i);
				c = (char) x;
				myMap.put(tags.get(i), String.valueOf(c));
			}
		}
		for (int i = 0; i < tags.size(); i++) {
			//System.out.println("[ i ] = " + i);
			String xx = "";
			if (myMap.containsKey(tags.get(i))) {
				res = myMap.get(tags.get(i));
				//System.out.println("Current : " + res);
				// if(dic.indexOf(res)==-1)
				dic.add(res);
				finalResult += res;
				//System.out.println("finalResult : " + finalResult);

				if (i >= 1) {
					firstCharOfSecond = res.substring(0, 1);
					//System.out.println("[first char] = " + firstCharOfSecond);
					xx = myMap.get(tags.get(i - 1));
				//	System.out.println("[brfor me] = " + xx);
					xx = xx + firstCharOfSecond;
			//		System.out.println("[NEW xx] = " + xx);
					asc++;
					myMap.put(asc, xx);
		//			System.out.println("letter : " + xx + "  asc : " + asc);
					dic.add(xx);
				}

			} else {
				 //String tmp = "@@@@";
				firstCharOfSecond = "@";
				//System.out.println("[first char] = " + firstCharOfSecond);
				xx = myMap.get(tags.get(i - 1));
				String w = xx + firstCharOfSecond;
				String r = xx + w.substring(0, 1);
				finalResult += r;
				String newstr = myMap.get(tags.get(i - 1));
				String e = newstr + r.substring(0, 1);

				 
				asc++;
				myMap.put(asc, e);

			}
			//System.out.println("**********************************************************");
		}
	//	System.out.println("MAP = " + myMap.toString());
		return finalResult;
	}

}
