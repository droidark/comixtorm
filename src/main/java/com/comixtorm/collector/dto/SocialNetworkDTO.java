package com.comixtorm.collector.dto;

import com.comixtorm.collector.constants.SocialNetworkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialNetworkDTO {

    private SocialNetworkType type;

    private String username;

    private String url;
}
