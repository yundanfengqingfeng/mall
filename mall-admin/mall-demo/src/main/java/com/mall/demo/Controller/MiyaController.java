package com.mall.demo.Controller;

import com.mall.demo.config.ApplicationConfig;
import com.mall.demo.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-11-24 10:51.
 * @RestController 是@Controller 与 @ResponseBody的结合
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class,ApplicationConfig.class})
public class MiyaController {

    @Autowired
    ConfigBean configBean;
    @Autowired
    ApplicationConfig applicationConfig;

    @RequestMapping("/miya")
    public String miya() {

        return configBean.toString();
    }
    @RequestMapping(value = "/applicationConfig",produces = "text/plain;charset=UTF-8")
    public String applicationConfig() {

        return applicationConfig.toString();
    }
}
