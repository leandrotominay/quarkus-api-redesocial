package io.github.leandrotominay.quarkusmediasocial.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class FollowersPerUserResponse {
    private Integer FollowersCount;
    private List<FollowerResponse> content;


}
