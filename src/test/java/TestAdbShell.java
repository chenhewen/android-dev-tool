import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestAdbShell {

    private AdbShell adbShell;

    @Before
    public void init() {
        adbShell = new AdbShell();
    }

    @Test
    public void dumpsys_window() {
        try {
            Process process = adbShell.dumpsys_window();
            String result = ProcessUtil.getResult(process);
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pm_path() {

        try {
            Process process = adbShell.pm_path("longbin.helloworld");
            String result = ProcessUtil.getResult(process);
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pull_apk() {
        String apkPath = "/data/app/longbin.helloworld-ZLXdVCoGMq_fSXyHpWlxiQ==/base.apk";
        String destPath = "";
        adbShell.pull_apk(apkPath, destPath);
    }
}
