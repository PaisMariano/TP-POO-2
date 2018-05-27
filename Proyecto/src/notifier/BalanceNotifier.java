package notifier;

import java.math.BigDecimal;

import usuarios.User;

public interface BalanceNotifier {
	
	public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance);

}
