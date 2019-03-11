package com.syfri.gatewayservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = CpjsProperties.CPJS_PREFIX)
public class CpjsProperties {

    public static final String  CPJS_PREFIX = "qycpjs";

    private String savePath = "E://xfxh//upload//";

    private String fileServerUrl= "http://10.119.119.222:80";

    private String vueServerUrl= "http://10.119.119.222:80";

    public String getVueServerUrl() {
        return vueServerUrl;
    }

    public void setVueServerUrl(String vueServerUrl) {
        this.vueServerUrl = vueServerUrl;
    }

    public static String getCpjsPrefix() {
        return CPJS_PREFIX;
    }

    public String getFileServerUrl() {
        return fileServerUrl;
    }

    public void setFileServerUrl(String fileServerUrl) {
        this.fileServerUrl = fileServerUrl;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
