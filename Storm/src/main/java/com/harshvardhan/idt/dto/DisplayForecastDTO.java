package com.harshvardhan.idt.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.harshvardhan.idt.model.ForecastDetails;
import com.harshvardhan.idt.model.ForecastDetailsArray;
import com.harshvardhan.idt.model.TemperatureTimeSeries;

@XmlAccessorType(XmlAccessType.FIELD)
public class DisplayForecastDTO {
	@XmlElement
	List<TemperatureTimeSeries> hourly;
	@XmlElement
	List<TemperatureTimeSeries> daily;

	public List<TemperatureTimeSeries> getHourly() {
		return hourly;
	}

	public List<TemperatureTimeSeries> getDaily() {
		return daily;
	}

	public DisplayForecastDTO(ForecastDetailsArray details) {
		ForecastDetails forecastDetails = null;
		TemperatureTimeSeries temperatureTime = null;
		hourly = new ArrayList<>();
		daily = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			forecastDetails = details.getDetails().get(i);
			temperatureTime = new TemperatureTimeSeries(forecastDetails.getDt_txt().split(" ")[1],
					forecastDetails.getMain().getTemp());
			hourly.add(temperatureTime);
		}

		for (int i = 0; i < details.getDetails().size(); i += 8) {
			forecastDetails = details.getDetails().get(i);
			temperatureTime = new TemperatureTimeSeries(forecastDetails.getDt_txt().split(" ")[0],
					forecastDetails.getMain().getTemp());
			daily.add(temperatureTime);
		}
	}

}
