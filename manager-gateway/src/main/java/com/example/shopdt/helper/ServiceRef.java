package com.example.shopdt.helper;

import com.example.shopdt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceRef {
    public static ServiceRef INSTANCE;
    public ServiceRef(){
        INSTANCE=this;
    }

    @Autowired
    public UserRepository userRepository;
}
