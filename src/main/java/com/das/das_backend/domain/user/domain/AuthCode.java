package com.das.das_backend.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash
public class AuthCode {

    @Id
    private String email;

    private String code;

    private boolean isVerify;

    @TimeToLive
    private Integer ttl;

    public void updateAuthCode(String code, Integer ttl) {
        this.code = code;
        this.ttl = ttl;
        this.isVerify = false;
    }

    public void changeVerify() {
        this.isVerify = true;
    }

}
