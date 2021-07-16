package com.example.demo.dao;

import com.example.demo.modal.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Repository("adminAuth")
public class AdminOperationImplementer implements AdminOperation {

    @Autowired
    AdminDao repo;

    @Override
    public int addAdmin(UUID uuid, AdminDetails adminDetails) {
        if (uuid == null) {
            adminDetails.setId(UUID.randomUUID().toString());;
        }

        if (repo.isUserPresent(adminDetails.getUsername()) > 0) {
            return 404;
        }

        String hashedPassword = encryptPassword(adminDetails.getPassword());
        if (hashedPassword == null) {
            return 107;
        }
        adminDetails.setPassword(hashedPassword);
        repo.save(adminDetails);
        if (repo.isUserPresent(adminDetails.getUsername()) > 0) {
            //status 200 - Successful
            return 200;
        }
        //status 107 - Failed
        return 107;
    }

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] passwordHash = messageDigest.digest(password.getBytes());
            BigInteger integer = new BigInteger(1, passwordHash);
            String hashPassword = integer.toString(16);
            while (hashPassword.length() < 32) {
                hashPassword = "0" + hashPassword;
            }
            return hashPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
