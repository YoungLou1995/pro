package com.cernet.pro.controller;

import com.cernet.pro.mapper.UrlsMapper;
import com.cernet.pro.model.Url2show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UrlController {

    @Autowired
    private UrlsMapper urlsMapper;

    @GetMapping("url")
    public String url(Model model){
         List<Url2show> url2showsList = urlsMapper.list();
         model.addAttribute("url2showList", url2showsList);
        return "url";
    }
}
