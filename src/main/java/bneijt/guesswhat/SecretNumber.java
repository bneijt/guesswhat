package bneijt.guesswhat;

public class SecretNumber {

	private final long secret;

	public SecretNumber(long secret) {
		this.secret = secret;
	}

	public boolean guess(long guess) {
		return guess == secret;
	}

}
