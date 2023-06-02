package habitTracker.dto;

import lombok.Data;

@Data
public class HabitDto {

	private int habitIdx;
	private String habitContent;
	private String registDt;
	private String deleteYn;
	
}
