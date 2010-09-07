package bneijt.guesswhat;

import java.util.HashMap;
import java.util.Map;

public class MemorySecretNumberRepository implements SecretNumberRespository {
	
	private final Map<String, SecretNumber> secrets;
	
	
	public MemorySecretNumberRepository() {
		this.secrets = new HashMap<String, SecretNumber>();
	}

	@Override
	public SecretNumber secretOf(String name) {
		return secrets.get(name);
	}

	@Override
	public SecretNumber rememberSecret(String name, SecretNumber secretNumber) {
		secrets.put(name, secretNumber);
		return secretNumber;
	}

}
