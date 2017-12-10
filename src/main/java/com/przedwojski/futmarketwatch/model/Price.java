package com.przedwojski.futmarketwatch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Price {
    private Prices prices;
}

@Getter
@Setter
@NoArgsConstructor
class Prices {
    private DevicePrice xbox;
    private DevicePrice ps;
    private DevicePrice pc;
}

@Getter
@Setter
@NoArgsConstructor
class DevicePrice {
    @JsonProperty("LCPrice")
    private String lcPrice;
    @JsonProperty("LCPrice2")
    private String lcPrice2;
    @JsonProperty("LCPrice3")
    private String lcPrice3;
    @JsonProperty("LCPrice4")
    private String lcPrice4;
    @JsonProperty("LCPrice5")
    private String lcPrice5;
    private String updated;
    @JsonProperty("MinPrice")
    private String minPrice;
    @JsonProperty("MaxPrice")
    private String maxPrice;
    @JsonProperty("PRP")
    private String prp;
}
