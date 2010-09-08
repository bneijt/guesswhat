package bneijt.guesswhat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
public class GuessWhat {
	
	private final SecretNumberRespository secrets;
	
	@Autowired
	public GuessWhat(SecretNumberRespository secrets) {
		Assert.notNull(secrets, "Need a SecretNumberRepository");
		this.secrets = secrets;
	}


	@ResponseBody
	@RequestMapping(value = "/guess/{name}/{guess}")
	public String guess(@PathVariable String name, @PathVariable long guess) {
		//Bare metal approach to json
		SecretNumber secret = secrets.secretOf(name);
		Gson gson = new Gson();
		return "[" + gson.toJson(secret.guess(guess)) + "]";
	}
	
	@ResponseBody
	@RequestMapping(value = "/people/list")
	public String peopleList() {
		//Bare metal approach to html. Hackers, please inject your content here!
		String c = "<html><body><ul>";
		for(String person : secrets.people())
		{
			c += "<li><span classname=\"person\">" + person + "</span>: <input type=\"text\" class=\"guessfield\" /></li>";
		}
		c += "</ul></body></html>";
		return c;
	}

	@ResponseBody
	@RequestMapping(value = "/set/{name}/{value}")
	public String set(@PathVariable String name, @PathVariable long value) {
		SecretNumber secret = this.secrets.rememberSecret(name, new LongSecretNumber(value));
		
		Gson gson = new Gson();
		return gson.toJson(secret);//TODO Set response content type!
	}

}
