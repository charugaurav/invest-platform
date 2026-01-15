package com.invest.marketingestion;

import com.invest.marketingestion.producer.DailyPriceProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketIngestionApplication implements CommandLineRunner {

	private final DailyPriceProducer dailyPriceProducer;

	public MarketIngestionApplication(DailyPriceProducer dailyPriceProducer) {
		this.dailyPriceProducer = dailyPriceProducer;
	}
	public static void main(String[] args) {
		SpringApplication.run(MarketIngestionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dailyPriceProducer.publishSampleEvent();
	}
}
