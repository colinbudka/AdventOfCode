package adventOfCodeDay1;
public class GardenMap {
	public long drange;
	public long srange;
	public long length;
	public GardenMap() {
		drange=-1;
		srange=-1;
		length=-1;
	}
	public GardenMap(String s) {
		long[] output = new long[3];
		int index=0;
		int numstart = 0;
		int numfinish=0;
		for (int i=0; i<s.length()&&index<=2; i+=1) {
			if(s.charAt(i)<='9'&&s.charAt(i)>='0') {
				numstart=i;
				for(int j=i; j<s.length()&&s.charAt(j)<='9'&&s.charAt(j)>='0'; j+=1) {
					numfinish=j;
					i=j;
				}
				output[index]=Long.parseLong(s.substring(numstart,numfinish+1));
				index+=1;
			}
		}
		drange=output[0];
		srange=output[1];
		length=output[2];
	}
	public long contains(long i) {
		if(i>=srange&&i<srange+length) {
			return (long)(i+drange-srange);
		}
		else if(drange==-1) {
			return -2;
		}
		else {
			return -1;
		}
	}
}
