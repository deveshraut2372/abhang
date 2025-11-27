package com.devesh.abhang.controller;

//import com.devesh.abhang.config.jwtconfig.JwtUtils;
import com.devesh.abhang.config.Mailconfig.MailService;
import com.devesh.abhang.dto.Req.LoginReq;
import com.devesh.abhang.dto.Req.OtpReq;
import com.devesh.abhang.dto.Req.UpdatePasswordReq;
import com.devesh.abhang.dto.Res.LoginRes;
import com.devesh.abhang.dto.Res.MainRes;
import com.devesh.abhang.entity.User;
import com.devesh.abhang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/auth")
public class AuthController {

//    @PostMapping("/login")
//    public ResponseEntity<LoginRes> login(@RequestBody LoginReq loginReq)
//    {
//
//
////            MainRes mainRes=new MainRes(true," LOGIN SUCCESFULLY !","SUCCESS", LocalDateTime.now());
////            LoginRes loginRes=new LoginRes(token,user.getUserId());
//            return new ResponseEntity<>(loginRes, HttpStatus.OK);
//        }else {
//            System.out.println(" Not authenticated ");
//            return new ResponseEntity<>(new LoginRes(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }


    @Autowired
    UserRepository userRepository;


    @Autowired
    MailService mailService;



    @PostMapping("/login")
    public ResponseEntity<MainRes> login(@RequestBody LoginReq loginReq)
    {
        try
        {
            if(userRepository.existsByEmail(loginReq.getUserName()))
            {
                User user= userRepository.findByEmail(loginReq.getUserName()).get();
                if(loginReq.getPassword().equals(user.getPassword()))
                {
                    return new ResponseEntity<>(new MainRes(true,"Login Successful ","200", LocalDateTime.now()),HttpStatus.OK);
                }else {
                    return new ResponseEntity<>(new MainRes(false,"Password Is Wrong !","400", LocalDateTime.now()),HttpStatus.BAD_REQUEST);
                }
            }else {
                return new ResponseEntity<>(new MainRes(false,"User Not Exist","400", LocalDateTime.now()),HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MainRes(false,"Someting went wrong !","400", LocalDateTime.now()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/forgotPassword/{email}")
    public ResponseEntity<MainRes> forgotPassword(@PathVariable("email") String email )
    {

        try {
            if (userRepository.existsByEmail(email)) {
                User user = userRepository.findByEmail(email).get();
                String otp = generateOtp();
                System.out.println(" OTP =" + otp);
                user.setOtp(otp);
                userRepository.save(user);

                String to = email;
                String sub = "OTP VERIFICATION FOR FORGOTPASSWORD OF ABHANG APPICATION";
                String message = " Thank you for initiating the verification process with us! To ensure the security of your account, we’ve generated a One-Time Password (OTP) that you will need to enter to complete your verification.\n" +
                        "\n" +
                        "Your OTP is:" + otp +
                        "\n" +
                        "Please enter this code in the designated field to verify your identity. This code is valid for [10 minutes] and can only be used once. If you did not request this verification or believe this is an error, please disregard this email.\n" +
                        "\n" +
                        "If you encounter any issues or need further assistance, feel free to contact our support team at [support email/contact number].\n" +
                        "\n" +
                        "Thank you for your attention!\n" +
                        "\n" +
                        "Best regards,\n" +
                        "\n" +
                        "[Your Company Name]\n" +
                        "\n" +
                        "[Your Company Contact Information]\n" +
                        "\n" +
                        "[Your Company Website]";

                mailService.sendMail(to, sub, message);

                return new ResponseEntity<>(new MainRes(true, "SUCCESS", "200", LocalDateTime.now()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new MainRes(false, "User Not Exist", "400", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new MainRes(false, "SOMETHING WENT WRONG "+e.getMessage(), "500", LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/otpVerification")
    public ResponseEntity<MainRes> otpVerification(@RequestBody OtpReq otpReq)
    {
        try
        {
            User user=userRepository.findByEmail(otpReq.getEmail()).get();

            if(user.getOtp().equalsIgnoreCase(otpReq.getOtp()))
            {
                return new ResponseEntity<>(new MainRes(true, "SUCCESS", "200", LocalDateTime.now()), HttpStatus.OK);
            }else {
                 return new ResponseEntity<>(new MainRes(false, "INCORRECT OTP !", "400", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new MainRes(false, "SOMETHING WENT WRONG "+e.getMessage(), "500", LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/newPassword")
    public ResponseEntity<MainRes>  newPassword(@RequestBody UpdatePasswordReq updatePasswordReq)
    {
        try
        {
            if(userRepository.existsByEmail(updatePasswordReq.getUserName()))
            {
                User user = userRepository.findByEmail(updatePasswordReq.getUserName()).get();
                user.setPassword(updatePasswordReq.getNewPassword());
                userRepository.save(user);
                return new ResponseEntity<>(new MainRes(true, "Success", "2-00", LocalDateTime.now()), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new MainRes(false, "User Not Exist  ", "400", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new MainRes(false, "SOMETHING WENT WRONG "+e.getMessage(), "500", LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public String generateOtp()
    {
        Random random=new Random();
        Integer otp= 1000+random.nextInt(9000);

        return String.valueOf(otp);
    }


}
