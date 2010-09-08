package bneijt.guesswhat;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SecretNumberRepositoryTest {
	@Test
	public void shouldListContainedPeople() throws Exception {
		SecretNumberRespository s = new MemorySecretNumberRepository();
		s.rememberSecret("willem", new LongSecretNumber(12));
		assertThat(s.people().size(), is(1));
		s.rememberSecret("willem", new LongSecretNumber(12));
		assertThat(s.people().size(), is(1));
		s.rememberSecret("henk", new LongSecretNumber(12));
		assertThat(s.people().size(), is(2));
		assertThat(s.people(), hasItem("henk"));
		
	}
}
