package com.example.serviceribbon;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate1;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate1.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        List list = new ArrayList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.forEach(li -> System.out.print(li) );
        return "hi,"+name+",sorry,error!";
    }

}
