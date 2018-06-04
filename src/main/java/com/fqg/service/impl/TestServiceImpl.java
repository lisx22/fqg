package com.fqg.service.impl;

import com.fqg.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    public  void test(){
        System.out.println("test");
    }
}
