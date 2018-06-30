package notifier;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import eventoDeportivo.EventoDeportivo;
import oponentes.Deportista;
import oponentes.Equipo;

public class TestEmailBalanceNotifier {
	
	private EmailBalanceNotifier notifier;
	private String email;
	private Integer month;
	private BigDecimal decimal;
	
	@Before
	public void setUp() throws Exception {
		
		notifier = new EmailBalanceNotifier();
		
		email   = "asd@asd.com";
		month   = new Integer(1);
		decimal = new BigDecimal(1);
		
	}

	@Test
	public void test() {
		this.notifier.emailBalance(email, month, decimal);
	}
}
