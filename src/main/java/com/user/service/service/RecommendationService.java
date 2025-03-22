package com.user.service.service;


import com.user.service.constants.MoodConstants;
import com.user.service.entity.Mood;
import com.user.service.exception.RecommendationException;
import com.user.service.repository.RecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public String saveMood(Mood mood) {

        try {
            mood.setId(mood.getProfileId());
            mood.setCreateTimeStamp(LocalDateTime.now());
            Mood savedMood = recommendationRepository.save(mood);
            switch (mood.getMoodType().trim().toUpperCase()) {
                case "SAD":
                    return MoodConstants.SAD_SUGGESTION;
                case "HAPPY":
                    return MoodConstants.HAPPY_SUGGESTION;
                case "NEUTRAL":
                    return MoodConstants.NEUTRAL_NEUTRAL;
                default:
                    return null;
            }
        } catch (Exception e) {
            throw new RecommendationException("Failed to persists recommendation data ");
        }
    }


    private Object generateAIRecommendation(Mood mood) {
        // Implement AI logic here
        return "AI Recommendation for mood: " + mood.getMoodType();
    }

    public List<Mood> getAll() {
        try {
            Iterable<Mood> allRecords = recommendationRepository.findAll();
            log.info(allRecords.toString());
            List<Mood> moodsList = new ArrayList<>();
            allRecords.forEach(moodsList::add);
            return moodsList;
        } catch (Exception e) {
            throw new RecommendationException("Failed to persists recommendation data ");
        }
    }

    public List<Mood> getMoodRecommendationsById(String customerId) {

        try {
            List<Mood> moodList = recommendationRepository.getAllById(customerId);
            return moodList;
        } catch (Exception e) {
            throw new RecommendationException("Exception while retrieving the customer recommendations by id ");
        }


    }
}
