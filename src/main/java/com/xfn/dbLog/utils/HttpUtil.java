package com.xfn.dbLog.utils;

import com.alibaba.fastjson.JSONObject;
import com.xfn.dbLog.exception.DdException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by xiaobai on 16/12/22.
 * <p>
 * 进行http请求工具类
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static JSONObject httpGetRequest(String urlString) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URI url = new URI(urlString);
            HttpGet get = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //改变由codeEntity转换json字符串方法
                return JSONObject.parseObject(EntityUtils.toString(entity, "UTF-8"));
            } else {
                logger.error("钉钉请求获取数据为null");
                throw new DdException(10005);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            logger.error("钉钉请求URL异常" + e.getMessage());
            throw new DdException(10005);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("钉钉请求IO异常" + e.getMessage());
            throw new DdException(10005);
        }
    }

    public static void reqParTBean(Object bean, Map<String, String> map) throws IllegalAccessException {
        Class clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if (map.get(fieldName) != null) {
                field.set(bean, ConvertUtils.convert(map.get(fieldName), field.getType()));
            }
        }
    }
}
