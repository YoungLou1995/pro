package com.cernet.pro.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cernet.pro.mapper.*;
import com.cernet.pro.model.*;
import com.cernet.pro.service.DataFromAppTKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class DataFromAppController {

    @Autowired
    private DataFromAppMapper dataFromAppMapper;

    @Autowired
    private DataFromAppTKService dataFromAppTKService;

    @Autowired
    private ActionsPredictMapper actionsPredictMapper;

    @Autowired
    private UrlsPredictMapper urlsPredictMapper;

    @Autowired
    private Url2AppMapper url2AppMapper;

    @PostMapping("/dataFromApp")
    @ResponseBody
    // Receive data from App and insert them into Table-DataFromApp
    public void dataFromApp(@RequestBody String jsonString){
        JSONArray jsonArray = JSON.parseArray(jsonString);

        int insertCount = 0;
        DBIndex dbIndex = new DBIndex();
        Date time= new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<DataFromApp> dataFromAppList = new ArrayList<>();
        String formatTime = format.format(time);
        if (jsonArray!=null && jsonArray.size()!=0){

            for (Object ja: jsonArray) {
                DataFromApp dataFromApp = JSON.toJavaObject((JSON) ja, DataFromApp.class);
                dataFromApp.setSystemTime(formatTime);
                dataFromAppList.add(dataFromApp);
//                dataFromAppMapper.insert(dataFromApp);
                insertCount++;

            }

            dataFromAppTKService.insetList(dataFromAppList);
        }

        //get url from dataFromApp and insert into Table-url2app
        Random random = new Random(100);
        List<Url2App> url2AppList = dataFromAppMapper.url2AppList();
        for (Url2App url2App : url2AppList) {
            int isok = dataFromAppMapper.isOk(url2App.getUrl());
            url2App.setProperty(isok);
//            url2App.setSystemTime(formatTime);
            float randomFloat = (float) (random.nextInt(100)/200.0);
            url2App.setPropertyNum((float) (0.5+randomFloat));
        }

        for (Url2App url2App : url2AppList) {
            url2AppMapper.insert(url2App);
        }



//        // get url from datafromapp
//        int start = dataFromAppMapper.getCount();
//        int maxId = dataFromAppMapper.getMaxId();
//
//        List<UrlsPredict> urlsPredictList = dataFromAppMapper.UrlPredictList((maxId-insertCount));
//
//
//        // get action from datafromapp
//        List<ActionsPredict> actionsPredictList = dataFromAppMapper.ActionsPredictList((maxId-insertCount));
//

        //////////////////////////////////////
        // call Python-action model and get result
        int dbMaxId = dataFromAppMapper.getMaxId();
//        int dbDataCount = dataFromAppMapper.getCount();
        dbIndex.setStart(dbMaxId-insertCount);
        dbIndex.setEnd(dbMaxId);
        List<Integer> rangeData = dataFromAppMapper.getRangeData(dbIndex);
        System.out.println("rangeData.size():"+rangeData.size());

////        // call Python server
//        org.json.JSONObject jsonParam = new org.json.JSONObject();
////        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0));
//
////        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList());
//
//        jsonParam.put("yoyo", rangeData);
////        System.out.println(jsonParam);
//        String url="http://127.0.0.1:5000";
//        String data=GetJsonData.getJsonData(jsonParam,url);
//        System.out.println("Done");
//        JSONObject jsonObject = JSON.parseObject(data);
//        String result = jsonObject.getString("result");
//        System.out.println(result);



        // Insert into table actionsPredict



////


//
//        int index = 0;
//        for (ActionsPredict actionsP : actionsPredictList) {
//            if (index<22){
//                ActionsPredict actionsPredict = new ActionsPredict();
//                actionsPredict.setActionName(actionList.get(index%22));
//                actionsPredict.setAppName(appList.get(index%22));
//                actionsPredict.setSystemTime(formatTime);
//                index++;
//
//                actionsPredictMapper.insert(actionsPredict);
//            }
//
//
//        }


        // insert into table urlsPredict

        int maxId = dataFromAppMapper.getMaxId();
        List<UrlsPredict> urlsPredictList = dataFromAppMapper.UrlPredictList((maxId-insertCount));
        for (UrlsPredict predict : urlsPredictList) {
            UrlsPredict urlsPredict = new UrlsPredict();
            urlsPredict.setAppName(predict.getAppName());
            urlsPredict.setSystemTime(formatTime);
            urlsPredict.setUrl(predict.getUrl());
            urlsPredict.setIPV(predict.getIPV());

            int ok = dataFromAppMapper.isOk(predict.getUrl());
            if (ok == 1){
                urlsPredict.setType("恶意");
            }
            else {
                urlsPredict.setType("善意");
            }





            urlsPredictMapper.insert(urlsPredict);
        }



//
//        dbIndex.setStart(dbDataCount);
//        dbIndex.setEnd(insertCount+dbDataCount);
//        List<Integer> rangeData = dataFromAppMapper.getRangeData(dbIndex);
////        System.out.println(rangeData);
//
//        // call Python server
//        JSONObject jsonParam = new JSONObject();
////        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0));
//
////        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList());
//
//        jsonParam.put("yoyo", rangeData);
////        System.out.println(jsonParam);
//        String url="http://127.0.0.1:5000";
//        String data=GetJsonData.getJsonData(jsonParam,url);
//        System.out.println("Done");
//        JSON parse = (JSON)JSON.parse(data);
//        System.out.println(parse);
//

    }

    @GetMapping("/dataFromApp")
    @ResponseBody
    public JSON dataFromApp(){
        List<DataFromApp> dataFromAppList = dataFromAppMapper.list();
        JSON js = (JSON)JSON.toJSON(dataFromAppList);
        return js;
    }
}
