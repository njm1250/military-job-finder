package com.military.jobfinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.military.jobfinder.entity.Api;
import com.military.jobfinder.repository.ApiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

// Populate the database after the application is ready
@Service
public class DatabaseInitializer {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final ApiRepository apiRepository;
    private final JobFinderService jobFinderService;

    public DatabaseInitializer(ApiRepository apiRepository, JobFinderService jobFinderService) {
        this.apiRepository = apiRepository;
        this.jobFinderService = jobFinderService;
    }

    // @PostConstruct 대신 사용. 모든 빈이 완전히 생성되고 @PostConstruct callback 이 호출된 후에 발생하는 Event
    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabase() throws Exception {
        try {
            String apiData = jobFinderService.getApiData();
            // jackson 을 사용하여 JSON handling
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> responseMap = mapper.readValue(apiData, Map.class); // Json to Java Map Object
            Map<String, Object> body = (Map<String, Object>) ((Map<String, Object>) responseMap.get("response")).get("body");
            Map<String, Object> items = (Map<String, Object>) body.get("items");
            List<Map<String, Object>> itemList = (List<Map<String, Object>>) items.get("item");

            for (Map<String, Object> item : itemList) {
                String eopcheNm = (String) item.get("eopcheNm"); // 업체이름
                Api api = new Api();
                api.setName(eopcheNm);
                apiRepository.save(api);
            }
            logger.info("Database population succeeded.");
        } catch(Exception e) {
            logger.error("Database population failed : " + e.getMessage());
        }


    }

}
