package bneijt.guesswhat;


import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GuessWhatTest {
	
	private GuessWhat controller;
	private final SecretNumberRespository repository = mock(SecretNumberRespository.class);
	private final HttpServletResponse response = mock(HttpServletResponse.class);
	
	@Before
	public void initializeController()
	{
		controller = new GuessWhat(repository );
	}
	
	@Test
	public void shouldRememberSecret() throws Exception {
		//given(repository.rememberSecret(eq("willem"), isA(SecretNumber.class))).willReturn(isA(SecretNumber.class));
		//controller.set(new SecretNumberForm("willem", 120), response);
		//verify(repository).rememberSecret(eq("willem"), isA(LongSecretNumber.class));
		
	}
}
