package com.example.online_contact_directory_backend.controller;

import com.example.online_contact_directory_backend.dto.ContactDto;
import com.example.online_contact_directory_backend.dto.UserDto;
import com.example.online_contact_directory_backend.entity.User;
import com.example.online_contact_directory_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserDto userDto)
    {
        userService.signup(userDto);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<?> login(@PathVariable String email, @PathVariable String password)
    {
        User user =  userService.login(email,password);
        if(user!=null)
        return ResponseEntity.ok(user);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
    @PostMapping("/addContact/{userId}")
    public void saveContact(@RequestBody ContactDto contactDto, @PathVariable int userId)
    {
        userService.saveContact(contactDto,userId);
    }
    @GetMapping("/getAllContact/{userId}")
    public List<ContactDto> getAllContact(@PathVariable int userId)
    {
       return userService.getAllContact(userId);
    }

    @GetMapping("/server-check")
    public ResponseEntity<?> testMethod()
    {
        return ResponseEntity.ok("Server Is Up");
    }
    @DeleteMapping("/deleteContact/{contactId}")
    public void deleteContact(@PathVariable int contactId)
    {
         userService.deleteContact(contactId);
    }
    @DeleteMapping("/deleteContactBy/{contactName}/{contactNumber}")
    public void deleteContactBySpecificFields(@PathVariable String contactName,@PathVariable String contactNumber)
    {
        userService.deleteContactBySpecificFields(contactName,contactNumber);
    }
    @PostMapping("/deleteContactUsingObj")
    public void deleteContactUsingObj(@RequestBody ContactDto contactDto)
    {
        userService.deleteContactUsingObj(contactDto);
    }
}
