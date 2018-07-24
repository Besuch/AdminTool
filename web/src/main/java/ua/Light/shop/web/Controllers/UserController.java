package ua.Light.shop.web.Controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.Light.shop.services.UserService;
import ua.Light.shop.services.dto.UserDto;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    public final static Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserDto> findAll(){
        log.info("Find all users {}", userService.findAll());
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public @ResponseBody UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto user){
        log.info("Create user {}", user);
        userService.create(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id,@RequestBody UserDto user){
        userService.update(id, user);

    }
}
