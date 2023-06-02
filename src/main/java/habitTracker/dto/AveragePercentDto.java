package habitTracker.dto;

import lombok.Data;

@Data
public class AveragePercentDto {
	private String distinctDay;
	private int completionRate;
	
}
