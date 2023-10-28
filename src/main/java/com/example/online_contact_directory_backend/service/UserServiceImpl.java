package com.example.online_contact_directory_backend.service;


import com.example.online_contact_directory_backend.dto.ContactDto;
import com.example.online_contact_directory_backend.dto.UserDto;
import com.example.online_contact_directory_backend.entity.Contact;
import com.example.online_contact_directory_backend.entity.User;
import com.example.online_contact_directory_backend.repository.ContactRepository;
import com.example.online_contact_directory_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ContactRepository contactRepository;

    public void signup(UserDto userDto)
    {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setMobileNo(userDto.getMobileNo());

        userRepository.save(user);
    }
    public User login(String email , String password)
    {
        User user= userRepository.findBySpecificFields(email,password);
        return user;
    }
    public  void saveContact(ContactDto contactDto, int userId)
    {
        Contact contact = new Contact();
        contact.setContactName(contactDto.getContactName());
        contact.setContactNumber(contactDto.getContactNumber());
        contact.setUserId(userId);
        contactRepository.save(contact);
    }
    public List<ContactDto> getAllContact(int userId)
    {
       List<Contact> contactList=  contactRepository.findByUserId(userId);
       List<ContactDto> contactDtoList = new ArrayList<>();
        for(Contact contact : contactList)
        {
            ContactDto contactDto = new ContactDto();
            contactDto.setContactName(contact.getContactName());
            contactDto.setContactNumber(contact.getContactNumber());
            contactDtoList.add(contactDto);
        }
        return contactDtoList;
    }
    public void deleteContact(int contactId)
    {
         contactRepository.deleteById(contactId);
    }
    public void deleteContactBySpecificFields(String contactName, String contactNumber)
    {
        contactRepository.deleteBySpecificFields(contactName,contactNumber);
    }
    public void deleteContactUsingObj(ContactDto contactDto)
    {

        contactRepository.deleteContactUsingObj(contactDto.getContactName(),contactDto.getContactNumber());
    }
}
