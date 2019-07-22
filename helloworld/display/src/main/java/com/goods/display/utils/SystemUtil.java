package com.goods.display.utils;

import com.goods.display.api.DTO.ModuleInfoDTO;
import org.hyperic.sigar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class SystemUtil {

	private static Logger logger = LoggerFactory.getLogger(SystemUtil.class);

	@Autowired
	DifferenceHelper differenceHelper;

	long rxBytesLast = 0;
	long txBytesLast = 0;
	long startLast = 0;

	public ModuleInfoDTO getModuleInfo() {
		logger.info("模块名称" + differenceHelper.getModuleName());
		ModuleInfoDTO moduleInfoDTO = new ModuleInfoDTO();
		//模块名称
		moduleInfoDTO.setModuleName(differenceHelper.getModuleName());
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			//模块ip
			moduleInfoDTO.setModuleIp(address.getHostAddress());
			//网络延迟
			long start = System.currentTimeMillis();
			InetAddress.getByName(address.getHostAddress()).isReachable(3000);
			long end = System.currentTimeMillis();
			moduleInfoDTO.setModuleLatency((int) (end - start));
			//带宽使用率
			Sigar sigar = new Sigar();
			String ifNames[] = sigar.getNetInterfaceList();
			long rxBytes = 0;
			long txBytes = 0;
			long end1 = System.currentTimeMillis();
			for (int i = 0; i < ifNames.length; i++) {
				String name = ifNames[i];
				NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
				rxBytes += ifstat.getRxBytes();// 接收到的总字节数  
				txBytes += ifstat.getTxBytes();// 发送的总字节数  
				/*System.out.println(ifstat.getRxBytes()+" "+ifstat.getTxBytes());*/
			}
			moduleInfoDTO.setOccupiedRateOfBandwidth((rxBytes-rxBytesLast)*1000/((end1-startLast)*1024)+"kb/s|"+(txBytes-txBytesLast)*1000/((end1-startLast)*1024)+"kb/s");
			rxBytesLast = rxBytes;
			txBytesLast = txBytes;
			startLast = System.currentTimeMillis();
			//内存使用率
			try {
				Mem men = sigar.getMem();
				moduleInfoDTO.setOccupiedRateOfMemory(men.getUsed()/1024/1024+"MB/"+men.getTotal()/1024/1024+"MB");
			} catch (SigarException e) {
				e.printStackTrace();
				moduleInfoDTO.setOccupiedRateOfMemory("0MB/0MB");
			}

			//cpuInfo
			try {
				CpuInfo infos[] = sigar.getCpuInfoList();
				CpuPerc cpuList[] = sigar.getCpuPercList();
				Double occupiedRateOfCpu = null;
				for (int i = 0, len = infos.length; i < len; i++) {// 不管是单块CPU还是多CPU都适用
					CpuPerc cpu = cpuList[i];
					occupiedRateOfCpu = cpu.getCombined();
				}
				occupiedRateOfCpu*=100;
				moduleInfoDTO.setOccupiedRateOfCpu((double)(Math.round(occupiedRateOfCpu * 100))/100+"");
			} catch (SigarException e) {
				e.printStackTrace();
				moduleInfoDTO.setOccupiedRateOfCpu("0");
			}
			moduleInfoDTO.setModuleCondition(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SigarException e) {
			e.printStackTrace();
		}
		logger.info(moduleInfoDTO.toString());
		return moduleInfoDTO;
	}


}
