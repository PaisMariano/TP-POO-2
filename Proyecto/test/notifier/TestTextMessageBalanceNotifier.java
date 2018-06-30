package notifier;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import usuarios.User;

public class TestTextMessageBalanceNotifier {

	private TextMessageBalanceNotifier notifier;
	private User user;
	private Integer month;
	private BigDecimal decimal;
	
	@Before
	public void setUp() throws Exception {
		
		notifier = new TextMessageBalanceNotifier();
		
		user    = new User("Pedro");
		month   = new Integer(1);
		decimal = new BigDecimal(1);
		
	}

	@Test
	public void test() {
		
		this.notifier.notifyBalance(user, month, decimal);
	}
}

