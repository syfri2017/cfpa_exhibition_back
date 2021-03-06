package com.syfri.userservice.config.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * pmsg相关配置
 *
 * @author fengshuonan
 * @date 2018-01-9 9:23
 */
@Configuration
@ConfigurationProperties(prefix = MailProperties.MAIL_PREFIX)
public class MailProperties {
    public static final String MAIL_PREFIX = "mail";
    private String from;
    private String subject;
	private String time;
	private String systemName;
	private String teamName;
	private String text ;

	public String getText() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		StringBuffer sb=new StringBuffer("<html><body>")
				.append("<h3>亲爱的展商用户：</h3>")
				.append("<br><br>")
				.append("您好！感谢您使用")
				.append(systemName)
				.append("，您正在进行邮箱验证，您本次的验证码为：<br>")
				.append("<span style=\"font-size:18px;color:#f90\">%s</span>")
				.append("<span style=\"margin:0;padding:0;margin-left:10px;line-height:30px;")
				.append("font-size:14px;color:#979797;font-family:'宋体',arial,sans-serif\">")
				.append("(为了保障您帐号的安全性，请在")
				.append(time)
				.append("内完成验证。)</span><br><br>")
				.append("第十八届中国国际消防展将于2019年10月16-19日在北京顺义区新国展举行，欢迎您的莅临。</span><br><br>")
				.append(teamName)
				.append("<br>")
				.append(sdf.format(new Date()))
				.append("<br><br>")
				.append("此邮件为自动发送，无需回复。")
				.append("</body>")
				.append("</html>");
		text=sb.toString();
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
