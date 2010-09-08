package bneijt.guesswhat;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


import org.junit.Test;

public class SecretNumberTest {
	
	@Test
	public void shouldVerifyCorrectNumber() throws Exception {
		// Make secret number (given)
		LongSecretNumber secret = new LongSecretNumber(10);
		// Try correct secret number (when)
		boolean guessed = secret.guess(10);
		// Assert they are verified (verify)
		assertThat("It should be possible to guess the right number", guessed,
				is(true));
	}
	
	@Test
	public void shouldNotVerifyWrongNumber() throws Exception {
		LongSecretNumber secret = new LongSecretNumber(1);
		boolean guessed = secret.guess(2 + Math.round(100*Math.random()));
		assertThat("It should not be possible to guess the wrong number", guessed, is(false));
	}

	
}
