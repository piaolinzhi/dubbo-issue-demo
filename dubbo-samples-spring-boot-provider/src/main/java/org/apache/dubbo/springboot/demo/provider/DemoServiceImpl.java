/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.springboot.demo.provider;


import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.springboot.demo.DemoService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    /**
     * 序列化测试 ,3.2 以上版本，使用默认序列化库 fastjson2 时，序列化有问题。
     * 需指定 serialization 为 gson 或者 hessian2,其它的没试
     * @param params 无所谓
     * @return Map<Integer,List<Integer>>
     */
    @Override
    public Map<Integer, List<Integer>> testSerialization(List<Integer> params) {
        Map<Integer, List<Integer>> result =new HashMap<>();
        result.put(1, Arrays.asList(-1));
        result.put(2, Arrays.asList(-1));
        return result;
    }

}
