package adventOfCodeDay1;

import java.io.*;

public class Day236 {
	public static long[] parseInts(String s) {
		int num=0;
		int numstart=0;
		int numfinish=0;
		s=s.replace(" ","");
		long[] ints = new long[500];
		for (int i=0; i<s.length(); i+=1) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				numstart=i;
				for(int j=i; j<s.length()&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				ints[num]=Long.parseLong(s.substring(numstart,numfinish+1));
				num+=1;
			}
		}
		return ints;
	}
	public static void main(String args[]) {
		File input = new File("C:\\Users\\colin\\eclipse-workspace\\adventOfCodeDay1\\23Day6.txt");
		try {
			BufferedReader in = new BufferedReader(new FileReader(input));
			long[] times = parseInts(in.readLine());
			long[] distances = parseInts(in.readLine());
			in.close();
			BoatRace[] races = new BoatRace[500];
			for (int i=0;times[i]!=0&&i<500;i+=1) {
				races[i]= new BoatRace(times[i],distances[i]);
			}
			int total=1;
			for (int j=0;races[j]!=null;j+=1) {
				total=total*races[j].winnercount();
			}
			System.out.println(total);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
