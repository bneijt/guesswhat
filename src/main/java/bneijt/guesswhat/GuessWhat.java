package bneijt.guesswhat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GuessWhat {
	
	private SecretNumber secret;

	@ResponseBody
	@RequestMapping(value = "/guesswhat/{guess}")
	public String guess(@PathVariable long guess) {
		return this.secret.guess(guess) ? "Right!" : "Wrong :(";
	}

	@ResponseBody
	@RequestMapping(value = "/setwhat/{value}")
	public String set(@PathVariable long value) {
		this.secret = new SecretNumber(value);
		return "Secret number set to: " + this.secret;
	}

}
