package com.comixtorm.collector.domain.model;

import com.comixtorm.collector.constants.SocialNetworkType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "publisher_social_networks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublisherSocialNetworks {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SocialNetworkType type;

    @Column(name = "username")
    private String username;

    @Column(name = "url")
    private String url;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;
}
