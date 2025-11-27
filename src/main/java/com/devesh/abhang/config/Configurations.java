package com.devesh.abhang.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {



    @Value("${cloudinary.api_key}")
    String apiKey;

    @Value("${cloudinary.api_secret}")
    String secretKey;

    @Value("${cloudinary.cloud_name}")
    String cloudName;


    @Bean
    public Cloudinary cloudinary()
    {
        return new Cloudinary(ObjectUtils.asMap(
                    "cloud_name",cloudName,
                            "api_key",apiKey,
                            "api_secret",secretKey,
                            "secure",true
        ));
    }


//     mail service config




}
