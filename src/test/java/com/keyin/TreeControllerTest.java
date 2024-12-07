package com.keyin;

import com.keyin.controller.TreeController;
import com.keyin.service.TreeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TreeController.class)
public class TreeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TreeService treeService;

    @Test
    void testEnterNumbersPage() throws Exception {
        mockMvc.perform(get("/enter-numbers"))
                .andExpect(status().isOk());
    }
}