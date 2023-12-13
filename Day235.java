package adventOfCodeDay1;
import java.io.*;
import java.util.*;
public class Day235 {

	public static SeedRange[] parseSeeds(String s) {
		int seednum=0;
		int numstart=0;
		int numfinish=0;
		long start;
		long range;
		SeedRange[] seeds = new SeedRange[500];
		for (int i=0; i<s.length(); i+=1) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				numstart=i;
				for(int j=i; j<s.length()&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				start=Long.parseLong(s.substring(numstart,numfinish+1));
				i+=2;
				numstart=i;
				for(int j=i; j<s.length()&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				range=Long.parseLong(s.substring(numstart,numfinish+1));
				seeds[seednum]= new SeedRange(start,range);
				seednum+=1;	
				System.out.println("I am a sheep hurr durr");
			}
		}
		return seeds;
	}
	public static long readMap(GardenMap[] gm, long input) {
		long output=0;
		for(int i=0;output!=-2&&gm[i]!=null;i+=1) {
			output=gm[i].contains(input);
			if(output>=0) {
				return output;
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		try {
			String file = "C:\\Users\\colin\\eclipse-workspace\\adventOfCodeDay1\\23Day4.txt";
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			GardenMap [] ss = new GardenMap[50];
			GardenMap [] sf = new GardenMap[50];
			GardenMap [] fw = new GardenMap[50];
			GardenMap [] wl = new GardenMap[50];
			GardenMap [] lt = new GardenMap[50];
			GardenMap [] th = new GardenMap[50];
			GardenMap [] hl = new GardenMap[50];
			SeedRange[] seeds = parseSeeds(s);
			s=br.readLine();
			s=br.readLine();
			s=br.readLine();
			int index=0;
			System.out.println("u made it");
			while(s.length()>0) {
				ss[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s.length()>0) {
				sf[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s.length()>0) {
				fw[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s.length()>0) {
				wl[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s.length()>0) {
				lt[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s.length()>0) {
				th[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			s=br.readLine();
			s=br.readLine();
			index=0;
			while(s!=null) {
				hl[index]=new GardenMap(s);
				s=br.readLine();
				index+=1;
			}
			br.close();
			int i=0;
			long current=0;
			long minimum= Long.MAX_VALUE;
			long start;
			long range;
			while(seeds[i]!=null) {
				start=seeds[i].start();
				range=seeds[i].range();
				for(long j=start;j<start+range;j+=1) {
					current=j;
					current=readMap(ss,current);
					current=readMap(sf,current);
					current=readMap(fw,current);
					current=readMap(wl,current);
					current=readMap(lt,current);
					current=readMap(th,current);
					current=readMap(hl,current);
					if(current<minimum) {
						minimum=current;
					}
					System.out.println(current);
				}
				i+=1;
			}
			System.out.println(minimum);
		}
		catch(Exception e) {
			System.out.println("Nice try bozo:"+e);
		}
	}
}