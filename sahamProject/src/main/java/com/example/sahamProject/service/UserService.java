package com.example.sahamProject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahamProject.dao.AdminRepository;
import com.example.sahamProject.dao.BiodataRepository;
import com.example.sahamProject.dao.CustomerRepository;
import com.example.sahamProject.dao.UserRepository;
import com.example.sahamProject.model.MAdmin;
import com.example.sahamProject.model.MBiodata;
import com.example.sahamProject.model.MCustomer;
import com.example.sahamProject.model.MUser;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BiodataRepository biodataRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
        tempMUser.setMBiodataId(teMBiodata);
        tempMUser.setBiodataId(teMBiodata.getId());
        tempMUser.setCreatedBy(user.getId());
        tempMUser.setCreatedOn(LocalDateTime.now());
        tempMUser.setEmail(user.getEmail());
        tempMUser.setPassword(user.getPassword());

        tempMUser = this.userRepository.save(tempMUser);
        tempMBiodata.setCreatedBy(tempMUser.getId());
        this.biodataRepository.save(tempMBiodata);

        String userRole = tempMUser.getMRole().getName();
        if (userRole.equals("ADMIN")) {
            MAdmin admin = new MAdmin();
            admin.setMBiodata(teMBiodata);
            admin.setBiodataId(teMBiodata.getId());
            admin.setIsDelete(false);
            admin.setCreatedBy(tempMUser.getId());
            admin.setCreatedOn(LocalDateTime.now());

            admin = this.adminRepository.save(admin);

            String formatedId = String.format("%05d", admin.getId());
            admin.setCode("ADM" + formatedId);
            this.adminRepository.save(admin);
        }

        else if (userRole.equals("CUSTOMER")) {
            MCustomer customer = new MCustomer();
            customer.setMBiodata(teMBiodata);
            customer.setBiodataId(tempMBiodata.getId());
            customer.setIsDelete(false);
            customer.setCreatedOn(LocalDateTime.now());
            customer.setCreatedBy(tempMUser.getId());

            customer = this.customerRepository.save(customer);
        }

        return "success";
    }

}
