package com.robust.devtool;

import org.junit.Before;
import org.junit.Test;

public class TestAppManager {

    private AppManager appManager;

    @Before
    public void before() {
        appManager = new AppManager();
    }

    @Test
    public void getTopPkgName() {
        String topPkgName = appManager.getTopPkgName();
        System.out.println("topPkgName: " + topPkgName);
    }

    @Test
    public void getTopClassName() {
        String topActivityName = appManager.getTopActivityName();
        System.out.println("topActivity: " + topActivityName);
    }

    @Test
    public void getTopComponentName() {
        String[] topComponentName = appManager.getTopComponentName();
        System.out.println("pkgName:\t" + topComponentName[0]);
        System.out.println("className:\t" + topComponentName[1]);
    }

    @Test
    public void getApkPath() {
        String pkgName = appManager.getTopPkgName();
        String apkPath = appManager.getApkPath(pkgName);
        System.out.println("apkPath: " + apkPath);
    }

    @Test
    public void pullTopApk() {
        appManager.pullTopApk("");
    }

    @Test
    public void pullTopApk2() {
        appManager.pullTopApk("/Users/chenhewen/Desktop/");
    }
}
