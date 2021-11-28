package ru.job4j.forum.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

import java.sql.SQLException;
import java.util.Date;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

//    public IndexControlTest(PostService postService) {
//        this.postService = postService;
//    }
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        Post post1 = Post.of(
//                1, "name", "description", new Date(System.currentTimeMillis()), new User()
//        );
//        postService.save(post1);
//    }
//
//    @AfterEach
//    public void clear() throws SQLException {
//        postService.deleteById(1);
//    }

    @Test
    @WithMockUser
    public void whenAskIndexThenGetOkAndJSPIndex() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}