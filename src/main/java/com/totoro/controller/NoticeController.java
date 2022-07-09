package com.totoro.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.totoro.domain.entity.Notice;
import com.totoro.domain.model.AjaxResult;
import com.totoro.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 20:18
 */
@RequiredArgsConstructor
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    @RequestMapping("today/fortune")
    public AjaxResult getFortune(){
        Notice fortune = noticeService.getFortune();
        return AjaxResult.success(fortune);
    }
}
