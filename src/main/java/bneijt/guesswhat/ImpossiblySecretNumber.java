package bneijt.guesswhat;
/** A secret number which is impossible to guess
 * 
 * @author bneijt
 *
 */
public class ImpossiblySecretNumber implements SecretNumber {
	@Override
	public boolean guess(long guess) {
		return false;
	}

}
