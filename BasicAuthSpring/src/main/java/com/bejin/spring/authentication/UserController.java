package com.bejin.spring.authentication;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

 @Autowired
 List<User> userList;
  
  @Cacheable(value = "users", key = "#userId")
  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public User getUser(@PathVariable String userId) {
	  LOG.error("Engtered controller");
    return userList.stream().filter(x-> x.getName().equals(userId)).findFirst().get();
    		
  }
}
