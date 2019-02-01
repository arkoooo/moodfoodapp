package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    Users users;

    @Before
    public void setUp(){ users = new Users(); }

    @Test
    public void getId(){
        int valueId = 49;
        users.setUserId(valueId);
        assertEquals(valueId, users.getUserId());
    }

    @Test
    public void getName(){
        String name = "test";
        users.setUserName(name);
        assertEquals(name, users.getUserName());
    }

    @Test
    public void getMail(){
        String mail = "mail@mail.pl";
        users.setUserMail(mail);
        assertEquals(mail, users.getUserMail());
    }

    @Test
    public void getPassword(){
        String password = "strongpassword";
        users.setUserPassword(password);
        assertEquals(password,users.getUserPassword());
    }

    @Test
    public void getPhoto(){
        String photo = "nicephoto";
        users.setUserPhoto(photo);
        assertEquals(photo, users.getUserPhoto());
    }


}
