package com.harshvardhan.idt.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class IPUtil {
	public static String getClientIpAddress(HttpServletRequest request) {
		String xForwardedForHeader = request.getHeader("X-Forwarded-For");
		if (xForwardedForHeader == null) {
			return request.getRemoteAddr();
		} else {
			return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
		}
	}

	public static String getLocationFromIp(String ip) throws IOException, GeoIp2Exception {
		File database = new File(IPUtil.class.getClassLoader().getResource("GeoLite2-City.mmdb").getFile());
		DatabaseReader dbReader = new DatabaseReader.Builder(database).build();

		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = dbReader.city(ipAddress);

		String cityName = response.getCity().getName();
		return cityName;
	}

	public static String getLocationFromIp(HttpServletRequest request) throws IOException, GeoIp2Exception {
		return getLocationFromIp(getClientIpAddress(request));
	}
}
