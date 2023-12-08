package adventofcode23;
import java.io.*;
import java.util.*;

public class Day234 {
	public static int findChar (String s, char c, int start, int end) {
		for (int i=start;i<=end;i+=1) {
			if(s.charAt(i)==c) {
				return i;
			}
		}
		return -1;
	}
	public static int checkWinners(String s) {
		int total=0;
		int colon=findChar(s,':',0,s.length());
		int vertbar=findChar(s,'|',colon,s.length());
		ArrayList<String> winners = new ArrayList<String>();
		int numstart=0;
		int numfinish=0;
		for (int i=colon; i<=vertbar; i+=1) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				numstart=i;
				for(int j=i; j<=vertbar&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				winners.add(s.substring(numstart,numfinish+1));
			}
		}
		for (int i=vertbar; i<s.length(); i+=1) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				numstart=i;
				for(int j=i; j<s.length()&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				if(winners.contains(s.substring(numstart,numfinish+1))){
					total+=1;
				}
			}
		}
		return  (int)(Math.pow(2, total-1));
	}
	
	public static void main(String[] args) {
		try {
			String file = "C:\\Users\\ColinBudka\\Advent of Code\\23Day4.txt";
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			int total = 0;
			while (s!=null) {
				total+=checkWinners(s);
				s=br.readLine();
			}
			System.out.println(total);
			br.close();
		}
		catch(Exception e) {
			System.out.println("Nice try bozo:"+e);
		}
	}

}
