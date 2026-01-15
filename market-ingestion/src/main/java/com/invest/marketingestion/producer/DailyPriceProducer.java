package com.invest.marketingestion.producer;

import com.invest.schemas.market.DailyPriceEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DailyPriceProducer {

    private static final String TOPIC = "invest.market.daily_prices";

    private final KafkaTemplate<String, DailyPriceEvent> kafkaTemplate;

    public DailyPriceProducer(KafkaTemplate<String, DailyPriceEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishSampleEvent() {
        DailyPriceEvent event = DailyPriceEvent.newBuilder()
                .setEventId(UUID.randomUUID().toString())
                .setStockSymbol("AAPL")
                .setAsOfDate("2026-01-07")
                .setOpen(145.1)
                .setHigh(148.2)
                .setLow(144.9)
                .setClose(147.6)
                .setVolume(56000000L)
                .setProducedTs(System.currentTimeMillis())
                .setSchemaVersion(1)
                .build();

        kafkaTemplate.send(TOPIC, event.getStockSymbol().toString(), event);
    }
}
