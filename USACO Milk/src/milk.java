import java.io.*;
import java.util.*;

/*
 ID:shrey.c1
 LANG:JAVA
 TASK:milk
 */
public class milk {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int targetAmount = Integer.parseInt(st.nextToken());
		int maxFarmers = Integer.parseInt(st.nextToken());
		int cost = 0;
		//int units = n;
		//Map<Integer,Integer> farmers = new TreeMap<Integer,Integer>();
		String ln;
		
		List<Farmer> farmers = new ArrayList<Farmer>();
        for(int i=0; i<maxFarmers; i++) {
        	st = new StringTokenizer(f.readLine());
            farmers.add(new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(farmers, new Comparator<Farmer>() {
            @Override
            public int compare(Farmer arg0, Farmer arg1) {
                return arg0.getPrice() - arg1.getPrice();
            }
        });
        int amount = 0;
        int price = 0;
        for(Farmer farm : farmers) {
            if (farm.getAmount() + amount >= targetAmount) {
                int diff = (targetAmount - amount);
                price += diff*farm.getPrice();
                amount += diff;
                break;
            } else {
                amount += farm.getAmount();
                price += farm.getPrice()*farm.getAmount();
            }
        }
        out.println(price);
        out.close();
		/*while((ln = f.readLine()) != null){
			st = new StringTokenizer(ln);
			farmers.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		loop : for(Map.Entry<Integer, Integer> map : farmers.entrySet()){
			if(units >= map.getValue()){
			System.out.println(farmers.size());
			units -= map.getValue();
			cost += map.getValue() * map.getKey();
			}
			else{
				cost += units * map.getKey();
				units = 0;
				break loop;
			}
		}
		out.println(cost);
		out.close();*/
	}
	
	 private static class Farmer {
	        private final int amount;
	        private final int price;

	        public Farmer(int price, int amount) {
	            this.amount = amount;
	            this.price = price;
	        }

	        public int getAmount() {
	            return this.amount;
	        }

	        public int getPrice() {
	            return this.price;
	        }

	        public String toString() {
	            return price + "";
	        }
	    }

}
