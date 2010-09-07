package bneijt.guesswhat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemorySecretNumberRepository implements SecretNumberRespository {
	
	private final Map<String, LongSecretNumber> secrets;
	
	public MemorySecretNumberRepository() {
		this.secrets = new HashMap<String, LongSecretNumber>();
	}

	@Override
	public SecretNumber secretOf(String name) {
		if(!secrets.containsKey(name))
			return new ImpossiblySecretNumber();
		return this.secrets.get(name);
	}

	@Override
	public SecretNumber rememberSecret(String name, LongSecretNumber secretNumber) {
		this.secrets.put(name, secretNumber);
		return secretNumber;
	}

}
