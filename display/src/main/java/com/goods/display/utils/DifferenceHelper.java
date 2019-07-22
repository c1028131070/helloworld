package com.goods.display.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
* <pre>类名: DifferenceHelper</pre>
* <pre>描述: 差异化配置类</pre>
* <pre>版权: 浙江理工大学信息学院</pre>
* <pre>日期: 2019/2/27 13:31</pre>
* <pre>作者: chenwb</pre>
*/
@Component
public class DifferenceHelper {

	// 模块名称
	@Value("${diff.module.name}")
	private String moduleName;

	@Value("${spring.activemq.broker-url}")
	private String activeMqUrl;

	/**
	 * 获取moduleName
	 *
	 * @return moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * 设置moduleName
	 *
	 * @param moduleName moduleName
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * 获取activeMqUrl
	 *
	 * @return activeMqUrl
	 */
	public String getActiveMqUrl() {
		return activeMqUrl;
	}

	/**
	 * 设置activeMqUrl
	 *
	 * @param activeMqUrl activeMqUrl
	 */
	public void setActiveMqUrl(String activeMqUrl) {
		this.activeMqUrl = activeMqUrl;
	}
}
