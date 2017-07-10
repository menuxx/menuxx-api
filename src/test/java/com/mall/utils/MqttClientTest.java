package com.mall.utils;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

import static org.eclipse.paho.client.mqttv3.MqttConnectOptions.MQTT_VERSION_3_1_1;

/**
 * Created by yinchangsheng on 2017/6/16.
 */
public class MqttClientTest {

    @Test
    public void testPublish() throws MqttException {

        String broker = "ssl://menuxx.mqtt.iot.gz.baidubce.com:1884";

        String clientId = "13575762817a";

        String username = "menuxx/caidanbao";

        String passsword = "1iEyqkx/VeYQjTi7PRz3xF51fYQ9DxboDRDGcRfiDqY=";

        String topic = "order/123456";

        int qos = 1;

        int count = 0;

        MqttClient mqttClient = new MqttClient(broker, clientId);

        MqttConnectOptions options = new MqttConnectOptions();

        options.setAutomaticReconnect(true);

        options.setCleanSession(false);

        options.setKeepAliveInterval(200);

        options.setConnectionTimeout(180);

        options.setMqttVersion(MQTT_VERSION_3_1_1);

        options.setPassword(passsword.toCharArray());

        options.setUserName(username);

        mqttClient.connect(options);

        try {

            while (true) {
                Thread.sleep(2000);
                count++;
                String content = "" + count;
                MqttMessage mqttMessage = new MqttMessage(content.getBytes());
                mqttMessage.setQos(qos);
                mqttClient.publish(topic, mqttMessage);
                System.out.println(count);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}
