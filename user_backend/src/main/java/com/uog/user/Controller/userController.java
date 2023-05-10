package com.uog.user.Controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uog.user.Model.User;
import com.uog.user.Repository.userRepository;



@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {
	@Autowired
	private userRepository userrepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAll() throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		String rtn = "";
		List<User> user = userrepository.findAll();
		rtn = mapper.writeValueAsString(user);
		return rtn;
	}
	
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insert(@RequestBody String data) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(data);
		
		String rtn = null;
		
		String err = "Value or name is not given or its null, Please Retry!";
		User user = new User();
	
		
		if ((jsonObj.has("first_NAME") && !jsonObj.isNull("first_NAME") )) {
			
			user.setFIRST_NAME(jsonObj.getString("first_NAME"));
		}
		else {
			return err;
		}
		if ((jsonObj.has("last_NAME") && !jsonObj.isNull("last_NAME") )) {
			
			user.setLAST_NAME(jsonObj.getString("last_NAME"));
		}
		else {
			return err;
		}
		if ((jsonObj.has("email") && !jsonObj.isNull("email") )) {
			
			user.setEMAIL(jsonObj.getString("email"));
		}
		else {
			return err;
		}
			
		
		
		user = userrepository.saveAndFlush(user);
		
		rtn = mapper.writeValueAsString(user);
		return rtn;
	}
	
	
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String update(@RequestBody String data, @PathVariable Long id) throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObj = new JSONObject(data);
		
		String rtn = null;
		User user = userrepository.findOne(id);
		
		
		if ((jsonObj.has("first_NAME") && !jsonObj.isNull("first_NAME") )) {
			
			user.setFIRST_NAME(jsonObj.getString("first_NAME"));
		}
		if ((jsonObj.has("last_NAME") && !jsonObj.isNull("last_NAME") )) {
			
			user.setLAST_NAME(jsonObj.getString("last_NAME"));
		}
		if ((jsonObj.has("email") && !jsonObj.isNull("email") )) {
	
	user.setEMAIL(jsonObj.getString("email"));
		}
	
		
			
			
		
		user = userrepository.saveAndFlush(user);
		rtn = mapper.writeValueAsString(user);
		
		
		return rtn;
		
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) throws JsonProcessingException {
		
		
		userrepository.delete(id);
		
	}
	
	@RequestMapping(value = "/delete/all", method = RequestMethod.DELETE)
	public void deleteall() throws JsonProcessingException {
		
		
		userrepository.deleteAll();
		
	}

}
