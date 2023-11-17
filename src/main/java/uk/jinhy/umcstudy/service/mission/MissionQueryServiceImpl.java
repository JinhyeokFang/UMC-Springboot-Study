package uk.jinhy.umcstudy.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.jinhy.umcstudy.domain.UserMission;
import uk.jinhy.umcstudy.repository.mission.MissionRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public boolean isExist(Long id) {
        Optional<UserMission> mission = missionRepository.findById(id);
        return mission.isPresent();
    }

    @Override
    public boolean isStatusCreated(Long id) {
        UserMission mission = missionRepository.findById(id).get();
        return mission.getStatus().equals("CREATED");
    }
}
