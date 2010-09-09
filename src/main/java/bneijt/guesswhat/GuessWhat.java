package bneijt.guesswhat;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@Controller
public class GuessWhat {

	private final SecretNumberRespository secrets;

	@Autowired
	public GuessWhat(SecretNumberRespository secrets) {
		Assert.notNull(secrets, "Need a SecretNumberRepository");
		this.secrets = secrets;
	}

	@RequestMapping(value = "/test")
	public ModelAndView guess() {
		Map<String, String> model = new HashMap<String, String>();
		model.put("firstname", "Peter");
		model.put("secondname", "Schmitt");

		return new ModelAndView("jsonView", model);
	}

	@ResponseBody
	@RequestMapping(value = "/guess/{name}/{guess}")
	public String guess(@PathVariable String name, @PathVariable long guess) {
		// Bare metal approach to json
		SecretNumber secret = secrets.secretOf(name);
		Gson gson = new Gson();
		return "[" + gson.toJson(secret.guess(guess)) + "]";
	}

	@ResponseBody
	@RequestMapping(value = "/people/list")
	public String peopleList() {
		// Bare metal approach to html. Hackers, please inject your content
		// here!
		String c = "<html><body><ul>";
		for (String person : secrets.people()) {
			c += "<li><span classname=\"person\">"
					+ person
					+ "</span>: <input type=\"text\" class=\"guessfield\" /></li>";
		}
		c += "</ul></body></html>";
		return c;
	}

	@RequestMapping(value = "/set/")
	public ModelAndView set(@Valid SecretNumberForm secretForm,
			BindingResult result) {
		ModelAndView mav = new ModelAndView("setform");
		mav.addObject(secretForm);
		if (result.hasErrors()) {
			return mav;
		}
		SecretNumber secret = this.secrets.rememberSecret(secretForm.getName(),
				new LongSecretNumber(secretForm.getNumber()));
		// model.put("secret", secret);
		// return "result";
		// Gson gson = new Gson();
		// return gson.toJson(secret);
		mav.addObject(secret);
		return mav;

		// return "form";
		// TODO Set response content type!
	}

}
