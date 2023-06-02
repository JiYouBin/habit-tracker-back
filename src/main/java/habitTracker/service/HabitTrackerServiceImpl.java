package habitTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import habitTracker.dto.AveragePercentDto;
import habitTracker.dto.HabitDto;
import habitTracker.dto.HabitHistoryDto;
import habitTracker.mapper.HabitTrackerMapper;

@Service
public class HabitTrackerServiceImpl implements HabitTrackerService {

	@Autowired
	HabitTrackerMapper habitTrackerMapper;
	
	// 습관 목록 조회
	public List<HabitDto> openHabitList(String registDt) throws Exception {
		return habitTrackerMapper.openHabitList(registDt); 
	}

	// 습관 추가
	public int addHabit(HabitDto habitDto) throws Exception {
		return habitTrackerMapper.addHabit(habitDto);
	}

	// 습관 수정
	public int editHabit(HabitDto habitDto) throws Exception {
		return habitTrackerMapper.editHabit(habitDto);
	}

	// 습관 삭제
	public int deleteHabit(int habitIdx) throws Exception {
		return habitTrackerMapper.deleteHabit(habitIdx);
	}

	// 습관 상제 페이지
	public HabitDto openHabitDetail(int habitIdx) throws Exception {
		return habitTrackerMapper.openHabitDetail(habitIdx);
	}

	public List<HabitHistoryDto> openHabitHistory(int habitIdx) throws Exception {
		return habitTrackerMapper.openHabitHistory(habitIdx);
	}
	public HabitHistoryDto sumhabitTargetDays(int habitIdx) throws Exception {
		return habitTrackerMapper.sumhabitTargetDays(habitIdx);
	}
	
	// 습관 실행 여부 체크
	public int checkHabit(HabitHistoryDto habitHistoryDto) throws Exception {
		return habitTrackerMapper.checkHabit(habitHistoryDto);
	}

	// 월 변경 후 목록 조회
	public List<HabitDto> openHabitListByMonth(String registDt) throws Exception {
		return habitTrackerMapper.openHabitListByMonth(registDt);
	}
	
	// 카운트 조회
	public int habitTargetDays(int habitIdx) throws Exception {
		return habitTrackerMapper.habitTargetDays(habitIdx);
	}
	
	// 퍼센트 조회
	public int habitTargetDaysPercent(int habitIdx) throws Exception {
		return habitTrackerMapper.habitTargetDaysPercent(habitIdx);
	}
	
	// 평균 조회
	public List<AveragePercentDto> habitOneDayAvgPercent(String registDt) throws Exception {
		return habitTrackerMapper.habitOneDayAvgPercent(registDt);
	}
}
