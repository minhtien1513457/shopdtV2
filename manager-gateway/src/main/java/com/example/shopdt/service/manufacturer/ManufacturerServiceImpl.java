package com.example.shopdt.service.manufacturer;

import com.example.shopdt.entity.ManufacturerEntity;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.repository.manufacturer.ManufacturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public Optional<ManufacturerEntity> getByIdNullAble(String id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public ManufacturerEntity getByIdNoneNull(String id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
