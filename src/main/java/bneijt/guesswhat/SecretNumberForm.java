package bneijt.guesswhat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SecretNumberForm {
	public SecretNumberForm() {
	}
	public SecretNumberForm(String name, long number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@NotNull
    @Size(max=64)
	private String name;
	
	@NotNull
	@Min(0)
	@Max(100)
	private long number;

	
	
}
