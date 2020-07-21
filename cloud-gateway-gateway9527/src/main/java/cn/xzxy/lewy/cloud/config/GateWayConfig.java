package cn.xzxy.lewy.cloud.config;

import cn.xzxy.lewy.cloud.filter.MyLogGatewayFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 第一个参数为id，不能重复
        routes.route("path_route_lewy",
                r -> r.path("/guonei")
                        //r -> r.path("/guonei/**")  // 支持通配符
                        .uri("http://news.baidu.com/guonei")).build();
        // 以上是一个，可以写多个

//        routes.route("path_route_muller",
//                r -> r.path("/testChain")
//                        .filters(
//                                f -> f.stripPrefix(1)
//                                        .filters(new MyLogGatewayFilter())
//                        ).uri(""));

        return routes.build();
    }
}
