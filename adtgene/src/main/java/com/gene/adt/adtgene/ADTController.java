package com.gene.adt.adtgene;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ADTController {

    @RequestMapping(value = "/adtlogin", method = RequestMethod.GET)
    public Map<String, String> getResource() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("resource", "here is some resource");
        return resource;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String logout(HttpSession session,HttpServletRequest req) {
        session.invalidate();
        HttpSession sessions = req.getSession(false);
        if(session==null || !req.isRequestedSessionIdValid() )
        {
            System.out.println("comes here when session is invalid");

        }else {
        	System.out.println("comes here when session not invalid");
        }
		return "200";
    }
    
    @GetMapping(value="/test")
    public String test() {
    	return "yeah its Sounds Good";
    }
}
