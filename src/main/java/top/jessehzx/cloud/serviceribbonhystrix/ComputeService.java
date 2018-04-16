package top.jessehzx.cloud.serviceribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jessehzx
 * @date 2018/4/16
 */
@Service
public class ComputeService {

    @Autowired
    private RestTemplate restTemplate;

    //    @RequestMapping("/add")
    @HystrixCommand(fallbackMethod = "addFallback")
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=2&b=3", String.class).getBody();
    }

    public String addFallback() {
        return "sorry, error!";
    }

}
