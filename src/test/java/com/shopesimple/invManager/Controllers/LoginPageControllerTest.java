package com.shopesimple.invManager.Controllers;

import com.shopesimple.invManager.Models.User;
import com.shopesimple.invManager.Service.LoginPageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class LoginPageControllerTest {

    @MockBean
    private LoginPageService loginPageService;

    @Test
    public void productController(){
        int[] l={1,2,5,7,8,9};
        Arrays.sort(l);
        assertArrayEquals(new int[]{},l);



    }

}