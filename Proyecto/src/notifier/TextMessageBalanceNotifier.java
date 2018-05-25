package notifier;

import java.math.BigDecimal;

import Usuarios.User;

public class TextMessageBalanceNotifier implements BalanceNotifier {

	@Override
	public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance) {
		//Don´t do nothing.
	}

}