package adventOfCodeDay1;

public class BoatRace {
	public long time;
	public long distance;
	public BoatRace(long i, long j) {
		time = i;
		distance = j;
	}
	public int winnercount() {
		int a = 1;
		double b = time;
		double c = distance;
		if(b*b-4*a*c>=0) {
			double max = (b + (Math.sqrt(b*b-4*c)))/2;
			double min = (b - (Math.sqrt(b*b-4*c)))/2;
			if (max>=min) {
				if (max>0) {
					if(min>0) {
						return((int)(max-.00001)-(int)Math.ceil(min+.00001))+1;
					}
					else {
						return (int)(max-.00001);
					}
				}
				else {
					return 0;
				}
			}
			else {
				if (min>0) {
					if (max>0) {
						return((int)(min-.00001)-(int)Math.ceil(max+.00001))+1;
					}
					else {
						return (int)(min-.00001);
					}
				}
				else {
					return 0;
				}
			}
		}
		else {
			return 0;
		}
	}
}
