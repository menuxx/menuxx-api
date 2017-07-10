package com.mall.push.pusher;

import com.mall.push.AbstractPusher;
import com.mall.push.ClientInitException;
import com.mall.push.PushState;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.mall.push.Util.randomIntVal;

/**
 * 百度 提供的 IOT Hub mqtt 服务
 */
public class BaiduMqttPusher extends AbstractPusher {

    static final Logger logger = LoggerFactory.getLogger(BaiduMqttPusher.class);

    static final String PUSHER_NAME = "baidu_mqtt";

    MqttClientPersistence persist;

    MqttConnectOptions connOpts;

    MqttClient mqttClient;

    private String broker;

    private String clientId;

    private int qos = 1;

    public BaiduMqttPusher(String broker, String clientId, String username, String password, int timeout, int keepAlive) {
        this.broker = broker;
        this.clientId = clientId;
        persist = new MemoryPersistence();
        connOpts = new MqttConnectOptions();
        // 设置连接选项
        connOpts.setUserName(username);
        connOpts.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
        connOpts.setPassword(password.toCharArray());
        // connOpts.setConnectionTimeout(timeout);
        // connOpts.setKeepAliveInterval(keepAlive);
        connOpts.setAutomaticReconnect(true);
    }

    @Override
    public String getName() {
        return PUSHER_NAME;
    }

    @Override
    public void initialize() throws ClientInitException {
        try {
            mqttClient = new MqttClient(broker, clientId, persist);
            connOpts.setCleanSession(false);
            logger.debug("Connecting to broker: " + broker);
            mqttClient.connect(connOpts);
            logger.debug("Connected");
        } catch(MqttException e) {
            logger.error("mqtt client init failed", e);
        }
    }

    @Override
    public PushState pushToClient(String clientIdTopic, String payload, Map<String, Object> opts) {
        logger.debug("Publishing message: %s to topic: %s", payload, clientIdTopic);
        MqttMessage msg = new MqttMessage(payload.getBytes());
        msg.setQos(qos);
        msg.setId(randomIntVal());
        msg.setRetained(false);
        try {
            mqttClient.publish(clientIdTopic, msg);
            logger.debug("Message published");
            return new PushState(true, "ok", String.valueOf(msg.getId()));
        } catch (MqttException e) {
            logger.debug("Message publish failed", e);
            return new PushState(false, e.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            mqttClient.disconnect();
        } catch (MqttException e) {
            logger.error("push mqtt disconnect failed", e);
        }
    }

}
