package ru.trofimom.coffeemakerrestservice.service.impl;

import org.springframework.stereotype.Service;
import ru.trofimom.coffeemakerrestservice.service.ResourceCheckingService;

import java.util.Random;

@Service
public class ResourceCheckingServiceImpl implements ResourceCheckingService {

    @Override
    public boolean waterLevelCheck() {
        Random random = new Random();
        return random.nextInt(10) > 1;
    }
}
