package com.example.sahamProject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.BiodataRepository;
import com.example.sahamProject.dao.UserRepository;
import com.example.sahamProject.model.MBiodata;
import com.example.sahamProject.model.MUser;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BiodataRepository biodataRepository;

    public String getValidasiEmail(String email) {

        List<MUser> listUser = this.userRepository.findByEmailAndIsDeleteFalse(email);
        for (MUser item : listUser) {
            try {
                if (item.getEmail().equals(listUser)) {
                    return "found";
                }
            } catch (Exception e) {
                continue;
            }
        }
        return "not found";
    }

    public MUser getUserByEmail(String email) {
        List<MUser> listUser = this.userRepository.findAll();
        for (MUser item : listUser) {
            if (item.getEmail().equals(listUser)) {
                return item;
            }
        }
        return new MUser();
    }

    public MUser addNewUser(MUser user) {
        try {
            MUser temp = new MUser();
            temp.setEmail(user.getEmail());
            temp.setCreatedOn(LocalDateTime.now());
            temp = this.userRepository.save(temp);

            temp.setCreatedBy(temp.getId());
            this.userRepository.save(temp);
            return temp;

        } catch (Exception e) {
            return new MUser();
        }

    }

    public String addUserData(MUser user) {
        MBiodata tempMBiodata = new MBiodata();
        MUser tempMUser = new MUser();

        tempMBiodata.setFullname(user.getMBiodataId().getFullname());
        tempMBiodata.setMobilePhone(user.getMBiodataId().getMobilePhone());
        tempMBiodata.setCreatedOn(LocalDateTime.now());

        MBiodata teMBiodata = this.biodataRepository.save(tempMBiodata);

        tempMUser.setMRole(user.getMRole());
        // tempMUser.setRole(this.userRepository.findById(user.getMRole()).orElse(null));
        tempMUser.setBiodataId(teMBiodata);

    }

}
