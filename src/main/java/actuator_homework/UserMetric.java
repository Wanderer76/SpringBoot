package actuator_homework;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserMetric {

    private final Counter usersOnline;

    public UserMetric(MeterRegistry meterRegistry) {
        usersOnline = meterRegistry.counter("users_online");
    }

    @Scheduled(fixedDelay = 500, initialDelay = 0)
    private void set_query_time() {
        usersOnline.increment(1);
    }

    public double getRequestsCount() {
        return usersOnline.count();
    }

}
