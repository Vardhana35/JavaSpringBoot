package PS2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	private String transactionId;
	private String transactionType;
	private double amount;
	private long timestamp;
	
	@Override
	public String toString() {
	    return "Id:" + transactionId 
	         + ", Type:" + transactionType 
	         + ", Amount:" + amount 
	         + ", Time:" + timestamp;
	}

}
