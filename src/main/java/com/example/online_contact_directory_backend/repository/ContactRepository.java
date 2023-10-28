package com.example.online_contact_directory_backend.repository;

import com.example.online_contact_directory_backend.entity.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Transactional
    @Query(value = "select c from Contact c where c.userId=:userId")
    public List<Contact> findByUserId(int userId);

    @Modifying
    @Transactional
    @Query(value = "delete  from Contact c where c.contactName=:contactName and c.contactNumber=:contactNumber ")
    public void deleteBySpecificFields(String contactName, String contactNumber);

    @Transactional
    @Modifying
    @Query(value="delete from Contact c where c.contactName=:contactName and c.contactNumber=:contactNumber ")
    void deleteContactUsingObj(String contactName,String contactNumber);

}
