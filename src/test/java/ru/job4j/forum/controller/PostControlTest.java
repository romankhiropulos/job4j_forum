package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@Sql({"/schema-test.sql"})
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenCreatePostThenOk() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/post/create"));
    }

    @Test
    @WithMockUser
    public void whenAskLoadWithFakeIdThenRedirectIndex() throws Exception {
        this.mockMvc.perform(get("/load").param("id", "2001"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(view().name("redirect:/index"));
    }

    @Test
    @WithMockUser
    public void whenAskLoadThenOk() throws Exception {
        this.mockMvc.perform(get("/load").param("id", "2000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/post/edit"));
    }

    @Test
    @WithMockUser
    public void whenAskPostWithFakeIdThenRedirectIndex() throws Exception {
        this.mockMvc.perform(get("/post").param("id", "2001"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(view().name("redirect:/index"));
    }

    @Test
    @WithMockUser
    public void whenAskPostThenOk() throws Exception {
        this.mockMvc.perform(get("/post").param("id", "2000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/post/post"));
    }

    @Test
    @WithMockUser
    public void whenAskDeleteThenRedirect() throws Exception {
        this.mockMvc.perform(get("/delete").param("id", "2001"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(view().name("redirect:/index"));
    }
}