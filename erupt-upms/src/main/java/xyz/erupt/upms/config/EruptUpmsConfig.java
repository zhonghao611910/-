package xyz.erupt.upms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liyuepeng
 * @date 2019-10-31.
 */
@Data
@Component
@ConfigurationProperties(prefix = "erupt.upms", ignoreUnknownFields = false)
public class EruptUpmsConfig {

    //redis session时长
    private Integer expireTimeByLogin = 100;

}
