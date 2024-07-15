package org.example.util;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TD on 2021/2/4
 */
@Configuration
public class SeataFeignInterceptor  implements RequestInterceptor {



    @Override
    public void apply(RequestTemplate requestTemplate) {


        requestTemplate.header(RootContext.KEY_XID, RootContext.getXID());
    }
}
