package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port="8675";
    private String memory_limit="12G";
    private String index="34";
    private String addr="123.sesame.street";

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory_limit);
        env.put("CF_INSTANCE_INDEX", index);
        env.put("CF_INSTANCE_ADDR", addr);

        return env;

    }


    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit, @Value("${CF_INSTANCE_INDEX:NOT SET}") String index, @Value("${CF_INSTANCE_ADDR:NOT SET}") String addr){
        this.port = port;
        this.memory_limit = memory_limit;
        this.index = index;
        this.addr = addr;

    }
}
