package habitTracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import habitTracker.dto.HabitDto;
import habitTracker.dto.HabitHistoryDto;
import habitTracker.dto.AveragePercentDto;
import habitTracker.service.HabitTrackerService;

@RestController
public class HabitTrackerApiController {

	@Autowired
	HabitTrackerService habitTrackerService;
	
	// 습관 목록 조회
	@GetMapping("/api/habit/date/{registDt}")
	public ResponseEntity<Map<String, Object>> openHabitList(@PathVariable("registDt") String registDt) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		List<HabitDto> list = habitTrackerService.openHabitList(registDt);
		
		result.put("list", list);
		result.put("month", registDt);
		
		if(list != null) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}
	
	// 습관 추가
	@PostMapping("/api/habit/add")
	public ResponseEntity<Integer> addHabit(@RequestBody HabitDto habitDto) throws Exception {
		int addCount = habitTrackerService.addHabit(habitDto);
		
		if (addCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(addCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(addCount);
		}
	}
	
	// 습관 수정
	@PutMapping("/api/habit/edit/{habitIdx}")
	public ResponseEntity<Integer> editHabit(
							@PathVariable("habitIdx") int habitIdx,
							@RequestBody HabitDto habitDto) throws Exception {
		habitDto.setHabitIdx(habitIdx);
		int editCount = habitTrackerService.editHabit(habitDto);
		
		if (editCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(editCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(editCount);
		}
	}
	
	// 습관 삭제
	@DeleteMapping("/api/habit/delete/{habitIdx}")
	public ResponseEntity<Integer> deleteHabit(@PathVariable("habitIdx") int habitIdx) throws Exception {
		int deleteCount = habitTrackerService.deleteHabit(habitIdx);
		
		if (deleteCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deleteCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deleteCount);
		}
	}
	
	// 습관별 상세 페이지
	@GetMapping("/api/habit/detail/{habitIdx}")
	public ResponseEntity<Map<String, Object>> openHabitDetail(@PathVariable("habitIdx") int habitIdx) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		HabitDto habitDto = habitTrackerService.openHabitDetail(habitIdx);
		List<HabitHistoryDto> habitHistoryList = habitTrackerService.openHabitHistory(habitIdx);
		int count = habitTrackerService.habitTargetDays(habitIdx);
		int percent = habitTrackerService.habitTargetDaysPercent(habitIdx);
		
		result.put("registDt", habitDto.getRegistDt());
		result.put("habitDto", habitDto);
		result.put("habitHistoryList", habitHistoryList);
		result.put("count", count);
		result.put("percent", percent);
		
		if (habitDto != null && habitHistoryList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	// 습관 실행 여부 체크
	@PostMapping("/api/habit/check")
	public ResponseEntity<Integer> checkHabit(@RequestBody HabitHistoryDto habitHistorytDto) throws Exception {
		int checkCount = habitTrackerService.checkHabit(habitHistorytDto);
		
		if (checkCount != 1) {
			return ResponseEntity.status(HttpStatus.OK).body(checkCount);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(checkCount);
		}
	}
	
	// 월 변경 후 목록 조회
	@GetMapping("/api/habit/{registDt}")
	public ResponseEntity<List<HabitDto>> openHabitListByMonth(@PathVariable("registDt") String registDt) throws Exception {
		List<HabitDto> list = habitTrackerService.openHabitListByMonth(registDt);
		
		if (list != null) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}
	
	// 차트 
	@GetMapping("/api/habit/chart/{registDt}")
	public ResponseEntity<Map<String, Object>> habitOneDayAvgPercent(@PathVariable("registDt") String registDt) throws Exception {
		Map<String, Object> result = new HashMap<>();
		
		List<AveragePercentDto> list = habitTrackerService.habitOneDayAvgPercent(registDt);
		
		result.put("average",list);
		
		if(list != null) {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	}
	
}
