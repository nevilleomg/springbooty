package com.example.springbooty.link.service;

import com.example.springbooty.link.Link;
import com.example.springbooty.link.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class LinkService {

    private final LinkRepository repository;

    public LinkService(LinkRepository repository) {
        this.repository = repository;
    }

    public String postShortLink(String linkGiven) {
        Optional<Link> link = repository.findByLinkGiven(linkGiven);
        if (link.isPresent()) return String.valueOf(link.get().getLinkShort());
        else {
            Link newLink = new Link();
            newLink.setLinkGiven(linkGiven);
            newLink.setLinkShort(makeRandomShortLink());
            repository.save(newLink);
            return String.valueOf(newLink.getLinkShort());
        }
    }

    public String getGivenLink(String linkShort) {
        Optional<Link> link = repository.findByLinkShort(Integer.valueOf(linkShort));
        if (link.isPresent()) return link.get().getLinkGiven();
        else throw new IllegalStateException("Wrong URL");
    }

    public int makeRandomShortLink() {
        int l = ThreadLocalRandom.current().nextInt(1, 1000000);
        while (repository.findByLinkShort(l).isPresent()) {
            l = ThreadLocalRandom.current().nextInt(1, 1000000);
        }
        return l;
    }
}
