package bneijt.guesswhat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GuessWhat {
	@ResponseBody
	@RequestMapping(value = "/guesswhat/{guess}")
	public String guess(@PathVariable long guess) {
		return "Hello";
	}

}
