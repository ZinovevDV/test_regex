package ru.mail.zinovev_dv.test_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    protected static final String XML_ATTR_PIS_PREFIX_ISVC = "isvc:";
    protected static final String ISVC_ADDRESS_REGEX_GROUP = "isvcAddress";
    protected static final String ISVC_NAME_REGEX_GROUP = "isvcName";
    protected static final String ISVC_NAME_REGEX = "(?<" + ISVC_NAME_REGEX_GROUP + ">[a-zA-Z]+[a-zA-Z-]*[a-zA-Z0-9-]+)";
    protected static final String ISVC_PORT_REGEX_GROUP = "isvcPort";
    protected static final String ISVC_PORT_REGEX = "(:(?<" + ISVC_PORT_REGEX_GROUP + ">\\d{2,4}))?";
    protected static final String ISVC_VERSION_REGEX_GROUP = "isvcVersion";
    protected static final String ISVC_VERSION_REGEX = "/(?<" + ISVC_VERSION_REGEX_GROUP + ">(\\d{1,3}\\.\\d{1,3}|\\Q{[latest]}\\E)))";

    protected static final String ISVC_ADDRESS_REGEX = "(?<" + ISVC_ADDRESS_REGEX_GROUP + ">" + ISVC_NAME_REGEX + ISVC_PORT_REGEX + ISVC_VERSION_REGEX;
    protected static final String TO_TARGET_ISVC_REGEX = XML_ATTR_PIS_PREFIX_ISVC + ISVC_ADDRESS_REGEX;

    protected static final Pattern XML_NODE_TO_ISVC_ATTR_PATTERN = Pattern.compile(TO_TARGET_ISVC_REGEX);


    public static void main(String[] args) {
        String elementToUriValue = "isvc:pis-is-unarchiver/{[latest]}";
        //String elementToUriValue = "isvc:pis-is-unarchiver/1.0";

        System.out.println(TO_TARGET_ISVC_REGEX);
        var result = Pattern.matches(TO_TARGET_ISVC_REGEX, elementToUriValue);
        System.out.println(result);

        Matcher isvcMatcher = XML_NODE_TO_ISVC_ATTR_PATTERN.matcher(elementToUriValue);
        if (isvcMatcher.find()) {
            String isvcName = isvcMatcher.group(ISVC_NAME_REGEX_GROUP);
            String isvcVersion = isvcMatcher.group(ISVC_VERSION_REGEX_GROUP);
            System.out.println(isvcMatcher.groupCount());
            System.out.println(isvcMatcher.group(0));
            System.out.println(isvcMatcher.group(1));
            System.out.println(isvcMatcher.group(2));
            System.out.println(isvcMatcher.group(3));
            System.out.println(isvcMatcher.group(4));
            System.out.println(isvcMatcher.group(5));
            System.out.println("isvc version:" + isvcVersion);
            System.out.println("isvcName:" + isvcName);
        }
    }
}
