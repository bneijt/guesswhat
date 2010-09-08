package bneijt.guesswhat;

import java.util.Set;

public interface SecretNumberRespository {

	SecretNumber secretOf(String name);

	SecretNumber rememberSecret(String name, LongSecretNumber secretNumber);

	Set<String> people();

}
