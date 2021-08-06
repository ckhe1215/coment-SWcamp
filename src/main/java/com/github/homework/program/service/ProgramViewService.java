package com.github.homework.program.service;

import com.github.homework.program.model.ProgramViewDetailDto;
import com.github.homework.program.model.ProgramViewDto;
import com.github.homework.program.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProgramViewService {

    private final ProgramRepository programRepository;

    public Optional<ProgramViewDetailDto> getBy(Long id) {
        return programRepository.findById(id).map(program ->
                new ProgramViewDetailDto(
                        program.getId(),
                        program.getName(),
                        program.getIntroduction(),
                        program.getIntroductionDetail(),
                        program.getRegion(),
                        program.getCount(),
                        program.getTheme().getName()
                )
        );
    }

    public List<ProgramViewDetailDto> getBy(String name) {
        return programRepository.findAllByName(name);
    }

    public Page<ProgramViewDto> pageBy(Pageable pageable) {
        return programRepository.findBy(pageable);
    }

    public List<ProgramViewDto> getBestPrograms() {
        return programRepository.findTop10ByOrderByCountDesc();
    }

}
