package com.comixtorm.collector.util;

import com.comixtorm.collector.domain.model.Publisher;
import com.comixtorm.collector.domain.model.PublisherSocialNetworks;
import com.comixtorm.collector.dto.PublisherDTO;
import com.comixtorm.collector.dto.SocialNetworkDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperService {

    private final ModelMapper modelMapper;

    public PublisherDTO toPublisherDTO(Publisher publisher) {
        return this.modelMapper.map(publisher, PublisherDTO.class);
    }

    public SocialNetworkDTO toSocialNetworkDTO(PublisherSocialNetworks publisherSocialNetworks) {
        return this.modelMapper.map(publisherSocialNetworks, SocialNetworkDTO.class);
    }

    public Publisher toPublisher(PublisherDTO publisherDTO) {
        return this.modelMapper.map(publisherDTO, Publisher.class);
    }

    public PublisherSocialNetworks toPublisherSocialNetworks(SocialNetworkDTO socialNetworkDTO) {
        return this.modelMapper.map(socialNetworkDTO, PublisherSocialNetworks.class);
    }
}
