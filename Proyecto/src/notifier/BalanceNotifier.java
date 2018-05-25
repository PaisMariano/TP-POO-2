package notifier;

import java.math.BigDecimal;

import Usuarios.User;

public interface BalanceNotifier {
	
	public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance);

}
