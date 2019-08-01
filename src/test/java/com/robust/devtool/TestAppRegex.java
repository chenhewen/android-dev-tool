package com.robust.devtool;

import org.junit.Before;
import org.junit.Test;

public class TestAppRegex {

    private AppRegex appRegex;
    private String testInput;
    private String testInput2;

    @Before
    public void before() {
        appRegex = new AppRegex();
        testInput = "mCurrentFocus=Window{85a52f2 u0 StatusBar}\n" +
                "  mFocuseadApp=AppWindowToken{fde865c token=Token{5151ccf ActivityRecord{2d5092e u0 longbin.helloworld/.HelloWorldActivity t10891}}}";
        testInput2 = "mCurrentFocus=Window{afc884f u0 com.android.mms/com.android.mms.ui.ConversationList}\n" +
                "  mFocusedApp=AppWindowToken{cdf19dd token=Token{3efb9b4 ActivityRecord{4982687 u0 com.android.mms/.ui.ConversationList t10945}}}";
    }

    @Test
    public void parsePkgName() {

        String pkgName = AppRegex.parsePkgName(testInput);
        System.out.println(pkgName);
    }

    @Test
    public void parsePkgName2() {
        String pkgName = AppRegex.parsePkgName(testInput2);
        System.out.println(pkgName);
    }

    @Test
    public void parseClassName() {
        String pkgName = AppRegex.parseClassName(testInput);
        System.out.println(pkgName);
    }

    @Test
    public void parseClassName2() {
        String pkgName = AppRegex.parseClassName(testInput2);
        System.out.println(pkgName);
    }

    @Test
    public void parseApkPath() {
        String testInput = "package:/data/app/longbin.helloworld-ZLXdVCoGMq_fSXyHpWlxiQ==/base.apk";
        String apkPath = AppRegex.parseApkPath(testInput);
        System.out.println(apkPath);
    }
}
