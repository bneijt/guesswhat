package bneijt.guesswhat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MemorySecretNumberRepository implements SecretNumberRespository {
	
	private final Map<String, SecretNumber> secrets;
	
	public MemorySecretNumberRepository() {
		this.secrets = new HashMap<String, SecretNumber>();
	}

	@Override
	public SecretNumber secretOf(String name) {
		if(!secrets.containsKey(name))
			return new ImpossiblySecretNumber();
		return this.secrets.get(name);
	}

	@Override
	public SecretNumber rememberSecret(String name, SecretNumber secretNumber) {
		if(name.isEmpty())
			throw new IllegalArgumentException("The given name is empty.");
		this.secrets.put(name, secretNumber);
		return secretNumber;
	}

	@Override
	public Set<String> people() {
		return secrets.keySet();
	}
	
	

}
