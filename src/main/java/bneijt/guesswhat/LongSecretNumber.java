package bneijt.guesswhat;

public class LongSecretNumber implements SecretNumber {

	private final long secret;

	public LongSecretNumber(long secret) {
		this.secret = secret;
	}

	public boolean guess(long guess) {
		return guess == secret;
	}
	public long getValue()
	{
			return secret;
	}

}
