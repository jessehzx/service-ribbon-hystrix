package top.jessehzx.cloud.serviceribbonhystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jessehzx
 * @Date 2018/4/10
 */
@RestController
public class RibbonConsumerController {

    @Autowired
    private ComputeService computeService;

    @RequestMapping("/add")
    public String add() {
        return computeService.add();
    }

}
