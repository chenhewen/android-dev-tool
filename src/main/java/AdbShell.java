import java.io.IOException;

public class AdbShell {

    public Process dumpsys_window() {
        try {
            return Runtime.getRuntime().exec("adb shell dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Process pm_path(String pkgName) {
        try {
            return Runtime.getRuntime().exec("adb shell pm path " + pkgName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Process pull_apk(String apkPath, String destPath) {
        try {
            return Runtime.getRuntime().exec("adb pull " + apkPath + " " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
