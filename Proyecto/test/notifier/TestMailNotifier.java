package notifier;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import usuarios.User;

public class TestMailNotifier {
	
	private MailNotifier mNotifier;
	private EmailBalanceNotifier eNotifier;
	private EmailBalanceNotifier mockNotifier;
	private User user;
	private Integer month;
	private BigDecimal decimal;
	
	
	@Before
	public void setUp() throws Exception {
		
		user      = new User("asd@asd.com");
		month     = new Integer(1);
		decimal   = new BigDecimal(1);		
		eNotifier = new EmailBalanceNotifier();
		mNotifier = new MailNotifier(eNotifier);
		mockNotifier = mock(EmailBalanceNotifier.class);
		
	}

	@Test
	public void testSetNotifier() {
		
		mNotifier.setEmailNotifier(eNotifier);
		
		assertEquals(mNotifier.getEmailNotifier(), eNotifier);		
	}
	
	@Test
	public void test() {
		
		this.mNotifier.setEmailNotifier(mockNotifier);
		this.mNotifier.notifyBalance(user, month, decimal);
		verify(mockNotifier, times(1)).emailBalance(user.getMail(), month, decimal);
	}
 
}
