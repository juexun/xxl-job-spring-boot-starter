package cn.gzsunrun.xxljob.spring.boot.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author eamon
 */
@ConfigurationProperties("xxl.job")
@Data
public class XxlJobExecutorProperties {

    private boolean enabled;

    private XxlJobAdmin admin;

    private String accessToken;

    private Executor executor;

    @Data
    public static class XxlJobAdmin {
        private String addresses;
    }

    @Data
    public static class Executor {
        private String appname;

        private String address;

        private String ip;

        private int port;

        private String logpath;

        private int logretentiondays;
    }
}
