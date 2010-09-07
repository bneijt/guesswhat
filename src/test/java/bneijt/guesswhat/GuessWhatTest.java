package bneijt.guesswhat;


import org.junit.Before;
import org.junit.Test;

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
		//given(repository.rememberSecret(eq("willem"), isA(SecretNumber.class))).willReturn(isA(SecretNumber.class));
		controller.set("willem", 120);
		verify(repository).rememberSecret(eq("willem"), isA(SecretNumber.class));
		
	}
}
