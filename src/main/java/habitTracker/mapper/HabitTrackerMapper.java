package habitTracker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import habitTracker.dto.AveragePercentDto;
import habitTracker.dto.HabitDto;
import habitTracker.dto.HabitHistoryDto;

@Mapper
public interface HabitTrackerMapper {

	// 습관 목록 조회
	public List<HabitDto> openHabitList(@Param("registDt") String registDt) throws Exception;

	// 습관 추가
	public int addHabit(HabitDto habitDto) throws Exception;

	// 습관 수정
	public int editHabit(HabitDto habitDto) throws Exception;

	// 습관 삭제
	public int deleteHabit(@Param("habitIdx") int habitIdx) throws Exception;

	// 습관 상세 페이지
	public HabitDto openHabitDetail(int habitIdx) throws Exception;
	public List<HabitHistoryDto> openHabitHistory(int habitIdx) throws Exception;
	public HabitHistoryDto sumhabitTargetDays(int habitIdx) throws Exception;
	
	// 습관 실행 여부 체크
	public int checkHabit(HabitHistoryDto habitHistoryDto) throws Exception;

	// 월 변경 후 목록 조회
	public List<HabitDto> openHabitListByMonth(String registDt) throws Exception;
	
	// 카운트 조회
	public int habitTargetDays(@Param("habitIdx") int habitIdx) throws Exception;
	
	// 퍼센트 조회
	public int habitTargetDaysPercent(@Param("habitIdx") int habitIdx) throws Exception;
	
	// 평균 조회
	public List<AveragePercentDto> habitOneDayAvgPercent(@Param("registDt") String registDt) throws Exception;
}
