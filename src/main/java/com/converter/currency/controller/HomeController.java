package com.converter.currency.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    // 머스타치로 화면 리턴
    // 뷰에서 환율 계산해서 표시하기

    @GetMapping
    String home(Model model){
        return "home";
    }


}
