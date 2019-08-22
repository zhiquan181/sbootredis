package com.zhiquan.cai.sbootredis.web;

import com.zhiquan.cai.sbootredis.vi.UserInfo;
import com.zhiquan.cai.sbootredis.service.UserInfoService;
import com.zhiquan.cai.sbootredis.service.RedisService;
import com.zhiquan.cai.sbootredis.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	private RedisService redisService;
	
	@Autowired  
    private UserInfoService userInfoService;

    //Map转换字符串数组
    public static String[] convertMap(Map<String,Object> keyMap,String [] dataList){
        for(int i=0;i<dataList.length;i++){
            for(Map.Entry<String, Object> m:keyMap.entrySet()){
                if(m.getValue().equals(dataList[i])){
                    dataList[i]=m.getKey();
                }
            }
        }
        return dataList;
    }

    @RequestMapping(value="/index")
    public String index(){
        Map<String,Object> keyMap= new HashMap<>();
        keyMap.put("id","编号");
        keyMap.put("username","用户名");
        keyMap.put("password","密码");
        String [] cnCloumn={"编号","用户名","密码"};
        System.out.println("--"+Arrays.asList(convertMap(keyMap, cnCloumn))+"--");//--[id, username, password]--
        return "Hello World";
    }
    
    /**
     * 向redis存储值
     * @param key
     * @param value
     * @return
     * @throws Exception
     * http://localhost:8082/test/set/wangkun/41
     */
    @RequestMapping("/set/{key}/{value}")
    public String set(@PathVariable("key")String key, @PathVariable("value")String value) throws Exception{
        redisService.set(key, value);
        return "Success";
    }  
    
    /**
     * 获取redis中的值
     * @param key
     * @return
     * http://localhost:8082/test/get/wangkun
     */
    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key")String key){
        try {
			return redisService.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "No Data";
    }

    //新增用户
    @RequestMapping(value = "/saveUser/{username}/{password}/{age}" , method = RequestMethod.GET)
    public String putUser(@PathVariable String username,@PathVariable String password,@PathVariable int age){
        try {
            userInfoService.saveData(username,password,age);
            return "Save OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //根据id获取user
    @RequestMapping("/getUser/{id}")  
    public String getUser(@PathVariable String id){
        try {
        	UserInfo user  = userInfoService.findById(id);
			return JsonUtil.getJsonString(user);//返回json字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
    }

    @RequestMapping("/getUserRedis/{id}")
    public String getUserRedis(@PathVariable("id")String id){
        String key = id;
        try {
            String rs = redisService.get(key);
            if (rs == null||rs.equals("")){
                System.out.println("--Redis无此数据--");
                try {
                    UserInfo user  = userInfoService.findById(id);
                    redisService.set(key,JsonUtil.getJsonString(user));//存入redis
                    System.out.println("--调用userInfoService.findById(id) 成功--");
                    return JsonUtil.getJsonString(user);//返回json字符串
                } catch (Exception ee) {
                    System.out.println("--调用userInfoService.findById(id) 失败--");
                    //ee.printStackTrace();
                    return "Exception 2";
                }
            }else{
                System.out.println("--Redis有此数据--");
                return rs;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return "Exception 1";

        }
    }

}
