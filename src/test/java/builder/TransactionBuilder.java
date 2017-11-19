package builder;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.transactions.domain.Transaction;
import com.transactions.util.TimeUtil;

public class TransactionBuilder {
	
	public static List<Transaction> generateTransactions(int quantity){
		Long now = TimeUtil.nowInMillis();
		List<Transaction> list = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			list.add(getTransaction(Double.valueOf(10 * (i+1)), now + (1000 * (i))));
		}
		return list;
	}
	
	public static Transaction getTransaction(Double amount, Long timestamp) {
		return new Transaction(amount, timestamp);
	}
	
	public static String getTransactionInJson(Double amount, Long timestamp) {
		return toJson(new Transaction(amount, timestamp));
	}
	
	public static String toJson(Transaction transaction) {
		Gson gson = new Gson();
	    return gson.toJson(transaction);
	}
}
