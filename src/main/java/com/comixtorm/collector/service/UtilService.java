package com.comixtorm.collector.service;

import com.comixtorm.collector.dto.IssueDto;
import com.comixtorm.collector.dto.TitleDto;
import com.comixtorm.collector.model.*;

public interface UtilService {
    TitleDto joinCollection(User user, Title title);
    IssueDto joinCollection(User user, Issue issue);
}
