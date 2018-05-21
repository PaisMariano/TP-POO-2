package models;

import java.math.BigDecimal;

public class TextMessageBalanceNotifier implements BalanceNotifier {

	@Override
	public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance) {
		//No lo tenemos que implementarlo.
	}

}
