package PS2;

import java.util.Comparator;

public class TransactionPriorityComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction o1, Transaction o2) {

		// Primary: type priority (desc)
		int p1 = priority(o1.getTransactionType());
		int p2 = priority(o2.getTransactionType());
		int byType = Integer.compare(p2, p1); // Descending priority
		if (byType != 0)
			return byType;

		// Secondary: amount (desc)
		int byAmount = Double.compare(o2.getAmount(), o1.getAmount());
		if (byAmount != 0)
			return byAmount;

		// Tertiary: timestamp (asc)
		int byTime = Long.compare(o1.getTimestamp(), o2.getTimestamp());
		if (byTime != 0)
			return byTime;
		return 0;
	}

	private int priority(String type) {
		if (type == null)
			return 0;
		switch (type.toUpperCase()) {
		case "RTGS":
			return 3;
		case "IMPS":
			return 2;
		case "NEFT":
			return 1;
		}
		return 0;
	}

}
