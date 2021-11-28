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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.sql.SQLException;
import java.util.Date;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private PostService postService;
//
//    @MockBean
//    private UserService userService;
//
//    @BeforeEach
//    public void setUp() throws SQLException {
//        User user1000 = User.of(1000, "User1000", "password1000");
//        Post post1000 = Post.of(
//                1000, "name", "description", new Date(System.currentTimeMillis()), user1000
//        );
//        postService.save(post1000);
//    }
//
//    @AfterEach
//    public void clear() throws SQLException {
//        postService.deleteById(1000);
//        userService.deleteById(1000);
//    }

    @Test
    @WithMockUser
    @Sql({"/schema-test.sql"})
    public void whenAskIndexThenGetOkAndJSPIndex() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}