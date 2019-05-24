package ning.zhou.study.springboot.studyspringboot.cas;

import com.gysoft.sso.filter.CustomAuthenticationFilter;
import com.gysoft.sso.filter.CustomCas30ProxyReceivingTicketValidationFilter;
import com.gysoft.sso.filter.KickSameUserFilter;
import com.gysoft.sso.filter.SessionTimeOutFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 周宁
 * @Date 2019-05-24 15:28
 */
@Configuration
public class CasConfig {

    @Value("${cas.server.url.prefix}")
    private String casServerUrlPrefix;
    @Value("${server.name}")
    private String serverName;
    @Value("${cas.server.login.url}")
    private String casServerLoginUrl;

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    /**
     * cas单点登录集成
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<>();
        listener.setEnabled(true);
        listener.setListener(new SingleSignOutHttpSessionListener());
        listener.setOrder(1);
        return listener;
    }

    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new SingleSignOutFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.addInitParameter("casServerUrlPrefix", casServerLoginUrl);
        filterRegistration.setOrder(2);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean sessionTimeOutFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new SessionTimeOutFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(3);
        return filterRegistration;

    }

    @Bean
    public FilterRegistrationBean kickSameUserFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new KickSameUserFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(4);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean customAuthenticationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new CustomAuthenticationFilter());
        filterRegistration.addInitParameter("serverName", serverName);
        filterRegistration.addInitParameter("casServerLoginUrl", casServerLoginUrl);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(5);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean customCas30ProxyReceivingTicketValidationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new CustomCas30ProxyReceivingTicketValidationFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.addInitParameter("serverName", serverName);
        filterRegistration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
        filterRegistration.setOrder(6);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean assertionThreadLocalFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(new AssertionThreadLocalFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(7);
        return filterRegistration;
    }

}
