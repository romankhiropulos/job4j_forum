package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@Sql({"/schema-test.sql"})
public class RegControlPostTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userMockBeanService;

    @Test
    @WithMockUser
    @Sql({"/schema-test.sql"})
    public void whenAskRegThanSaveNewUserAndRedirect() throws Exception {
        this.mockMvc.perform(post("/reg")
                        .param("password", "pswd")
                        .param("username", "name1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(userMockBeanService).save(argument.capture());
        assertThat(argument.getValue().getUsername(), is("name1"));
        assertThat(argument.getValue().getAuthority().getAuthority(), is("ROLE_USER"));
    }
}
