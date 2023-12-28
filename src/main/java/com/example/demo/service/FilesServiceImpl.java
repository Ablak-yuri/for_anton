package com.example.demo.service;

import com.example.demo.entity.SpecialDto;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilesServiceImpl {
    private final EntityManager entityManager;

    @PostConstruct
    public void init() {
        getFilesStat();
    }

    public void getFilesStat() {
        List<SpecialDto> resultList = entityManager.createNamedQuery("SpecialDto").getResultList();
        resultList.forEach(e -> System.out.println(e));
    }
}
