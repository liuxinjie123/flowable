package com.flowable.controller;

import com.flowable.common.CommConstants;
import com.flowable.common.Result;
import io.swagger.annotations.Api;
import org.flowable.common.rest.api.DataResponse;
import org.flowable.rest.service.api.runtime.task.TaskResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Api(tags = "任务相关接口")
@RequestMapping(value = "task")
@RestController
public class TaskController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "list")
    public Result taskList() {
        String url = CommConstants.localhost + ":" + serverPort + "/process-api/runtime/tasks";
        DataResponse<TaskResponse> data = restTemplate.getForObject(url, DataResponse.class);
        return Result.success(data);
    }
}
