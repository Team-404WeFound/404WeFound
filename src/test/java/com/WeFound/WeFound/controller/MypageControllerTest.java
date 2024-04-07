package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.service.MypageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")

@DisplayName("마이페이지 컨트롤러 테스트")
class MypageControllerTest {

    @Autowired
    private MypageController mypageController;

    @Test
    @DisplayName("/mypage 경로에 대한 페이지 반환 테스트")
    void myPage() {
        // given
        Model model = mock(Model.class);
        MypageService mypageService = mock(MypageService.class);
        mypageController.setMypageService(mypageService);

        List<Point> pointHistory = new ArrayList<>();
        pointHistory.add(new Point(1L, 100L));
        pointHistory.add(new Point(2L, 200L));
        when(mypageService.getPointHistoryForCurrentUser()).thenReturn(pointHistory);

        // when
        String viewName = mypageController.myPage(model);

        // then
        assertEquals("mypage", viewName);
        verify(mypageService, times(1)).populateModelWithUserDetails(model);
        verify(model, times(1)).addAttribute("pointHistory", pointHistory);
        verify(model, times(1)).addAttribute("currentPoint", 300L);
    }

}
