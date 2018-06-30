package notifier;

import java.math.BigDecimal;

import usuarios.User;

public class MailNotifier implements BalanceNotifier {
	private EmailBalanceNotifier emailNotifier;
	
	public MailNotifier(EmailBalanceNotifier _emailNotifier){
		this.setEmailNotifier(_emailNotifier);
	}
	
		public void setEmailNotifier(EmailBalanceNotifier _emailNotifier){
			emailNotifier = _emailNotifier;
		}
		
		public EmailBalanceNotifier getEmailNotifier(){
			return this.emailNotifier;
		}
	
		@Override
		public void notifyBalance(User user, Integer month, BigDecimal monthlyBalance) {
			emailNotifier.emailBalance(user.getMail(), month, monthlyBalance);
		} 

}
