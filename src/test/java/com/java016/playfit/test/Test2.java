package com.java016.playfit.test;

import com.java016.playfit.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Test2 {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void test2(){
        System.out.println("-->");
        userRepository.updateUserCertificationStatus(1,1);
        userRepository.updateUserRole(1,"ROLE_PRIME");
    }
}
