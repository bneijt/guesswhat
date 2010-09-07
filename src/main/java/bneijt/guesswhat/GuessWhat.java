package bneijt.guesswhat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GuessWhat {
	
	private final SecretNumberRespository secrets;

	@Autowired
	public GuessWhat(SecretNumberRespository secrets) {
		Assert.notNull(secrets, "Need a SecretNumberRepository");
		this.secrets = secrets;
	}

	@ResponseBody
	@RequestMapping(value = "/aldskf/{name}/{guess}")
	public String guess(@PathVariable String name, @PathVariable long guess) {
		SecretNumber secret = secrets.secretOf(name);
		return secret.guess(guess) ? "Right!" : "Wrong :(";
	}

	@ResponseBody
	@RequestMapping(value = "/setwhat/{name}/{value}")
	public String set(@PathVariable String name, @PathVariable long value) {
		SecretNumber secret = this.secrets.rememberSecret(name, new SecretNumber(value));
		
		return "Secret number set to: " + secret;
	}

}
