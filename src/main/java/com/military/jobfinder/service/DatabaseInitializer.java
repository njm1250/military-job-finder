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
import java.util.Optional;

// Populate the database after the application is ready
@Service
@SuppressWarnings("unchecked")
public class DatabaseInitializer {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final ApiRepository apiRepository;
    private final JobFinderService jobFinderService;

    public DatabaseInitializer(ApiRepository apiRepository, JobFinderService jobFinderService) {
        this.apiRepository = apiRepository;
        this.jobFinderService = jobFinderService;
    }

    // 모든 Spring Bean 이 완전히 생성되고 @PostConstruct callback 이 호출된 후에 발생하는 Event
    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabase() throws Exception {
        try {
            String apiData = jobFinderService.getApiData(); // fetch API JSON Data
            // jackson 을 사용하여 JSON handling
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> responseMap = mapper.readValue(apiData, Map.class); // Json to Java Map Object
            Map<String, Object> body = (Map<String, Object>) ((Map<String, Object>) responseMap.get("response")).get("body");
            Map<String, Object> items = (Map<String, Object>) body.get("items");
            List<Map<String, Object>> itemList = (List<Map<String, Object>>) items.get("item");

            for (Map<String, Object> item : itemList) {
                Api api = new Api();

                // 필수값이 아닌 옵션값들은 if가 아닌 Optional 객체를 사용해서 체크
                Optional<String> firstOccurDate = Optional.ofNullable(item.get("ccdatabalsaengDtm").toString()); // 최초발생일
                firstOccurDate.ifPresent(value -> {
                    api.setFirstOccurDate(value);
                });
                Optional<String> lastModDate = Optional.ofNullable(item.get("cjdatabyeongyeongDtm").toString()); // 최종변동일
                lastModDate.ifPresent(value -> {
                    api.setLastModDate(value);
                });
                Optional<String> task = Optional.ofNullable(item.get("ddeopmuNm").toString()); // 담당업무
                task.ifPresent(value -> {
                    api.setTask(value);
                });
                String welfare = item.get("bokrihs").toString(); // 복리후생
                String finalEdu = item.get("cjhakryeok").toString(); // 최종학력
                String recruitNum = item.get("cygonggoNo").toString(); // 채용번호
                String recruitTitle = item.get("cyjemokNm").toString(); // 채용제목
                String respPerson = item.get("damdangjaFnm").toString(); // 담당자

                String companyName = item.get("eopcheNm").toString(); // 업체이름

                api.setWelfare(welfare);
                api.setFinalEdu(finalEdu);
                api.setRecruitNum(recruitNum);
                api.setRecruitTitle(recruitTitle);
                api.setRespPerson(respPerson);
                api.setCompanyName(companyName);
                apiRepository.save(api);
            }
            logger.info("Database population succeeded.");
        } catch(Exception e) {
            logger.error("Database population failed : " + e.getMessage());
        }
    }

}
