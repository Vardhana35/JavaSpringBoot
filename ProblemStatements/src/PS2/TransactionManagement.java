package PS2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionManagement {

	public static void main(String[] args) {
		
		/*Set<Transaction> s = new TreeSet<>(new TransactionPriorityComparator());
		s.add(new Transaction("TXN001", "RTGS", 300000.0, 1678886400000L));
		s.add(new Transaction("TXN002", "RTGS", 300000.0, 1678886400001L));
		s.add(new Transaction("TXN003", "RTGS", 300000.0, 1678886400002L));
		
		s.add(new Transaction("A", "NEFT", 50000.0, 100L));
		s.add(new Transaction("B", "IMPS", 10000.0, 100L));
		s.add(new Transaction("C", "RTGS", 250000.0, 100L));
		s.add(new Transaction("D", "NEFT", 75000.0, 100L));
		s.add(new Transaction("E", "IMPS", 10000.0, 101L));
		s.add(new Transaction("F", "RTGS", 250000.0, 101L));*/
		
		
		List<Transaction> l=new ArrayList<>();
		
		//same priority, same amount -> timestamp in ascending order
		l.add(new Transaction("TXN001", "RTGS", 300000.0, 1678886400000L));
		l.add(new Transaction("TXN002", "RTGS", 300000.0, 1678886400001L));
		l.add(new Transaction("TXN003", "RTGS", 300000.0, 1678886400002L));
		
		//mixed priorities -> based on priority
		l.add(new Transaction("A", "NEFT", 50000.0, 100L));
		l.add(new Transaction("B", "IMPS", 10000.0, 100L));
		l.add(new Transaction("C", "RTGS", 250000.0, 100L));
		l.add(new Transaction("D", "NEFT", 75000.0, 100L));
		l.add(new Transaction("E", "IMPS", 10000.0, 101L));
		l.add(new Transaction("F", "RTGS", 250000.0, 101L));
		
		System.out.println("unsorted list: ");
		for (Transaction transaction : l) {
			System.out.println(transaction);
		}
		System.out.println("----------------------------------------------------------------");
		
		Collections.sort(l,new TransactionPriorityComparator());
		
		System.out.println("sorted list: ");
		for (Transaction transaction : l) {
			System.out.println(transaction);
		}
		
	}

}
