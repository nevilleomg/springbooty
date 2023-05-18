package com.example.springbooty.link.controller;

import com.example.springbooty.link.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api")
public class LinkController {

    private final LinkService service;

    @Autowired
    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping(path = "link")
    public PostResponse postLink(
            @RequestBody PostRequest request
    ) {
        return new PostResponse(service.postShortLink(request.getLink()));
    }

    @GetMapping(path = "link/{linkShort}")
    public RedirectView getLink(
            @PathVariable String linkShort) {
        return new RedirectView(service.getGivenLink(linkShort));
    }

    @GetMapping(path = "dana_stark")
    public String showMark() {
        return
                "<!DOCTYPE html>"+
                        "<html>"+
                        "	<head><img src=\"https://sun9-49.userapi.com/impg/V5TE3xnwdJS-maY13fE7uhbKQU4_UIXQiD7idQ/x3B9AHNaTsM.jpg?size=828x1472&quality=95&sign=7013088b9f5bbadf3c294973742857ed&type=album\" width=\"200\" height=\"auto\" alt=\"Dana\"></head>"+
                        "</html>"
                ;
    }
}
