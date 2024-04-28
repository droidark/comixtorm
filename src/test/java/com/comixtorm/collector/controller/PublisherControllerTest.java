package com.comixtorm.collector.controller;

import com.comixtorm.collector.service.PublisherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.comixtorm.collector.util.TestUtilities.buildPublisherDTOs;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublisherController.class)
class PublisherControllerTest {

    @MockBean
    private PublisherService publisherService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_all_publishers() throws Exception {
        when(publisherService.getPublishers(any(PageRequest.class))).thenReturn(new PageImpl<>(buildPublisherDTOs()));

        RequestBuilder request = MockMvcRequestBuilders.get("/publishers").accept(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(request).andExpect(status().isOk());
    }

    @Test
    void should_return_no_content() throws Exception {
        when(publisherService.getPublishers(any(PageRequest.class))).thenReturn(Page.empty());

        RequestBuilder request = MockMvcRequestBuilders.get("/publishers").accept(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(request).andExpect(status().isNoContent());
    }
}