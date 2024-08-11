package com.it.wang.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    public static final String START_VISIT_TIME = "startVisitTime";

    /**
     * 自定义全局filter
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 在请求的属性中存储当前时间戳（访问开始时间）
        exchange.getAttributes().put(START_VISIT_TIME, System.currentTimeMillis());

        // 继续处理请求，将其传递给过滤器链中的下一个过滤器
        // 当请求处理完成时，执行Mono.fromRunnable中的任务
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            // 从请求的属性中获取开始访问时间
            Long startVisitTime = exchange.getAttribute(START_VISIT_TIME);
            if (startVisitTime != null) {
                // 获取当前时间戳（访问结束时间）
                long endVisitTime = System.currentTimeMillis();
                log.info("=================================================");
                log.info("访问接口主机: {}", exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: {}", exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: {}", exchange.getRequest().getURI().getPath());
                log.info("访问接口参数: {}", exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口耗时: {}ms", (endVisitTime - startVisitTime));
                log.info("=================================================");
            }
        }));


    }

    // 数字越小优先级越高
    @Override
    public int getOrder() {
        return -1;
    }
}
