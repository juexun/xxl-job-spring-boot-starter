package cn.gzsunrun.xxljob.spring.boot.autoconfigure;

import cn.gzsunrun.xxljob.spring.boot.autoconfigure.properties.XxlJobExecutorProperties;
import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eamon
 * XXL Job Executor 自动配置
 */
@Configuration
@ConditionalOnClass(XxlJobExecutor.class)
@EnableConfigurationProperties({XxlJobExecutorProperties.class})
public class XxlJobExecutorAutoConfiguration {

    private final XxlJobExecutorProperties executorProperties;

    public XxlJobExecutorAutoConfiguration(XxlJobExecutorProperties executorProperties) {
        this.executorProperties = executorProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(executorProperties.getAdmin().getAddresses());
        xxlJobSpringExecutor.setAppname(executorProperties.getExecutor().getAppname());
        xxlJobSpringExecutor.setAddress(executorProperties.getExecutor().getAddress());
        xxlJobSpringExecutor.setIp(executorProperties.getExecutor().getIp());
        xxlJobSpringExecutor.setPort(executorProperties.getExecutor().getPort());
        xxlJobSpringExecutor.setAccessToken(executorProperties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(executorProperties.getExecutor().getLogpath());
        xxlJobSpringExecutor.setLogRetentionDays(executorProperties.getExecutor().getLogretentiondays());

        return xxlJobSpringExecutor;
    }
}
