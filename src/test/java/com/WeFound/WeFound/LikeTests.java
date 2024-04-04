package com.WeFound.WeFound;


import com.WeFound.WeFound.controller.LikeController;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.dto.LikeRequest;
import com.WeFound.WeFound.dto.LikeResponse;
import com.WeFound.WeFound.service.LikeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LikeController.class)
@AutoConfigureMockMvc
class LikeTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LikeService likeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addLike() throws Exception {
        // Given
        User user = new User();
        user.setUserId(1L);
        LikeRequest request = new LikeRequest(1L, 1L);
        LikeResponse response = new LikeResponse(1L, 1L);
        when(likeService.addLike(any())).thenReturn(response);

        // When
        ResultActions result = mockMvc.perform(post("/boards/user/likes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    void deleteLike() throws Exception {
        // Given
        User user = new User();
        user.setUserId(1L);
        LikeRequest request = new LikeRequest(1L, 1L);

        // When
        ResultActions result = mockMvc.perform(delete("/boards/user/likes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(request)));

        // Then
        result.andExpect(status().isOk());
    }
}