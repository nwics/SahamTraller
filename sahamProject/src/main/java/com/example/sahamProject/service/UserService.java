package com.example.sahamProject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
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

    // private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    // public UserService(UserRepository userRepository, PasswordEncoder
    // passwordEncoder) {
    // this.userRepository = userRepository;
    // this.passwordEncoder = passwordEncoder;
    // }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws
    // UsernameNotFoundException {
    // MUser user = userRepository.findByEmailAndIsDeleteFalse(email)
    // .stream().findFirst()
    // .orElseThrow(() -> new UsernameNotFoundException("User not found with email:
    // " + email));

    // return User.builder()
    // .username(user.getEmail())
    // .password(user.getPassword()) // Password sudah terenkripsi di database
    // .roles(user.getMRole().getName()) // Menggunakan role dari database
    // .build();
    // }

    // public MUser addNewUser(MUser user) {
    // try {
    // user.setPassword(passwordEncoder.encode(user.getPassword())); // Enkripsi
    // password
    // user.setCreatedOn(LocalDateTime.now());
    // user = this.userRepository.save(user);

    // user.setCreatedBy(user.getId());
    // return this.userRepository.save(user);
    // } catch (Exception e) {
    // return new MUser();
    // }
    // }

    // public String getValidasiEmail(String email) {
    // boolean exists = userRepository.findByEmailAndIsDeleteFalse(email)
    // .stream().findFirst()
    // .isPresent();

    // return exists ? "found" : "not found";
    // }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BiodataRepository biodataRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<MBiodata> getUsers() {
        return biodataRepository.findAll();
    }

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
            // temp.setBiodataId(user.getId());
            // temp.setPassword(user.getPassword());
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

        if (user.getMBiodataId() != null) {
            tempMBiodata.setMobilePhone(user.getMBiodataId().getMobilePhone());
            tempMBiodata.setFullname(user.getMBiodataId().getFullname());

        } else {
            tempMBiodata.setMobilePhone("021021");
            tempMBiodata.setFullname("mo salah");
        }
        // tempMBiodata.setFullname(user.getMBiodataId().getFullname());
        // tempMBiodata.setMobilePhone(user.getMBiodataId().getMobilePhone());
        tempMBiodata.setCreatedOn(LocalDateTime.now());

        MBiodata teMBiodata = this.biodataRepository.save(tempMBiodata);

        tempMUser.setMRole(user.getMRole());
        //
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
