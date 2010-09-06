package bneijt.guesswhat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GuessWhat {

	@RequestMapping(value = "/guesswhat/{guess}")
	public String guess(@PathVariable long guess) {
		return "Hello";
	}

}
