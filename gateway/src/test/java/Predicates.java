import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * 验证predicates各个配置
 * After Before 等用时间
 * Cookie
 */
public class Predicates {

    /**
     * 获取After配置的时间
     */
    @Test
    public void after() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

    /**
     * -Cookie
     * curl http://localhost:9527/common-service/payment/get/1 --cookie "name:zh1991"
     * -Header
     * curl http://localhost:9527/common-service/payment/get/1 -H "X-Request-Id:123"
     */

}
