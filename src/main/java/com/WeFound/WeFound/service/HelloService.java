package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.HelloDto;
import com.WeFound.WeFound.entity.Hello;
import com.WeFound.WeFound.repository.HelloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private final HelloRepository helloRepository;

    public HelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    public HelloDto getHello(Long id) {
        Hello hello = helloRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hello not found"));
        return convertToDto(hello);
    }



    private HelloDto convertToDto(Hello hello) {
        HelloDto helloDto = new HelloDto();
        helloDto.setId(hello.getId());
        helloDto.setMessage(hello.getMessage());
        return helloDto;
    }
}