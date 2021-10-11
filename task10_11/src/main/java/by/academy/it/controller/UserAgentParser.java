package by.academy.it.controller;

public class UserAgentParser {
    public static final String CHROME_PATTERN = "Chrome";
    public static final String EDGE_PATTERN = "Edg";
    public static final String FIREFOX_PATTERN = "Firefox";
    public static final String INTERNET_EXPLORER_PATTERN = "IEMobile";
    public static final String OPERA_PATTERN = "OPR";
    public static final String SAFARI_PATTERN = "Safari";
//    public static final String WEB_VIEW_ANDROID_PATTERN = "";
//    public static final String CHROME_ANDROID_PATTERN= "";
//    public static final String FIREFOX_FOR_ANDROID_PATTERN= "";
//    public static final String OPERA_ANDROID_PATTERN= "";
//    public static final String SAMSUNG_INTERNET_PATTERN= "";

    public static String getBrowser(String agentLine) {

        String browser = "Browser is not recognized.";
        if (agentLine.contains(CHROME_PATTERN)) {
            browser = "Chrome";
        } else if (agentLine.contains(EDGE_PATTERN)) {
            browser = "Edge";
        } else if (agentLine.contains(FIREFOX_PATTERN)) {
            browser = "Firefox";
        } else if (agentLine.contains(INTERNET_EXPLORER_PATTERN)) {
            browser = "Internet Explorer";
        } else if (agentLine.contains(OPERA_PATTERN)) {
            browser = "Opera";
        } else if (agentLine.contains(SAFARI_PATTERN)) {
            browser = "Safari";
        }
        return browser;
    }
}
