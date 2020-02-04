/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.thesymmetrypodcast.service;

import bl.thesymmetrypodcast.entity.ContactMessage;
import bl.thesymmetrypodcast.entity.ContactStatus;
import bl.thesymmetrypodcast.repository.ContactMessageRepository;
import bl.thesymmetrypodcast.repository.RegionRepository;
import bl.thesymmetrypodcast.requestBody.RBEditMessage;
import bl.thesymmetrypodcast.requestBody.RBNewMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Boone
 */
@Service
public class ContactMessageServiceImpl implements ContactMessageService {
    
    @Autowired
    ContactMessageRepository contactRepo;
    
    @Autowired
    RegionRepository regionRepo;
    
    public void save(ContactMessage message) {
        contactRepo.save(message);
    }
    
    public List<ContactMessage> getAllMessages() {
        return contactRepo.findAll();
    }
    
    public ContactMessage getMessageById(int messageId) {
        Optional<ContactMessage> messageOpt = contactRepo.findById(messageId);
        return messageOpt.get();
    }
    
    public List<ContactMessage> getMessagesByStatus(int contactStatusId) {
        switch (contactStatusId) {
            case 1:
                return contactRepo.findByStatus1();
            case 2:
                return contactRepo.findByStatus2();
            default:
                return contactRepo.findByStatus3();
        }  
    }
    
    public boolean validateNewMessageRB(RBNewMessage message) {
        //create return boolean
        boolean isMessageValid = true;

        //validate length of name
        String name = message.getRbName();
        if ((name.length() > 50) || (name.length() < 2)) {
            isMessageValid = false;
        }
        
        //validate length of email and presence of "@"
        String email = message.getRbEmail();
        if ((email.length() > 50) || (email.length() < 2)) {
            isMessageValid = false;
        }
        if (!email.contains("@")) {
            isMessageValid = false;
        }
        
        //validate message length
        String messageText = message.getRbMessageText();
        if ((messageText.length() > 5000) || (messageText.length() < 2)) {
            isMessageValid = false;
        }
        
        //validate regionId
        int regionId = message.getRbRegionId();
        boolean isRegionValid = regionRepo.existsById(regionId);
        if (isRegionValid == false) {
            isMessageValid = false;
        }
        
        //return final assessment
        return isMessageValid;
    }
    
    public boolean validateEditMessageRB(RBEditMessage message) {
        //create return boolean
        boolean isMessageValid = true;

        //validate message exists
        int messageId = message.getContactId();
        Optional<ContactMessage> testMessageOpt = contactRepo.findById(messageId);
        if (testMessageOpt == null) {
            isMessageValid = false;
        }
        
        //validate notes length
        String messageNotes = message.getRbNotes();
        if (messageNotes.length() > 5000) {
            isMessageValid = false;
        }
        
        //return final assessment
        return isMessageValid;
        
    }
}
