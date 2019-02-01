package com.example.demo.controllers;

import com.example.demo.model.Restaurants;
import com.example.demo.model.Reviews;
import com.example.demo.model.Users;
import com.example.demo.repositories.RestaurantsRepository;
import com.example.demo.repositories.ReviewsRepository;
import com.example.demo.repositories.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



public class MainControllerTest {



    @Autowired
    TestEntityManager entityManager;

    @Mock
    private RestaurantsRepository restaurantsRepository;
    private MockMvc mockMvc;

    @Mock
    private ReviewsRepository reviewsRepository;

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private MainController mainController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void searchPage() throws Exception{
        Restaurants restaurants = new Restaurants("Test", "TestLocation", "TestDescription", "TestPhoto");
        when(restaurantsRepository.findAll()).thenReturn(Collections.singletonList(restaurants));
        restaurantsRepository.save(restaurants);

        mockMvc.perform(get("/search/"))
                .andExpect(status().isOk())
                .andExpect(view().name("search"));
    }

    @Test
    public void registerPage() throws Exception {
        mockMvc.perform(get("/register/"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    @Test
    public void addingUser() throws Exception {
        Users anotherTestUser = new Users ("Steve", "msjackson@yahoo.com", "greatpass", "dogphoto");
        when(usersRepository.findAll()).thenReturn(Arrays.asList(anotherTestUser));
        usersRepository.save(anotherTestUser);
        Iterable<Users> result = usersRepository.findAll();
        assertEquals(Arrays.asList(anotherTestUser), result);

    }
    @Test
    public void localsPage() throws Exception {
        Reviews reviews = new Reviews (1, 1, "review text", 4);
        when(reviewsRepository.findAll()).thenReturn(Collections.singletonList(reviews));
        reviewsRepository.save(reviews);

        Restaurants restaurants = new Restaurants("Test", "TestLocation", "TestDescription", "TestPhoto");
        when(restaurantsRepository.findAll()).thenReturn(Collections.singletonList(restaurants));
        restaurantsRepository.save(restaurants);

        Users users = new Users("TestName", "TestMail", "TestPassword", "TestPhoto");
        when(usersRepository.findAll()).thenReturn(Collections.singletonList(users));
        usersRepository.save(users);

            mockMvc.perform(get("/locals/")
            .param("localId", "25"))
                    .andExpect(status().isOk());


    }


}
