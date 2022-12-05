package com.das.das_backend.domain.user.domain.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class LinkInfo {

    @Column(unique = true)
    private String githubLink;

    @Column(unique = true)
    private String instagramLink;

    @Column(unique = true)
    private String facebookLink;

}
