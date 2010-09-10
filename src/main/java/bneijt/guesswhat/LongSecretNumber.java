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

	@Override
	public int hashCode() {
		return (int) secret;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LongSecretNumber other = (LongSecretNumber) obj;
		if (secret != other.secret) {
			return false;
		}
		return true;
	}

}
