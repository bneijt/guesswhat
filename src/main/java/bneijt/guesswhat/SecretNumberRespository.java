package bneijt.guesswhat;

public interface SecretNumberRespository {

	SecretNumber secretOf(String name);

	SecretNumber rememberSecret(String name, SecretNumber secretNumber);

}
