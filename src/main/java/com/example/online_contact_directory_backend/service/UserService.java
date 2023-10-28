package com.example.online_contact_directory_backend.service;

import com.example.online_contact_directory_backend.dto.ContactDto;
import com.example.online_contact_directory_backend.dto.UserDto;
import com.example.online_contact_directory_backend.entity.User;

import java.util.List;

public interface UserService {
    void signup(UserDto userDto);

    User login(String email, String password);

    void saveContact(ContactDto contactDto, int userId);

    List<ContactDto> getAllContact(int userId);

    void deleteContact(int contactId);

    void deleteContactBySpecificFields(String contactName, String contactNumber);

    void deleteContactUsingObj(ContactDto contactDto);
}
