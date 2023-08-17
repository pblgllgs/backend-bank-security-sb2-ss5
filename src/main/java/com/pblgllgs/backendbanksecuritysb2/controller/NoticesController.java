package com.pblgllgs.backendbanksecuritysb2.controller;

import com.pblgllgs.backendbanksecuritysb2.entity.Notice;
import com.pblgllgs.backendbanksecuritysb2.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoticesController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        return noticeRepository.findAllActiveNotices();
    }

}