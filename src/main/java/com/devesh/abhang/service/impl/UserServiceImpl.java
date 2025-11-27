package com.devesh.abhang.service.impl;

import com.devesh.abhang.config.Mailconfig.MailService;
import com.devesh.abhang.dto.Req.UserReq;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.entity.Role;
import com.devesh.abhang.entity.User;
import com.devesh.abhang.repository.RoleRepository;
import com.devesh.abhang.repository.UserRepository;
import com.devesh.abhang.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder encoder;

    @Autowired
    private MailService mailService;

    public MainRes createUser(UserReq userReq)
    {

        if(!userRepository.existsByEmail(userReq.getEmail()))
        {
            Role role=roleRepository.findByRole("ROLE_USER");
            User user=maptoUser(userReq);
            user.setRole(role);
            user.setStatus("Active");
            user.setCreatedDate(LocalDate.now());
            user.setUpdatedDate(LocalDate.now());
            user.setPassword(userReq.getPassword());

            try{
                String email=user.getEmail();
                String subject=" REGISTRATION MAIL";
                String body=" THANK YOU FOR REGISTER "+
                        " Your Cridentions is "+
                        " UserName = "+user.getEmail()+
                        " Password = "+user.getPassword();

                mailService.sendMail(user.getEmail(),subject,body);

                userRepository.save(user);
                return new MainRes(true,"SUCCESS ","SUCCESFULLY REGISTER !", LocalDateTime.now());

            }catch (Exception e)
            {
                e.printStackTrace();
                return new MainRes(false,"SOMETHING WENT WRONG !"," INTERNAL_SERVER_ERROR", LocalDateTime.now());
            }
        }else {

            return new MainRes(false,"EMAIL LOGIN ALREADY EXIST !"," INTERNAL_SERVER_ERROR", LocalDateTime.now());
        }

    }

    private User maptoUser(UserReq userReq) {
        Role role=roleRepository.findByRole(userReq.getRole());
        User user=new User();
        BeanUtils.copyProperties(userReq,user);
        user.setRole(role);
        return user;
    }

}
