package bneijt.guesswhat;



import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class GuessWhatTest {
	
	private GuessWhat controller;
	private final SecretNumberRespository repository = mock(SecretNumberRespository.class);
	
	@Before
	public void initializeController()
	{
		controller = new GuessWhat(repository );
	}
	
	@Test
	public void shouldRememberSecret() throws Exception {
		
		
		
		LongSecretNumber secret6 = new LongSecretNumber(6);
		given(repository.rememberSecret(eq("willem"), isA(SecretNumber.class))).willReturn(secret6);
		
		BindingResult bindingResult = new MapBindingResult(new HashMap<String, String>(), "bindingString");
		controller.set(new SecretNumberForm("willem", 6), bindingResult );
		verify(repository).rememberSecret(eq("willem"), eq(secret6));
		
	}
}
