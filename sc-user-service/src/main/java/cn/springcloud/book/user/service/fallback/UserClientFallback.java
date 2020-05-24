package cn.springcloud.book.user.service.fallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.springcloud.book.user.config.DataConfig;
import cn.springcloud.book.user.service.dataservice.DataService;

/**
 *
 */
@Component
public class UserClientFallback implements DataService {

    @Autowired
    private DataConfig dataConfig;

    @Override
    public String getDefaultUser() {
        return new String("get getDefaultUser failed ") + getAppInfo();
    }

    @Override
    public String getContextUserId() {
        return new String("get getContextUserId failed ") + getAppInfo();
    }

    private String getAppInfo() {
        return dataConfig.getApplicationName() + ": " + dataConfig.getPort();
    }
}
