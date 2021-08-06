package com.github.homework.program.model;

import com.github.homework.theme.domain.Theme;
import lombok.Getter;

@Getter
public class ProgramViewDetailDto {
    private final Long id;
    private final String name;
    private final String introduction;
    private final String introductionDetail;
    private final String region;
    private final Long count;
    private final String themeName;

    public ProgramViewDetailDto(Long id, String name, String introduction, String introductionDetail, String region, Long count, String themeName) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
        this.introductionDetail = introductionDetail;
        this.region = region;
        this.count = count;
        this.themeName = themeName;
    }
}
