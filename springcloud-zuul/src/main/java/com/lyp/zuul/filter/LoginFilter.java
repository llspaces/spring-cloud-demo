package com.lyp.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p>@filename LoginFilter</p>
 * <p>
 * <p>@description TODO</p>
 *
 * @author liyupeng
 * @version 1.0
 * @since 2018/12/4 18:21
 **/
@Component
public class LoginFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求参数中的token
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getParameter("token");
        if(StringUtils.isEmpty(token)){
            //未授权，拒绝访问，返回401
            ctx.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            ctx.setSendZuulResponse(false);
        }
        //校验通过可以把token信息放入上下文，继续执行
        return null;
    }
}
