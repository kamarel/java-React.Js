package com.ecomApp.Ecom.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser(){
        return userRepository.findAll();
    }


    public void createNewUser(User user) {
        userRepository.save(user);
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }





    public User updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).get();

        user1.setEmail(user.getEmail());
        user1.setCountry(user.getCountry());
        user1.setZipCode(user.getZipCode());
        user1.setCity(user.getCity());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAddress(user.getAddress());
        user1.setAdmin(user.isAdmin());

        userRepository.save(user1);

        return user;
    }
}
