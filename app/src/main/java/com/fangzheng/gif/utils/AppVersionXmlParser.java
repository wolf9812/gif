package com.fangzheng.gif.utils;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/03/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AppVersionXmlParser {
    private static final String TAG = "AppVersionXmlParser";

    //示例代码
    public void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlData));
            int eventType = parser.getEventType();
            String id = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("id".equals(nodeName)) {
                            id = parser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("".equals(nodeName)) {
                            Log.i(TAG, "parseXMLWithPull: " + id);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

    }
}
