package com.goods.display.jms;

import com.goods.display.api.DTO.ModuleInfoDTO;
import com.goods.display.utils.DifferenceHelper;
import com.goods.display.utils.SystemUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.Serializable;
import java.util.Map;

/**
 * <pre>类名: Consumer</pre>
 * <pre>描述: 消息接收类</pre>
 * <pre>版权: 浙江理工大学信息学院</pre>
 * <pre>日期: 2019/2/25 20:44</pre>
 * <pre>作者: chenwb</pre>
 */
@Component
public class Consumer {

	@Autowired
	SystemUtil systemUtil;

	@Autowired
	DifferenceHelper differenceHelper;

	/**
	 * @param text
	 * @return void
	 * @Description: 消息监听
	 * @author chenwb
	 * @date 2019/2/25 20:46
	 */
	@JmsListener(destination = "getModulesInfo.topic" ,containerFactory = "myJmsContainerFactory")
	@SendTo("modulesInfo.queue")
	public String receiveQueue(String text) {
		System.out.println("Consumer收到的报文为:" + text);
		ModuleInfoDTO moduleInfoDTO = systemUtil.getModuleInfo();
		String result = "";
		result += moduleInfoDTO.getModuleName() + "," + moduleInfoDTO.getModuleIp() + "," + moduleInfoDTO.getModuleLatency() + "," + moduleInfoDTO.getOccupiedRateOfBandwidth() + "," + moduleInfoDTO.getOccupiedRateOfMemory() + "," + moduleInfoDTO.getOccupiedRateOfCpu()+","+moduleInfoDTO.getModuleCondition();

		return result;
/*		ActiveMQConnectionFactory connectionfactory   = new ActiveMQConnectionFactory(differenceHelper.getActiveMqUrl());
		//创建与JMS服务的连接:ConnectionFactory被管理的对象，由客户端创建，用来创建一个连接对象
		Connection connection = connectionfactory.createConnection();//获取连接，connection一个到JMS系统提供者的活动连接
		Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE );//打开会话，一个单独的发送和接受消息的线程上下文
		sendObj(session,moduleInfoDTO,"modulesInfo.queue");*/
	}

	/*
	 * 发送Object类型消息
	 */
/*	public void sendObj(Session session, Object obj, String name) throws JMSException {
		Destination queue = new ActiveMQQueue(name);//分装消息的目的标示
		MessageProducer msgProducer = session.createProducer(queue);
		ObjectMessage objMsg=session.createObjectMessage((Serializable) obj);//发送对象时必须让该对象实现serializable接口
		MessageProducer msgPorducer =session.createProducer(queue);
		msgPorducer.send(objMsg);
		System.out.println("Object类型的消息已发送");

	}*/
}
